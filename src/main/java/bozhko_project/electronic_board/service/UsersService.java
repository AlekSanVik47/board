package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.exception.CannotEditOtherUsersException;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public UserUpdateDTO userUpdate(Integer userId, UserUpdateDTO request) {
		User user = userMapper.updateUser(request, userId);
		userRepository.save(user);
		return userMapper.userToUserDTO(user);
	}

	private void checkCurrentUserUpdatePermission(Integer userId) throws CannotEditOtherUsersException {
		UserDTO currentUser =getCurrentUser();
		Optional<User> optionalUser = userRepository.findById(userId);
				if (optionalUser.isPresent()&&!optionalUser.get().getPhone().equals(currentUser.getNick())&&!currentUser.getRole().equals("ADMIN")){
					throw new CannotEditOtherUsersException();
				}
	}
	private UserDTO getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		String nick = securityContext.getAuthentication().getPrincipal().toString();
		String role = securityContext.getAuthentication().getAuthorities().stream().findAny().get().getAuthority();
		return new UserDTO(nick, role);
	}



}



