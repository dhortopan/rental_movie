package application.rental_movie.entities_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserType;

import javax.persistence.*;


@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private UserType userType;


    @Enumerated(EnumType.STRING)
    private UserType userType;


    public enum UserType {
        ROLE_ADMIN,
        ROLE_USER
    }
}
