package application.rental_movie.entities_models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rental")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

    public class Rental {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "rental_date")
        private LocalDate rentalDate;

        @Column(name = "return_date")
        private LocalDate returnDate;

        @Column(name = "returned")
        private boolean returned;

        @Column(name = "penalty")
        private Float penalty;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @ManyToOne
        @JoinColumn(name = "movie_id", nullable = false)
        private Movie movie;

}
