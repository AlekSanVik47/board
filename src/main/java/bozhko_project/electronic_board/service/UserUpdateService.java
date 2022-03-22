package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class UserUpdateService {
	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final UserMapper userMapper;

	public void userUpdateParam(int id, String login){
		//userRepository.loginUpdate(login, id);

	}
	public UserUpdateDTO userUpdateD (Long id, UserUpdateDTO dto){
		User user = userRepository.findById(id).orElse(null);
		user.setLogin(dto.getLogin());
		//userMapper.updateUser(dto, user);
		user.setStatus(Status.NEW);
		userRepository.saveAndFlush(user);
		return userMapper.userToUserDTO(user);
	}
}
