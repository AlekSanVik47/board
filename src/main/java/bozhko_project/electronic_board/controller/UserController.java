package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserRegistrationDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "UserController", description = "API контролера по работе с пользователями")
@Validated
public class UserController {
@Autowired
private final UsersService usersService;

   @Operation(description = " Получение списка зарегестрированных пользователей")
    @GetMapping(
            value = "/user/all-users/{reg-users}"
    )
    public ResponseEntity<UsersService> getUsers (
           @PathVariable(name = "all-users") String users){
       List<UserRegistrationDTO> allUsers = usersService.getRegisteredUsers(20);
       return ResponseEntity.ok(usersService);
   }
   /* public ResponseEntity<List<User>> getAllUsers(
            @PathVariable(name = "all-users") String users) {
        List<User> allUsers = usersService.getRegUsers("all-users");
        return ResponseEntity.ok(allUsers);
   }*/

}
