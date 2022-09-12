package application.rental_movie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalDTORequest {

    @Schema(description = "Rental date", example = "2022-04-17")
    private Date rentalDate;

    @Schema(description = "Return date", example = "2022-07-01")
    private Date returnDate;

    @Schema(description = "Rental cost", example = "2.05")
    private Double rental_cost;

    @Schema(description = "Checking returning of the movie", example = "true")
    private Boolean returned;

}
