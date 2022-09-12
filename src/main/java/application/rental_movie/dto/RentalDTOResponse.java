package application.rental_movie.dto;

import application.rental_movie.entities.Movie;
import application.rental_movie.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Date;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalDTOResponse {

    private Integer rentalId;

    private Date rentalDate;

    private Date returnDate;

    private Boolean returned;

    private Double rental_cost;

}
