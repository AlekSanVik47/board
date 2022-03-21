package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Data
public class UserUpdateService {
	@Autowired
	private final UserRepository userRepository;

	public void userUpdateParam(Integer id, String login, UserUpdateDTO dto){
		userRepository.userLoginUpdate(id, login);

	}
}
