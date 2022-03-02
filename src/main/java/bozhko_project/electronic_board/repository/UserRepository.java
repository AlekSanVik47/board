package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    List<User> allUsers();
    String findBySurname (String nick);
}
