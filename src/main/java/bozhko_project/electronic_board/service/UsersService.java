package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class UsersService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;
    private static final  int DEFAULT_PAGE_SIZE=10;

    public void getUserByPhone(String phone) {
        userRepository.findUserByPhone(phone);
    }

   /* public List<UserRegistrationDTO> getRegisteredUsers (Integer limit){
return userRepository.findAll(PageRequest.of(0, limit==null ? DEFAULT_PAGE_SIZE : limit)).stream()
        .map(userMapper:: userRegDTO).collect(Collectors.toList());
    }*/
    public List<User> getRegUsers(String users){
        return  userRepository.findAll();
    }
}
