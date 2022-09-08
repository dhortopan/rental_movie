package application.rental_movie.repositories;

import application.rental_movie.dto.RentalDTO;
import application.rental_movie.entities_models.Rental;
import application.rental_movie.entities_models.User;
import application.rental_movie.entities_models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByUser(User user);

    List<Rental> findAll();

//    void save(Rental build);
}
