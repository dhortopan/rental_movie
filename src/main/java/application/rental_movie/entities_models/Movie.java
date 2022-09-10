package application.rental_movie.entities_models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "director", length = 50)
    @NotBlank
    private String director;

    @Column(name = "title", length = 100)
    @NotBlank
    private String title;


    @Column(name = "launch_date")
    @NotNull
    private LocalDate launchDate;


    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name = "borrowed")
    private boolean borrowed;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Rental> rental;
}
