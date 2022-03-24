package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User findByUserLogin (String login);
	boolean save (UserCreationDTO creationDTO);
}
