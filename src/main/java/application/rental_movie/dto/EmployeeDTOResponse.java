package application.rental_movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDTOResponse {

    private Integer employee_id;

    private String name;

    private Integer age;

    private String password;

    private String phoneNumber;

    private String address;

    private String email;

    private Integer employmentYear;

//    private Boolean isAvailable;
}
