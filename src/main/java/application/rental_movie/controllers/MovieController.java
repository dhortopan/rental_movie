package application.rental_movie.controllers;

import application.rental_movie.dto.MovieDTO;
import application.rental_movie.services.MovieService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movie")

public class MovieController {
    private final MovieService movieService;

//    @Autowired
//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Finds all movies mapped to DTO.
     *
     * @return list of all movies
     */
    @GetMapping("all")
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<MovieDTO> findAll() {
        return movieService.findAll();
    }

    /**
     * Allows to create new movies
     *
     * @param movieDTO movie that has to be created
     * @return created movie
     */
    @PostMapping("/create")
//    @Secured("ROLE_ADMIN")
    public MovieDTO create(@Valid @RequestBody MovieDTO movieDTO) {
        return movieService.create(movieDTO);
    }

    /**
     * Deletes movie by given id
     *
     * @param id movie's id that has to be deleted
     * @return true is movie has been removed, otherwise false
     */
    @DeleteMapping("/{id}")
//    @Secured("ROLE_ADMIN")
    public boolean deleteById(@PathVariable ("id") Long id) {
        return movieService.deleteById(id);}

//    public void deleteById(Long id) {
//         movieService.deleteById(id);}


    /**
     * Deletes movie by given object
     *
     * @param movie
     * @return
     */
    @DeleteMapping
//    @Secured("ROLE_ADMIN")
    public boolean delete(@RequestBody MovieDTO movie) {
        return movieService.delete(movie);
    }
}
