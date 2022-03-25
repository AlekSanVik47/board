package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.entities.User;
import bozhko_project.electronic_board.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "CreateUserController", description = "API контролера по регистрации пользователя")
@Validated
public class CreateUserController {

    @Autowired
    private final UserServiceImpl service;

    @Operation(description = "Создание пользователя")
    @PostMapping(
            value = "/v1/create-user",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<User> createUser(@Parameter(description = "Запрос на создание пользователя", required = true)
                                             @RequestBody(required = false) UserCreationDTO request,
    @RequestParam(required = false) String login) {
        service.save(request);
        return ResponseEntity.ok(service.findByUserLogin(login));
    }
}

