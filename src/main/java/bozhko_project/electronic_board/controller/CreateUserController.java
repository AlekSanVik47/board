package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserDTO;
import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.entities.authorization.UserDetailsImpl;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.AccountUserDetailsService;
import bozhko_project.electronic_board.service.UserCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "CreateUserController", description = "API контролера по регистрации пользователя")
@Validated
public class CreateUserController {

    @Autowired
    private final UserCreateService userCreateService;

    @Operation(description = "Создание пользователя")
    @PostMapping(
            value = "/v1/create-user",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity <UserDTO> createUser(@Parameter(description = "Запрос на создание пользователя")
                                               @RequestBody UserCreationDTO request){
        return new ResponseEntity<>(userCreateService.createUser(request), HttpStatus.CREATED);
    }

}
