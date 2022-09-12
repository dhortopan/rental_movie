package application.rental_movie.dto;

import application.rental_movie.entities.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTORequest {

    @NotBlank
    @Schema(description = "Name of the user", example = "John Mark",required = true)
    private String name;

    @NotNull
    @Schema(description = "Age of the user", example = "20",required = true)
    private Integer age;

    @Schema(description = "Password of the user", example = "fgdj12!@7y!")
    private String password;


    @NotBlank
    @Schema(description = "Phone number of the user", example = "(471) 123456",required = true)
    private String phoneNumber;

    @Schema(description = "Address of the user", example = "New York, no.5")
    private String address;

    @NotBlank
    @Schema(description = "Email of the user", example = "xxxx@outlook.com",required = true)
    private String email;

    @Schema(description = "Checking if the user is enabled", example = "John Mark")
    @NotNull
    private Boolean enabled;

    @Schema(description = "Checking if the user is locked", example = "John Mark")
    private boolean userLocked;

    @Schema(description = "Checking user role", example = "John Mark")
    private UserRole userRole;

}
