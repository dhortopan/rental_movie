package application.rental_movie.controllers;

import application.rental_movie.dto.RentalDTO;
import application.rental_movie.entities_models.Movie;
import application.rental_movie.entities_models.Rental;
import application.rental_movie.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rent")
@CrossOrigin
public class RentalController {

    private final RentalService rentalService;

//    @Autowired
//    public RentalController(RentalService rentalService) {
//        this.rentalService = rentalService;
//    }

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/return/all")
//    @PreAuthorize("isAuthenticated")
    public List<RentalDTO> findAll() {
        return rentalService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("isAuthenticated")
    public RentalDTO rentMovie(@PathVariable("id") Movie movie) {
        return rentalService.create(movie);
    }

    @GetMapping("/return/{id}")
//    @PreAuthorize("isAuthenticated")
    public RentalDTO returnMovie(@PathVariable("id") Rental rental) {
        return rentalService.returnMovie(rental);
    }

}
