package application.rental_movie.mappers;

import application.rental_movie.dto.EmployeeDTORequest;
import application.rental_movie.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequestMapper {

    public Employee map(EmployeeDTORequest employeeRequest) {
        return Employee.builder()
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .password(employeeRequest.getPassword())
                .phoneNumber(employeeRequest.getPhoneNumber())
                .address(employeeRequest.getAddress())
                .email(employeeRequest.getEmail())
                .employmentYear(employeeRequest.getEmploymentYear())
                .build();
    }
}
