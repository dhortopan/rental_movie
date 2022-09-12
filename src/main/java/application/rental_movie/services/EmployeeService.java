package application.rental_movie.services;

import application.rental_movie.dto.EmployeeDTORequest;
import application.rental_movie.dto.EmployeeDTOResponse;
import application.rental_movie.entities.Employee;
import application.rental_movie.mappers.EmployeeRequestMapper;
import application.rental_movie.mappers.EmployeeResponseMapper;
import application.rental_movie.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeResponseMapper mapper;
    private final EmployeeRequestMapper requestMapper;
    public List<EmployeeDTOResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public EmployeeDTOResponse findById(Integer id) {
        return mapper.map(employeeRepository.findById(id).get());
    }
    public List<EmployeeDTOResponse> findByName(String name) {
        return employeeRepository.findByName(name).stream()
                .map(walker -> mapper.map(walker))
                .collect(Collectors.toList()); }
    public EmployeeDTOResponse save(EmployeeDTORequest employeeRequest) {
        Employee mappedEmployee = requestMapper.map(employeeRequest);
        employeeRepository.save(mappedEmployee);
        return mapper.map(mappedEmployee);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDTOResponse update(Integer id,EmployeeDTORequest employeeRequest) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) {
            Employee oldEmployee = employeeById.get();
            oldEmployee.setName(employeeRequest.getName());
            oldEmployee.setAge(employeeRequest.getAge());
            oldEmployee.setPassword(employeeRequest.getPassword());
            oldEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
            oldEmployee.setAddress(employeeRequest.getAddress());
            oldEmployee.setEmail(employeeRequest.getEmail());
            oldEmployee.setEmploymentYear(employeeRequest.getEmploymentYear());


            Employee saved = employeeRepository.save(oldEmployee);

            return mapper.map(saved);
        } else

            throw new UnsupportedOperationException("Invalid Id : " + id);

    }

    public EmployeeDTOResponse updatePassword(Integer id, String password) {
        Employee employeeFromDataBase = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Employee does not exist with id : " + id));

        employeeFromDataBase.setPassword(password);

        Employee saved = employeeRepository.save(employeeFromDataBase);

        return mapper.map(saved);
    }

    public EmployeeDTOResponse updatePhoneNumber(Integer id, String phoneNumber) {

        Employee employeeFromDataBase = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Employee found with id : " + id));

        employeeFromDataBase.setPhoneNumber(phoneNumber);
        Employee saved = employeeRepository.save(employeeFromDataBase);

        return mapper.map(saved);
    }

    public EmployeeDTOResponse updateAddress(Integer id, String address) {

        Employee employeeFromDataBase = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Employee found with id : " + id));

        employeeFromDataBase.setAddress(address);
        Employee employee = employeeRepository.save(employeeFromDataBase);

        return mapper.map(employee);
    }

    public EmployeeDTOResponse updateEmail(Integer id, String email) {
        Employee employeeFromDataBase = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Employee found with id : " + id));

        employeeFromDataBase.setEmail(email);
        Employee employee = employeeRepository.save(employeeFromDataBase);

        return mapper.map(employee);
    }
}
