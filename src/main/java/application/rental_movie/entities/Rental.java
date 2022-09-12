package application.rental_movie.entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

    public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;

    @Column(name = "rental_date")
    private Date rentalDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "rental_cost")
    private Double rental_cost;

    @Column(name = "returned")
    private Boolean returned;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
