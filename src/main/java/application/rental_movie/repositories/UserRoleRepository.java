package application.rental_movie.repositories;

import application.rental_movie.entities_models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByUserType(UserRole.UserType usertype);
}
