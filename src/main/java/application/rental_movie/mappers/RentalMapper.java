package application.rental_movie.mappers;

import application.rental_movie.dto.RentalDTO;
import application.rental_movie.entities_models.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    public Rental DTOtoRental(RentalDTO rentalDTO) {
        if (rentalDTO == null) {
            return null;
        } else {
            Rental rental = new Rental();
            rental.setPenalty(rentalDTO.getPenalty());
            rental.setId(rentalDTO.getId());
            rental.setReturned(rentalDTO.isReturned());
            rental.setMovie(rentalDTO.getMovie());
            rental.setReturnDate(rentalDTO.getReturnDate());
//            rental.setUser(rentalDTO.getUser());
            rental.setRentalDate(rentalDTO.getRentalDate());
            return rental;
        }
    }

    public RentalDTO rentalToDTO(Rental rental) {

        if (rental == null) {
            return null;
        } else {
            RentalDTO rentalDTO = new RentalDTO();
            rentalDTO.setPenalty(rental.getPenalty());
            rentalDTO.setId(rental.getId());
            rentalDTO.setReturned(rental.isReturned());
            rentalDTO.setMovie(rental.getMovie());
            rentalDTO.setReturnDate(rental.getReturnDate());
//            rentalDTO.setUser(rental.getUser());
            rentalDTO.setRentalDate(rental.getRentalDate());
            return rentalDTO;
        }
    }
//
//    // var 2
//    @Override
//    public RentalDTO rentalToDTO (Rental entity) {
//        RentalDTO dto =RentalDTO.builder()
//                .id(entity.getId())
//                .movie(entity.getMovie())
//                .rentalDate(entity.getRentalDate())
//                .returnDate(entity.getReturnDate())
//                .penalty(entity.getPenalty())
//                .user(entity.getUser())
//                .build();
//        return dto;
//    }
//
//    // var 2
//    @Override
//    public Rental DTOtoRental(RentalDTO rentalDTO) {
//        Rental rental = Rental.builder()
//                .id(rentalDTO.getId())
//                .movie(rentalDTO.getMovie())
//                .rentalDate(rentalDTO.getRentalDate())
//                .returnDate(rentalDTO.getReturnDate())
//                .penalty(rentalDTO.getPenalty())
//                .user(rentalDTO.getUser())
//                .build();
//
//        return rental;
//    }
}
