package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.for_board.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByNick(nick));
		User user = userOptional.orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
		return new UserDetailsImpl(user);
	}
}
