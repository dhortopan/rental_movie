package application.rental_movie.mappers;

import application.rental_movie.dto.UserDTO;
import application.rental_movie.entities_models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User DTOtoUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            return user;
        }
    }

    public UserDTO userToDTO(User user) {
        if (user == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setPasswordConfirm(user.getPassword());
            return userDTO;
        }
    }


}
