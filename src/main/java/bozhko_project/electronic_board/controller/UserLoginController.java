package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "LoginController", description = "API контролера аутентификации/авторизации пользователя")
@Validated
public class UserLoginController {

	@Operation(description = "Страница входа")
	@GetMapping(value = "/user/login")
	public ResponseEntity<String> getSignIn() {
		return ResponseEntity.ok("Страница авторизации");
	}

	@Operation(description = "Аккаунт пользователя")
	@GetMapping(value = "/user/login/account")
	public ResponseEntity<String> getAccountUser() {
		return ResponseEntity.ok("Страница авторизации");
	}
}
