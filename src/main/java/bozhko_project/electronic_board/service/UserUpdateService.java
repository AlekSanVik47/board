package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.entities.User;
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

	public void  userUpdateLoginDB (Long id, UserUpdateDTO dto) throws AssertionError {
		User user = userRepository.findById(id).orElse(null);
		if (user == null) throw new AssertionError();
		user.setLogin(dto.getLogin());
		userRepository.saveAndFlush(user);
	}

	public void userAccountUpdate( UserUpdateDTO dto, Integer id){
		User user = userMapper.updateUser(dto,id);
		user.setStatus(Status.valueOf("NEW"));
		user.setRole(User.Role.valueOf("USER"));
		user.setState(User.State.valueOf("CONFIRMED"));
		userRepository.saveAndFlush(user);
	}

}
