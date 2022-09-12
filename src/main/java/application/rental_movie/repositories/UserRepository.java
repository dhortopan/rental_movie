package application.rental_movie.repositories;



import application.rental_movie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   List<User> findByName(String name);

   @Override
   Optional<User> findById(Integer integer);

}

