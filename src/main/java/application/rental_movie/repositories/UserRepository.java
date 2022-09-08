package application.rental_movie.repositories;



import application.rental_movie.entities_models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);

}

