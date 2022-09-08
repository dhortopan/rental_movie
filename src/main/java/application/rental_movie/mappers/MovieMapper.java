package application.rental_movie.mappers;

import application.rental_movie.dto.MovieDTO;
import application.rental_movie.entities_models.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO MovieToDTO(Movie movie) {
        if (movie == null) {
            return null;
        } else {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setDirector(movie.getDirector());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setBorrowed(movie.isBorrowed());
            movieDTO.setCategory(movie.getCategory());
            movieDTO.setLaunchDate(movie.getLaunchDate());

            return movieDTO;
        }
    }

    public Movie DTOtoMovie(MovieDTO movieDTO) {
        if (movieDTO == null) {
            return null;
        } else {
            Movie movie = new Movie();
            movie.setId(movieDTO.getId());
            movie.setDirector(movieDTO.getDirector());
            movie.setTitle(movieDTO.getTitle());
            movie.setBorrowed(movieDTO.isBorrowed());
            movie.setCategory(movieDTO.getCategory());
            movie.setLaunchDate(movieDTO.getLaunchDate());

            return movie;
        }
    }

    //var 2
//    public Movie DTOtoMovie(MovieDTO movieDTO) {
//        return Movie.builder()
//                .id(movieDTO.getId())
//                .director(movieDTO.getDirector())
//                .title(movieDTO.getTitle())
//                .borrowed(movieDTO.isBorrowed())
//                .category(movieDTO.getCategory())
//                .launchDate(movieDTO.getLaunchDate())
//                .build();
//    }

}
