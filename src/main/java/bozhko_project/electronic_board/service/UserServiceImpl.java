package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.entities.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private final UserMapper userMapper;

	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public User findByUserLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Transactional
	@Override
	public boolean save(UserCreationDTO creationDTO) {
		User user = userMapper.userCreationRequestToUser(creationDTO);
		if (findByUserLogin(creationDTO.getLogin())!=null) {
			return false;
		}
		user.setStatus(Status.valueOf("NEW"));
		user.setRole(User.Role.valueOf("USER"));
		user.setState(User.State.valueOf("CONFIRMED"));
		userRepository.save(user);
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByLogin(login));
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
		return new UserDetailsImpl(user);
	}
}
