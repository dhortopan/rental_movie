package application.rental_movie.mappers;

import application.rental_movie.dto.EmployeeDTOResponse;
import application.rental_movie.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResponseMapper {

    public EmployeeDTOResponse map(Employee employee) {

        return EmployeeDTOResponse.builder()
                .employee_id(employee.getEmployee_id())
                .name(employee.getName())
                .age(employee.getAge())
                .password(employee.getPassword())
                .phoneNumber(employee.getPhoneNumber())
                .address(employee.getAddress())
                .email(employee.getEmail())
                .employmentYear(employee.getEmploymentYear())
                .build();
    }
}
