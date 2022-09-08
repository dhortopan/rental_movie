package application.rental_movie.dto;

import application.rental_movie.entities_models.Movie;
import application.rental_movie.entities_models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalDTO {

    private Long id;

    @NotNull
    private Movie movie;

    @NotNull
    private LocalDate rentalDate;

    @NotNull
    private LocalDate returnDate;
    private boolean returned;

    @NotNull
    private User user;

    @PositiveOrZero
    private Float penalty;

//    public Float getPenalty() {
//    }
}
