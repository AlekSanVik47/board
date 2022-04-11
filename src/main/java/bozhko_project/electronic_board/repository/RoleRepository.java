package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.user_entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    Optional<Role> findById(Long aLong);

    Role findByRole(String role);
}