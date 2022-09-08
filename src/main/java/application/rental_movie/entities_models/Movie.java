package application.rental_movie.entities_models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
//import com.sun.istack.NotNull;


@Entity
//@Table(name = "books")
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "author", length = 50)
    @Column(name = "director", length = 50)
    @NotBlank
    private String director;

    @Column(name = "title", length = 100)
    @NotBlank
    private String title;

    @NotNull
//    private LocalDate publishDate;
    private LocalDate launchDate;

//    @Column(name = "page_number")
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
