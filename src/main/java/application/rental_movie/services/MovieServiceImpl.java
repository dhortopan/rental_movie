package application.rental_movie.services;

import application.rental_movie.dto.MovieDTO;
import application.rental_movie.entities_models.Movie;
import application.rental_movie.mappers.MovieMapper;
import application.rental_movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("movieService")
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

//    @Autowired
//    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
//        this.movieRepository = movieRepository;
//        this.movieMapper = movieMapper;
//    }

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    // returns dto with added id from db

    /**
     * Creates new movie from given dto as parameter and stores in database.
     * Thid method uses mapper to convert entity to dto and in reverse
     *
     * @param movieDTO movie that has to be created
     * @return entity that has been created, mapped to dto
     */
    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        if (movieDTO != null) {
            Movie mapped = movieMapper.DTOtoMovie(movieDTO);
            return movieMapper.MovieToDTO(movieRepository.save(mapped));
        }
        return null;
    }

    /**
     * Returns all movies stored in database
     * @return list of movies mapped to dto
     */
    @Override
    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::MovieToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Removes movie stored in db by given dto
     * This method checks whether movie stored movie exists, and returns
     * true if movie was removed successfully, otherwise false
     *
     * @param movieDTO movie that has to be removed
     * @return result of removing
     */
    @Override
    public boolean delete(MovieDTO movieDTO) {
        if (movieDTO != null) {
            if (movieRepository.existsById(movieDTO.getId())){
                Movie mapped = movieMapper.DTOtoMovie(movieDTO);
                movieRepository.delete(mapped);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes movie stored in db by given ID
     * This method checks whether movie stored book exists, and returns
     * true if book was removed successfully, otherwise false
     *
     * @param id id of movie that has to be removed
     * @return result of removing
     */
    @Override
    public boolean deleteById(Long id) {
        if (id != null && movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Updates existing movie entity.
     *
     * @param movie movie with new values to be updated
     * @return updated book mapped to dto
     */
    @Override
    public MovieDTO update(MovieDTO movie) {
        if (movie != null) {
            Movie mapped = movieMapper.DTOtoMovie(movie);
            return movieMapper.MovieToDTO(movieRepository.save(mapped));
        }
        return null;
    }
}
