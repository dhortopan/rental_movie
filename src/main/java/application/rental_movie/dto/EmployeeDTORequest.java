package application.rental_movie.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class EmployeeDTORequest {

    @NotBlank
    @Schema(description = "Name of the employee", example = "Mick Jordan", required = true)
    private String name;

    @NotNull
    @Schema(description = "Age of the employee", example = "20", required = true)
    private Integer age;

    @Schema(description = "Password of the employee", example = "sawe!234%")
    private String password;


    @NotBlank
    @Schema(description = "Phone number of the employee", example = "64-784-2547", required = true)
    private String phoneNumber;

    @Schema(description = "Address of the employee", example = "New York, nr.10", required = true)
    private String address;

    @NotBlank
    @Schema(description = "Email address of the employee", example = "mick@gmail.com", required = true)
    private String email;

    @Schema(description = "Years of experience of the input Model", example = "3")
    private Integer employmentYear;

}
