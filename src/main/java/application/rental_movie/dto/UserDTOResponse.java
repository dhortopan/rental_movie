package application.rental_movie.dto;

import application.rental_movie.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTOResponse {

    private Integer user_id;

    private String name;

    private Integer age;

    private String password;

    private String phoneNumber;

    private String address;

    private String email;

    private boolean enabled;

    private boolean userLocked;

    private UserRole userRole;

}
