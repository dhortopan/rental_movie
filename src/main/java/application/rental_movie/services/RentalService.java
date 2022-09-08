package application.rental_movie.services;

import application.rental_movie.dto.RentalDTO;
import application.rental_movie.entities_models.Movie;
import application.rental_movie.entities_models.Rental;

import java.util.List;

public interface RentalService {

    List<RentalDTO> findAll();

    RentalDTO create(Movie movie);

    RentalDTO returnMovie(Rental rental);
}
