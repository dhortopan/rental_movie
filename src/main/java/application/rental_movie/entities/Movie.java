package application.rental_movie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "director")
    private String director;

    @NotNull
    @Column(name = "launched_year")
    private Integer launchedYear;

    @Column(name = "category", nullable = false)
    private String category;


    @Column(name = "borrowed", nullable = false)
    private Boolean borrowed;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
//    @JsonIgnore
//    @ToString.Exclude
    private final List<Rental> rental =new ArrayList<>();

}
