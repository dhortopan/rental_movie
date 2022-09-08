package application.rental_movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {

    private Long id;

    @NotBlank
    private String director;

    @NotBlank
    private String title;

    @NotNull
    private LocalDate launchDate;


    @NotNull
    private String category;

    private boolean borrowed;
}
