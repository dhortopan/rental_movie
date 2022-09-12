package application.rental_movie.mappers;

import application.rental_movie.dto.MovieDTORequest;
import application.rental_movie.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper {

    public Movie map(MovieDTORequest movie) {
        return Movie.builder()
                .name(movie.getName())
                .director(movie.getDirector())
                .launchedYear(movie.getLaunchedYear())
                .category(movie.getCategory())
                .borrowed(movie.getBorrowed())
                .build();
    }

}
