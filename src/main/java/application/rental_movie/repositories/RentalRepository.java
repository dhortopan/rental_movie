package application.rental_movie.repositories;

import application.rental_movie.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findAll();
    List<Rental> findByRentalDate(Date rentalDate);
    List<Rental> findByReturnDate(Date returnDate);
    @Override
    Optional<Rental> findById(Integer integer);}
