package application.rental_movie.repositories;

import application.rental_movie.entities.Employee;
import application.rental_movie.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    @Override
    Optional<Employee> findById(Integer integer);

    // pt security
    Employee findByEmail(String email);
}
