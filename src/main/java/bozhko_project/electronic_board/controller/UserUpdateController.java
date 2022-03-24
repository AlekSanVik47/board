package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.service.UserUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "UserUpdateController", description = "API контролера обновления данных пользователя")
@Validated
public class UserUpdateController {
    @Autowired
    private final UserUpdateService updateService;
    @Autowired
    private final UserMapper userMapper;

    @Operation(description = "Обновление логина пользователя")
    @PutMapping(value = "/v1/user/{userId}")
    public ResponseEntity<String> updateUserLoginDBController(
            @Parameter(description = "Идентификатор пользователя", required = true)
            @PathVariable(value = "userId") Long userId,
            @RequestBody(required = false) UserUpdateDTO request) {
        updateService.userUpdateLoginDB(userId, request);
        return ResponseEntity.ok("Логин успешно обновлен");
    }

	@Operation(description = "Обновление данных пользователя")
	@PutMapping(value = "/v1/users/full/{userId}")
	public ResponseEntity<String> userUpdateDBController(
			@Parameter(description = "Идентификатор пользователя", required = true)
			@PathVariable("userId") Long userId,
			@RequestBody(required = false) UserUpdateDTO request) {
		updateService.userAccountUpdate(userId, request);
		return ResponseEntity.ok("Данные успешно обновлены");
	}

}
