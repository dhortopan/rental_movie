package application.rental_movie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTORequest {

    @NotBlank
    @Schema(description = "Name of the movie", example = "Butterfly", required = true)
    private String name;

    @NotNull
    @Schema(description = "Director of the movie", example = "Mark Smith", required = true)
    private String director;

    @NotNull
    @Schema(description = "Launched year of the movie", example = "2022", required = true)
    private Integer launchedYear;

    @Schema(description = "Category of the movie", example = "Romance")
    private String category;


    @Schema(description = "Checking availability of the movie", example = "true", required = true)
    private Boolean borrowed;

}
