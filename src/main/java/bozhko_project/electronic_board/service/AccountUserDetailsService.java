package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.entities.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
/*

@Service
@RequiredArgsConstructor
public class AccountUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Qualifier
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByLogin(login));
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return new UserDetailsImpl(user);
    }

    public boolean createUser(UserDetailsImpl userDetailsI) {
        User user = new User();
        if (getUserLogin(userDetailsI.getUsername()) != null) {
            return false;
        }
        user.setLogin(userDetailsI.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDetailsI.getPassword()));
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setRole(user.getRole());
        userRepository.save(user);
        return true;
    }
}
*/
