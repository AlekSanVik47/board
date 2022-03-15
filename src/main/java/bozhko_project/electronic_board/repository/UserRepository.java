package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 User findUserByPhone (String phone);
 User findUserByEmail (String email);
 User findUserByNick(String nick);
}