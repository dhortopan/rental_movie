package application.rental_movie.mappers;

import application.rental_movie.dto.RentalDTOResponse;
import application.rental_movie.entities.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalResponseMapper {

    public RentalDTOResponse map(Rental rental) {
        return RentalDTOResponse.builder()
                .rentalId(rental.getRentalId())
                .rentalDate(rental.getRentalDate())
                .returnDate(rental.getReturnDate())
                .rental_cost(rental.getRental_cost())
                .returned(rental.getReturned())
                .build();
    }

}
