package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserDTO;
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

	public UserDTO createUser(UserCreationDTO request){
		User user = userMapper.userCreationRequestToUser(request);
		userRepository.save(user);
		return userMapper.toUserDTO(user);
	}
}
