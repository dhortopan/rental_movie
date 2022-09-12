package application.rental_movie.mappers;

import application.rental_movie.dto.UserDTOResponse;
import application.rental_movie.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {
    public UserDTOResponse map(User user) {
        return UserDTOResponse.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .age(user.getAge())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .userLocked(user.isUserLocked())
                .userRole(user.getUserRole())
                .build();
    }

}
