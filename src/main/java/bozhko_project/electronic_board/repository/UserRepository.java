package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> allUsers();

//    List<User> findBySurname(String phone);
}