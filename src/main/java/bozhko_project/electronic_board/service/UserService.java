package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends UserDetailsService {
	User findByUserLogin (String login);
	@Transactional
	boolean saveUser(UserCreationDTO creationDTO);
}
