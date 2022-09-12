package application.rental_movie.services;


import application.rental_movie.dto.MovieDTORequest;
import application.rental_movie.dto.MovieDTOResponse;
import application.rental_movie.entities.Movie;
import application.rental_movie.mappers.MovieRequestMapper;
import application.rental_movie.mappers.MovieResponseMapper;
import application.rental_movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("movieService")
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieResponseMapper mapper;
    private final MovieRequestMapper requestMapper;
    public List<MovieDTOResponse> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());    }
    public MovieDTOResponse findById(Integer id) {
        return mapper.map(movieRepository.findById(id).get());
    }

    public List<MovieDTOResponse> findByName(String name) {
        return movieRepository.findByName(name).stream()
                .map(mapper::map)
                .collect(Collectors.toList());    }

    public MovieDTOResponse save(MovieDTORequest movieRequest) {
        Movie mappedMovie = requestMapper.map(movieRequest);
        movieRepository.save(mappedMovie);
        return mapper.map(mappedMovie);  }

    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }

    public MovieDTOResponse update(Integer id, MovieDTORequest movieRequest) {

        Optional<Movie> movieFromDataBase = movieRepository.findById(id);
        if (movieFromDataBase.isPresent()) {
            Movie movieToBeUpdated = movieFromDataBase.get();
            movieToBeUpdated.setName(movieRequest.getName());
            movieToBeUpdated.setDirector(movieRequest.getDirector());
            movieToBeUpdated.setLaunchedYear(movieRequest.getLaunchedYear());
            movieToBeUpdated.setCategory(movieRequest.getCategory());
            movieToBeUpdated.setBorrowed(movieRequest.getBorrowed());

            Movie saved = movieRepository.save(movieToBeUpdated);
            return mapper.map(saved);

        } else {
            throw new UnsupportedOperationException("Movie with id: " + id + " is not present in the DataBase ");

        }
    }

    public MovieDTOResponse updateLaunchedYear(Integer id, Integer year) {
        Movie movieFromDataBase = movieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Non existing movie with id : " + id));

        movieFromDataBase.setLaunchedYear(year);
        Movie saved = movieRepository.save(movieFromDataBase);

        return mapper.map(saved);
    }

}
