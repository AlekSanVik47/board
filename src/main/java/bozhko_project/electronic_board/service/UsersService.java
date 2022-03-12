package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import bozhko_project.electronic_board.dto.UserDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class UsersService {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserMapper userMapper;

	public User getUserByPhone(String phone) {
		return getUserRepository().findUserByPhone(phone);
	}

	public List<User> getRegisteredUsers() {
		return userRepository.findAll();
	}


	public UserDTO userUpdate(Integer userId, UserUpdateDTO request) {
		User user = userMapper.updateUser(request, userId);
		userRepository.save(user);
		return userMapper.userToUserDTO(user);

	}

}



