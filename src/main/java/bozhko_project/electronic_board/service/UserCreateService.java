package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserCreationDTO;
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
public class UserCreateService {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserMapper userMapper;



	public void createUser(UserCreationDTO request){
		User user = userMapper.userCreationRequestToUser(request);
		User.Role role = User.Role.valueOf("USER");
		User.State state = User.State.valueOf("CONFIRMED");
		user.setLogin(request.getLogin());
		user.setPassword(request.getPassword());
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		user.setRole(role);
		user.setState(state);
		userRepository.saveAndFlush(user);
	}

}
