package application.rental_movie.mappers;

import application.rental_movie.dto.RentalDTORequest;
import application.rental_movie.dto.RentalDTOResponse;
import application.rental_movie.entities.Rental;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class RentalRequestMapper {

    public Rental map(RentalDTORequest rentalRequest) {
        return Rental.builder()
                .rentalDate((Date) rentalRequest.getRentalDate())
                .returnDate((Date) rentalRequest.getReturnDate())
                .rental_cost(rentalRequest.getRental_cost())
                .returned(rentalRequest.getReturned())
                .build();
    }

}
