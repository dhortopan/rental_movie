package application.rental_movie.controllers;

import application.rental_movie.dto.MovieDTORequest;
import application.rental_movie.dto.MovieDTOResponse;
import application.rental_movie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
@Validated

public class MovieController {
    private final MovieService movieService;

//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    /**
     * Finds all movies mapped to DTO.
     *
     * @return list of all movies
     */
    @GetMapping("all")

    public List<MovieDTOResponse> findAll() {
        return movieService.findAll();
    }

    /**
     * Finds movie by id mapped to DTO.
     *
     * @return  movie by id
     */
    @GetMapping("{id}")
    public MovieDTOResponse findById(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    /**
     * Finds movies mapped to DTO by name.
     *
     * @return list of movies by name
     */
    @GetMapping("name")
    public List<MovieDTOResponse> findByName(@RequestParam String name) {
        return movieService.findByName(name);
    }

    /**
     * Allows to create new movies
     *
     * @param movieDTO movie that has to be created
     * @return created movie
     */
    @PostMapping()

    public MovieDTOResponse create(@Valid @RequestBody MovieDTORequest movieDTO) {
        return movieService.save(movieDTO);
    }

    /**
     * Allows to update new movie
     *
     * @param movieDTORequest movie that has to be updated
     * @return updated movie
     */

    @PutMapping("{id}")
    public MovieDTOResponse update(@PathVariable("id") Integer id, @RequestBody MovieDTORequest movieDTORequest) {
        return movieService.update(id, movieDTORequest);
    }

    /**
     * Deletes movie by given id
     *
     * @param id movie's id that has to be deleted
     * @return true is movie has been removed, otherwise false
     */
    @DeleteMapping("{id}")

    public void delete(@PathVariable("id") Integer id) {
        movieService.delete(id);}

}
