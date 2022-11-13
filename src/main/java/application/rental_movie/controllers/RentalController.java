package application.rental_movie.controllers;

import application.rental_movie.dto.RentalDTORequest;
import application.rental_movie.dto.RentalDTOResponse;
import application.rental_movie.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
@Validated
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/all")
//    @PreAuthorize("isAuthenticated")
    public List<RentalDTOResponse> findAll() {
        return rentalService.findAll();
    }

    @GetMapping("/returnDate")
    public List<RentalDTOResponse> findRentalByReturnDate(@RequestParam(name="returnDate") Date date) {
        return rentalService.findByReturnDate(date);
    }

    @GetMapping("/rentalDate")
    public List<RentalDTOResponse> findRentalByRentalDate(@RequestParam(name = "rentalDate") Date date) {
        return rentalService.findByRentalDate(date);
    }

    @PostMapping
    public RentalDTOResponse save(@RequestBody RentalDTORequest rentalDTORequest) {
        return rentalService.save(rentalDTORequest);
    }


    @PutMapping("{id}")
    public RentalDTOResponse update(@PathVariable("id") Integer id, @RequestBody RentalDTORequest rentalDTORequest) {
        return rentalService.update(id, rentalDTORequest);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        rentalService.delete(id);
    }
}
