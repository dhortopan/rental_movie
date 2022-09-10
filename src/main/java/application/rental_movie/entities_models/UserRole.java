package application.rental_movie.entities_models;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String userType;


    @Enumerated(EnumType.STRING)
    private UserType userType;


    public enum UserType {
        ROLE_ADMIN,
        ROLE_USER
    }
}
