package bozhko_project.electronic_board.repository.user_rep;

import bozhko_project.electronic_board.entities.user_entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    Optional<Role> findById(Long aLong);

    Role findByRole(String role);
}