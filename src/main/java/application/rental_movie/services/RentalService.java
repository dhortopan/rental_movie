package application.rental_movie.services;


import application.rental_movie.dto.RentalDTORequest;
import application.rental_movie.dto.RentalDTOResponse;
import application.rental_movie.entities.Movie;
import application.rental_movie.entities.Rental;
import application.rental_movie.mappers.RentalRequestMapper;
import application.rental_movie.mappers.RentalResponseMapper;
import application.rental_movie.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("rentalService")
@RequiredArgsConstructor
public class RentalService  {
    private final RentalRepository repository;
    private final RentalResponseMapper mapper;
    private final RentalRequestMapper requestMapper;
    public List<RentalDTOResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());    }
    public List<RentalDTOResponse> findByRentalDate(Date date) {
        return repository.findByRentalDate(Date.valueOf(date.toString()))
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());    }
    public List<RentalDTOResponse> findByReturnDate(Date date) {
        return repository.findByReturnDate(Date.valueOf(date.toString()))
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());    }
    public RentalDTOResponse save(RentalDTORequest rentalRequest) {
        Rental rentalToBeSaved = requestMapper.map(rentalRequest);
        repository.save(rentalToBeSaved);
        return mapper.map(rentalToBeSaved);    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public RentalDTOResponse update(Integer id, RentalDTORequest rentalRequest) {
        Optional<Rental> rentalFromDataBase = repository.findById(id);
        if (rentalFromDataBase.isPresent()) {
            Rental rentalToBeUpdated = rentalFromDataBase.get();
            rentalToBeUpdated.setRentalDate(rentalRequest.getRentalDate());
            rentalToBeUpdated.setReturnDate(rentalRequest.getReturnDate());
            rentalToBeUpdated.setRental_cost(rentalRequest.getRental_cost());
            rentalToBeUpdated.setReturned(rentalRequest.getReturned());

            Rental saved = repository.save(rentalToBeUpdated);

            return mapper.map(saved);
        } else {
            throw new UnsupportedOperationException("No rental found with id : " + id);
        }
    }

    public RentalDTOResponse updateReturnDate(Integer id, Date date) {

        Rental rentalFromDataBase = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No rental found with id : " + id));

        rentalFromDataBase.setReturnDate(date);

        Rental saved = repository.save(rentalFromDataBase);

        return mapper.map(saved);
    }

    public RentalDTOResponse updateRentalDate(Integer id, Date date) {
        Rental rentalFromDataBase = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No rental found with id : " + id));

        rentalFromDataBase.setRentalDate(date);

        Rental saved = repository.save(rentalFromDataBase);

        return mapper.map(saved);
    }

    public RentalDTOResponse updateRentalCost(Integer id, Double cost) {
        Rental rentalFromDataBase = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Order found with id : " + id));

        rentalFromDataBase.setRental_cost(cost);

        Rental saved = repository.save(rentalFromDataBase);

        return mapper.map(saved);
    }

}
