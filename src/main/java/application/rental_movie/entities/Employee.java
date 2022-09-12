package application.rental_movie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "employment_year")
    private Integer employmentYear;



    @OneToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User users;
}
