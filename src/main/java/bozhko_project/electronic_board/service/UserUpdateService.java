package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class UserUpdateService {
	@Autowired
	private final UserRepository userRepository;

	public void  userUpdateLoginDB (Long id, UserUpdateDTO dto) throws AssertionError {
		User user = userRepository.findById(id).orElse(null);
		if (user == null) throw new AssertionError();
		user.setLogin(dto.getLogin());
		userRepository.saveAndFlush(user);
	}

	public void userAccountUpdate(Long id, UserUpdateDTO dto){
		User user = userRepository.findById(id).orElse(null);
		if (user == null) throw new AssertionError();
		userRepository.updateAccount(dto.getLogin(), dto.getPassword(), dto.getEmail(), dto.getPhone(), id);
		userRepository.saveAndFlush(user);
	}

}
