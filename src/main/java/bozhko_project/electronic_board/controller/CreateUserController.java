package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.service.UserCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
            value = "/v1/create-user/{newId}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<String> createUser(@Parameter(description = "Запрос на создание пользователя", required = true)
                                             @RequestBody(required = false) UserCreationDTO request,
                                             @PathVariable(value = "newId") Long newUserId) {
        userCreateService.createUser(request, newUserId);
        return ResponseEntity.ok("Пользователь успешно сохранен");
    }
   /* @Operation(description = "Обновление данных пользователя")
    @PutMapping(value = "/v1/users/full/{userId}")
    public ResponseEntity<String> userUpdateDBController(
            @Parameter(description = "Идентификатор пользователя", required = true)
            @PathVariable("userId") Long userId,
            @RequestBody(required = false) UserUpdateDTO request) {
        updateService.userAccountUpdate(userId, request);
        return ResponseEntity.ok("Данные успешно обновлены");*/
}

