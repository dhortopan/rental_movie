package application.rental_movie.controllers;

import application.rental_movie.dto.EmployeeDTORequest;
import application.rental_movie.dto.EmployeeDTOResponse;
import application.rental_movie.services.EmployeeService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeDTOResponse> findAll() {
        return employeeService.findAll();
    }


    @GetMapping("name")
    public List<EmployeeDTOResponse> findByName(@RequestParam(name = "name") String name) {
        return employeeService.findByName(name); }

    @PostMapping
    public EmployeeDTOResponse save(@Parameter(description = "Documented Model used as input for POST")
                               @Valid @RequestBody EmployeeDTORequest employeeDTORequest) {
        return employeeService.save(employeeDTORequest); }


    @PutMapping("{id}")
    public EmployeeDTOResponse update(@PathVariable("id") Integer id, @RequestBody EmployeeDTORequest employeeDTORequest)
    {return employeeService.update(id, employeeDTORequest); }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
    }

}
