package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.dto_user.UserAuthDTO;
import bozhko_project.electronic_board.dto.dto_user.UserCreationDTO;
import bozhko_project.electronic_board.dto.dto_user.UserUpdateDTO;
import bozhko_project.electronic_board.entities.user_entities.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "UserController", description = "API контролера пользователя")
@Validated
public class UserController {
//    @Autowired
//    private final UserUpdateService updateService;
//    @Autowired
//    private final UserUpdateService userService;
    @Autowired
    private final UserServiceImpl service;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserServiceImpl usersService;

    @Operation(description = "Регистрация пользователя")
    @PostMapping(
            value = "/create-user"
    )
    public ResponseEntity<String> createUser(@Parameter(description = "Запрос на создание пользователя", required = true)
                                             @RequestBody(required = false) UserCreationDTO request,
                                             @RequestParam(required = false) String login) {
        service.saveUser(request);
        return ResponseEntity.ok("login");
    }

//    @Operation(description = "Авторизация пользователя")
//    @GetMapping(
//            value = "/user/login"
//    )
//    public ResponseEntity<String> userAuthorization(@Parameter(description = "Авторизация", required = true)
//                                                        @RequestBody(required = false) UserAuthDTO request,
//                                                    Model model) {
//        usersService.(request);
//        return ResponseEntity.ok("/");
//    }

    @Operation(description = "Авторизация пользователя")
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public ResponseEntity<String> userAuthorization(@Parameter(description = "Авторизация", required = true)
                                                        @RequestBody(required = false) UserAuthDTO request) {
        usersService.authUser(request);
        return ResponseEntity.ok("login");
    }

    @Operation(description = "Страница авторизации")
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }



//
//    @Operation(description = "страница авторизации")
//    @RequestMapping(value = "/login")
//    public String authorizationPage (Model model){
//        UserAuthDTO dto = new UserAuthDTO();
//        model.addAttribute("dto", dto);
//        return "login";
//    }


    @Operation(description = "Удаление пользователя")
    @DeleteMapping(value = "/user/users-delete/{userId}")
    public ResponseEntity<Object> deleteUser(@Parameter(description = "Идентификатор для удаления", required = true)
                                             @PathVariable(value = "userId") Long userId) {
        usersService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = " Получение списка зарегистрированных пользователей")
    @GetMapping(
            value = "/user/all-users/{users}",
            produces = {"application/json"}
    )
    public ResponseEntity<List<User>> getUsers(@Parameter(description = "Список пользователей")
                                               @RequestParam String users) {
        List<User> allUsers = usersService.getRegisteredUsers();
        return ResponseEntity.ok(allUsers);
    }

    @Operation(description = " Получение пользователя по номеру телефона")
    @GetMapping(value = "/user/by-phone/{phone}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<User> getUserByPhoneService(@Parameter(description = "Поиск пользователя по номеру телефона")
                                                      @PathVariable(value = "phone") String phone,
                                                      @RequestBody(required = false) UserUpdateDTO request) {
        return ResponseEntity.ok(usersService.getUserByPhone(phone));

    }

    @Operation(description = "Обновление логина пользователя")
    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<String> updateUserLoginDBController(
            @Parameter(description = "Идентификатор пользователя", required = true)
            @PathVariable(value = "userId") Long userId,
            @RequestBody(required = false) UserUpdateDTO request) {
       usersService.userUpdateLoginDB(userId, request);
        return ResponseEntity.ok("Логин успешно обновлен");
    }

    @Operation(description = "Обновление данных пользователя")
    @PutMapping(value = "/v1/users/full/{userId}")
    public ResponseEntity<String> userUpdateDBController(
            @Parameter(description = "Идентификатор пользователя", required = true)
            @PathVariable("userId") Integer userId,
            @RequestBody(required = false) UserUpdateDTO request) {
        usersService.userAccountUpdate(request, userId);
        return ResponseEntity.ok("Данные успешно обновлены");
    }
}
