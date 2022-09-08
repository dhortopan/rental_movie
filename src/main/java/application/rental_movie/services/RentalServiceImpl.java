package application.rental_movie.services;

import application.rental_movie.dto.RentalDTO;
import application.rental_movie.entities_models.Movie;
import application.rental_movie.entities_models.Rental;
import application.rental_movie.entities_models.User;
import application.rental_movie.mappers.MovieMapper;
import application.rental_movie.mappers.RentalMapper;
import application.rental_movie.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service("rentalService")
public class RentalServiceImpl {
    private final MovieService movieService;

    private final RentalRepository rentalRepository;

    private final float FIRST_WEEK_PENALTY = 3.00f;

    private final int RENT_PERIOD = 10;

    private final float DAILY_PENALTY = 0.7f;

    private final MovieMapper movieMapper;

    private final RentalMapper rentalMapper;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository,
                             MovieService movieService,
                             MovieMapper movieMapper,
                             RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.rentalMapper = rentalMapper;
    }

    /**
     * Returns list of all rents mapped to dto
     *
     * @return list of rents
     */
    @Override
    public List<RentalDTO> findAll() {
        return rentalRepository.findAll()
                .stream()
                .map(rentalMapper::rentalToDTO)
                .collect(Collectors.toList());
    }

    /**
     * This method creates new rent for given movies as parameter and updates
     * that movie's status to borrowed.
     * User has two weeks to return borrowed movie.
     *
     * @param movie movie that rent will be created for
     * @return created rent
     * @throws RuntimeException when user has penalty, or the movie is already borrowed
     */
    @Override
//    @Transactional
    public RentalDTO create(Movie movie) {
        if (hasPenalty(getCurrentUser()))
            throw new RuntimeException("You can't borrow a movie because you have a penalty");
        if (movie != null) {
            if (movie.isBorrowed())
                throw new RuntimeException("You can't rent a borrowed book");

            movie.setBorrowed(true);
            movieService.update(movieMapper.MovieToDTO(movie));
            LocalDate actualDate = LocalDate.now();
            return rentalMapper.rentalToDTO(rentalRepository.save(
                            Rental.builder()
                                    .movie(movie)
                                    .rentalDate(actualDate)
                                    .returnDate(actualDate.plusDays(RENT_PERIOD))
                                    .returned(false)
                                    .user(getCurrentUser())
                                    .penalty(0f)
                                    .build()
                    )
            );
        }
        return null;
    }

    /**
     * This method allows users to return rented movies
     * If user exceeded the return date, the rent will get calculated penalty
     * for first week 2$, and 0.5$ for each day after that period
     *
     * @param rental rental for movie that will be returned
     * @return rental mapped to dto
     * @throws RuntimeException when rental is null
     */
    @Override
    public RentalDTO returnMovie(Rental rental) {
        if (rental != null) {
            if (!rental.isReturned()) {
                Movie rentMovie = rental.getMovie();
                rentMovie.setBorrowed(false);
                movieService.update(movieMapper.MovieToDTO(rentMovie));
                rental.setReturned(true);

                LocalDate actualDate = LocalDate.now();
                float penalty = 0;
                if (actualDate.isAfter(rental.getReturnDate())) {
                    long days = Duration.between(rental.getReturnDate().atStartOfDay(), actualDate.atStartOfDay()).toDays();
                    if (days > 0) {
                        penalty = days <= 7
                                ? FIRST_WEEK_PENALTY
                                : FIRST_WEEK_PENALTY + (days - 7) * DAILY_PENALTY;
                    }
                }
                rental.setPenalty(penalty);
            }
            return rentalMapper.rentalToDTO(rentalRepository.save(rental));
        } else {
            throw new RuntimeException("Incorrent rental!");
        }
    }

    /**
     * Checks whether given user has penalty.
     *
     * @param user user to check penalty
     * @return true if user has penalty, otherwise false
     */
    private boolean hasPenalty(User user) {
        return rentalRepository.findAllByUser(user)
                .stream()
                .filter(e -> !e.isReturned())
                .anyMatch(e -> LocalDate.now().isAfter(e.getReturnDate()));
    }

    /**
     * @return currently logged in user
     */
    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
