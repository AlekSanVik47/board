package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserAuthDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Controller
@RequestMapping 
@RequiredArgsConstructor
@Tag(name = "UserController", description = "API контролера по работе с пользователями")
@Validated
public class UserController {
@Autowired
private final UsersService usersService;
@Autowired
private final UserMapper userMapper;
@Autowired
private final UserRepository userRepository;

   @Operation(description = " Получение списка зарегистрированных пользователей")
    @GetMapping(
            value = "/user/all-users/{users}"
    )
    public ResponseEntity<List<User>> getUsers (
           @PathVariable(name = "users")  String users){
       List<User> allUsers = usersService.getRegisteredUsers();
       return   ResponseEntity.ok(allUsers);
   }
   /* public ResponseEntity<List<User>> getAllUsers(
            @PathVariable(name = "all-users") String users) {
        List<User> allUsers = usersService.getRegUsers("all-users");
        return ResponseEntity.ok(allUsers);
   }*/
   @Operation(description = " Получение пользователя по номеру телефона")
   @GetMapping(value = "/user/by-phone/{phone}")
    public ResponseEntity <User> getUserByPhone (@PathVariable (name = "phone") String phone){
       return  ResponseEntity.ok(usersService.getUserByPhone(phone));
   }
    @Operation(description = "Обновление пользователя")
    @PutMapping(
            value = "/v1/users/{userId}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<UserUpdateDTO> updateUser (
            @Parameter(description = "Идентификатор пользователя", required = true)
            @PositiveOrZero @PathVariable("userId") int userId,
            @Parameter(description = "Запрос на обновление пользователя")
            @Valid @RequestBody(required = false) UserUpdateDTO request){
       return ResponseEntity.ok(usersService.userUpdate(userId,request ));
    }
    public UserUpdateDTO getById(Integer userId){
       return userMapper.userToUserDTO(userRepository.getById(userId));
    }

    @Operation(description = "Авторизация пользователя")
    @PostMapping(value = "/user/authorization",
    produces = {"application/json"},
    consumes = {"application/json"})
    public ResponseEntity<User> userAuthorization(
            @Parameter(description = "Запрос на авторизацию")
            @Valid @RequestBody UserAuthDTO request) {
return  ResponseEntity.ok(usersService.getUserMapper().userAuth(request));
    }


}
