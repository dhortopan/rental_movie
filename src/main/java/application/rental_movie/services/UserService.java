package application.rental_movie.services;

import application.rental_movie.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserDTO> findAll();

    UserDTO create(UserDTO userDTO);

    boolean delete(UserDTO userDTO);

    boolean deleteById(Long id);

    boolean hasAdminRole();

    boolean isLoginCorrect(String username, String password);
}
