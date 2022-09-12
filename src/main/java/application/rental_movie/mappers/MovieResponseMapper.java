package application.rental_movie.mappers;

import application.rental_movie.dto.MovieDTOResponse;
import application.rental_movie.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper {

    public MovieDTOResponse map(Movie movie) {
        return MovieDTOResponse.builder()
                .movie_id(movie.getMovie_id())
                .name(movie.getName())
                .director(movie.getDirector())
                .launchedYear(movie.getLaunchedYear())
                .category(movie.getCategory())
                .borrowed(movie.getBorrowed())
                .build();
    }
}
