package application.rental_movie.controllers;

import application.rental_movie.dto.UserDTORequest;
import application.rental_movie.dto.UserDTOResponse;
import application.rental_movie.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<UserDTOResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping({"/{id}"})
    public UserDTOResponse findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/name")
    public List<UserDTOResponse> findByName(@RequestParam(name = "name") String name) {
        return userService.findByName(name);
    }

    @PostMapping
    public UserDTOResponse create(@Valid @RequestBody UserDTORequest userDTORequest) {
        return userService.save(userDTORequest);
    }

    @PutMapping("{id}")
    public UserDTOResponse update(@PathVariable(value = "id") Integer id, @RequestBody UserDTORequest userDTORequest) {
        return userService.update(id, userDTORequest);
    }


    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

}
