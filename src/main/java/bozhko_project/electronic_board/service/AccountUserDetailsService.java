package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.for_board.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public User  getUserLogin (String login){
		return userRepository.findUserByLogin(login);
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByLogin(login));
		User user = userOptional.orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
		return new UserDetailsImpl(user);
	}

	public boolean createUser(UserDetailsImpl userDetails){
		User user = new User();
		if (getUserLogin(userDetails.getUsername())!= null){
			return false;
		}
		user.setLogin(userDetails.getUsername());

	}
}
