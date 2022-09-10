package application.rental_movie.repositories;

import application.rental_movie.entities_models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
   void deleteById(Long id);

}
