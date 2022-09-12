package application.rental_movie.mappers;

import application.rental_movie.dto.UserDTORequest;
import application.rental_movie.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {

    public User map(UserDTORequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .password(userRequest.getPassword())
                .phoneNumber(userRequest.getPhoneNumber())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .enabled(userRequest.getEnabled())
                .userLocked(userRequest.isUserLocked())
                .userRole(userRequest.getUserRole())
                .build();


    }

}
