package application.rental_movie.entities_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

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
//        private User user;
        private UserRole user;

        @ManyToOne
        @JoinColumn(name = "movie_id", nullable = false)
        private Movie movie;

}
