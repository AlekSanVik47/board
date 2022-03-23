package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "UserController", description = "API контролера по поиска/получения пользователей")
@Validated
public class UserSearchController {

    @Autowired
    private final UsersService usersService;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final UserRepository userRepository;

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
}

