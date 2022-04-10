package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.dto_user.Status;
import bozhko_project.electronic_board.dto.dto_user.UserAuthDTO;
import bozhko_project.electronic_board.dto.dto_user.UserCreationDTO;
import bozhko_project.electronic_board.dto.dto_user.UserUpdateDTO;
import bozhko_project.electronic_board.entities.authorization.UserDetailsImpl;

import bozhko_project.electronic_board.entities.user_entities.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Component
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private final UserMapper userMapper;
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Transactional
	@Override
	public User findByUserLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Transactional
	@Override
	public boolean saveUser(UserCreationDTO creationDTO) {
		User user = userMapper.userCreationToUser(creationDTO);
		if (findByUserLogin(creationDTO.getLogin()) != null) {
			return false;
		}
		user.setPassword(passwordEncoder.encode(creationDTO.getPassword()));
		user.setStatusId(Status.NEW);
		user.setRole_id(User.Role.USER);
		user.setState(User.State.CONFIRMED);
		userRepository.save(user);
		return true;
	}


	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByLogin(login));
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
		return new UserDetailsImpl(user);
	}

	public User getUserByPhone(String phone) {
		return userRepository.findUserByPhone(phone);
	}

	public List<User> getRegisteredUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.getById(id);
	}

	public void userUpdateLoginDB(Long id, UserUpdateDTO dto) throws AssertionError {
		User user = userRepository.findById(id).orElse(null);
		if (user == null) throw new AssertionError();
		user.setLogin(dto.getLogin());
		userRepository.saveAndFlush(user);
	}

	public void userAccountUpdate(UserUpdateDTO dto, Integer id) {
		User user = userMapper.updateUser(dto, id);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setStatusId(Status.NEW);
		user.setRole_id(User.Role.USER);
		user.setState(User.State.CONFIRMED);
		userRepository.saveAndFlush(user);
	}

	@Transactional
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	public void authUser(UserAuthDTO dto) {
		User user = userRepository.findUserByLogin(dto.getLogin());
		if (dto.getPassword().equals(user.getPassword())) {
			userMapper.userAuthDTO(dto);
		}
	}
}



//	private void checkCurrentUserUpdatePermission(Integer userId) throws CannotEditOtherUsersException {
//		UserDTO currentUser =getCurrentUser();
//		Optional<User> optionalUser = userRepository.findById(userId);
//				if (optionalUser.isPresent()&&!optionalUser.get().getPhone().equals(currentUser.getLogin())&&!currentUser.getRole().equals("ADMIN")){
//					throw new CannotEditOtherUsersException();
//				}
//	}
//	private UserDTO getCurrentUser() {
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		String login = securityContext.getAuthentication().getPrincipal().toString();
//		String role = securityContext.getAuthentication().getAuthorities().stream().findAny().get().getAuthority();
//		return new UserDTO(login, role);
//	}

