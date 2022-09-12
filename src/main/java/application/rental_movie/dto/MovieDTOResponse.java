package application.rental_movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTOResponse {

    private Integer movie_id;
    @NotBlank
    private String name;
    @NotBlank
    private String director;
    @NotNull
    private Integer launchedYear;
    @NotNull
    private String category;
    private boolean borrowed;
}
