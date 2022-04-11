package bozhko_project.electronic_board.repository.user_rep;

import bozhko_project.electronic_board.entities.user_entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	@Override
	Optional<State> findById(Long aLong);

	State findByState(String state);

}