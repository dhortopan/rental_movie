package application.rental_movie.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "user_locked")
     private boolean userLocked;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;



    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rental> rentals;


    @OneToOne
    @JoinColumn(name = "employee_id", nullable=false)
    private Employee employees;

}
