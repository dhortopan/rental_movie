package application.rental_movie.repositories;

import application.rental_movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByName(String name);
   @Override
   Optional<Movie> findById(Integer integer);

}
