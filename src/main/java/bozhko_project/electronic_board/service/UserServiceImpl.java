package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.entities.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
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
		User user = new User();
		if (findByUserLogin(creationDTO.getLogin())!=null) {
			return false;
		}
		User.Role role = User.Role.valueOf("USER");
		User.State state = User.State.valueOf("CONFIRMED");
		user.setId(creationDTO.getId());
		user.setLogin(creationDTO.getLogin());
		user.setPassword(creationDTO.getPassword());
		user.setName(creationDTO.getName());
		user.setSurname(creationDTO.getSurname());
		user.setEmail(creationDTO.getEmail());
		user.setPhone(creationDTO.getPhone());
		user.setRole(role);
		user.setState(state);

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
