package application.rental_movie.services;

import application.rental_movie.dto.UserDTORequest;
import application.rental_movie.dto.UserDTOResponse;
import application.rental_movie.entities.User;
import application.rental_movie.mappers.UserRequestMapper;
import application.rental_movie.mappers.UserResponseMapper;
import application.rental_movie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    private final UserResponseMapper mapper;

    private final UserRequestMapper requestMapper;

    public List<UserDTOResponse> findAll() {
        return userRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public UserDTOResponse findById(Integer id) {
        return mapper.map(userRepository.findById(id).get());
    }

    public List<UserDTOResponse> findByName(String name) {
        return userRepository.findByName(name).stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public UserDTOResponse save(UserDTORequest userRequest) {
        User mappedUser = requestMapper.map(userRequest);
        userRepository.save(mappedUser);
        return mapper.map(mappedUser);
    }


    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public UserDTOResponse update(Integer id, UserDTORequest userRequest) {

        Optional<User> userFromDataBase = userRepository.findById(id);

        if (userFromDataBase.isPresent()) {

            log.info("User was found in the database");

            User userToBeUpdated = userFromDataBase.get();
            userToBeUpdated.setName(userRequest.getName());
            userToBeUpdated.setAge(userRequest.getAge());
            userToBeUpdated.setPassword(userRequest.getPassword());
            userToBeUpdated.setPhoneNumber(userRequest.getPhoneNumber());
            userToBeUpdated.setAddress(userRequest.getAddress());
            userToBeUpdated.setEmail(userRequest.getEmail());
            userToBeUpdated.setEnabled(userRequest.getEnabled());
            userToBeUpdated.setUserLocked(userRequest.isUserLocked());
            userToBeUpdated.setUserRole(userRequest.getUserRole());

            User savedUser = userRepository.save(userToBeUpdated);
            log.info("User was mapped to the database");
            return mapper.map(savedUser);
        } else
            log.error("User was not found in the database");
        throw new UnsupportedOperationException("No User with id : " + id);
    }


    public UserDTOResponse updatePassword(Integer id, String password) {
        User userFromDataBase = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User does not exist with id : " + id));

        userFromDataBase.setPassword(password);

        User saved = userRepository.save(userFromDataBase);

        return mapper.map(saved);
    }

    public UserDTOResponse updatePhoneNumber(Integer id, String phoneNumber) {

        User userToBeUpdated = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id : " + id));

        userToBeUpdated.setPhoneNumber(phoneNumber);
        User saved = userRepository.save(userToBeUpdated);

        return mapper.map(saved);
    }

    public UserDTOResponse updateAddress(Integer id, String address) {

        User userToBeUpdated = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id : " + id));

        userToBeUpdated.setAddress(address);
        User user = userRepository.save(userToBeUpdated);

        return mapper.map(user);
    }

    public UserDTOResponse updateEmail(Integer id, String email) {
        User userToBeUpdated = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id : " + id));

        userToBeUpdated.setEmail(email);
        User user = userRepository.save(userToBeUpdated);

        return mapper.map(user);
    }

    public UserDTOResponse updateUserStatus(Integer id, String blocked) {
        User userToBeUpdated = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id : " + id));

        userToBeUpdated.setUserLocked(Boolean.parseBoolean(blocked));
        User user = userRepository.save(userToBeUpdated);

        return mapper.map(user);
    }

}
