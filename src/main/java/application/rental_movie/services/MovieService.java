package application.rental_movie.services;

import application.rental_movie.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    //POST method
    MovieDTO create(MovieDTO movieDTO);

    // READ method
    List<MovieDTO> findAll();

    //DELETE method
    boolean delete(MovieDTO movieDTO);

    boolean deleteById(Long id);

//    void deleteById(Long id);


    // UPDATE method
    MovieDTO update(MovieDTO movie);
}
