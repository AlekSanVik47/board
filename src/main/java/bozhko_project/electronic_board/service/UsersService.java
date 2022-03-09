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

    public User getUserByPhone(String phone) {
        return getUserRepository().findUserByPhone(phone);
    }

    public List<User> getRegisteredUsers() {
        return userRepository.findAll();
    }


}
/*    public List<User> getRegUsers(String users){
        return  userRepository.findAll();
    }*/
    /*public UserRegistrationDTO getUserByPhone (String phone){
        return userMapper.userRegDTO(userRepository.findUserByPhone(phone).orElse(null));*/



