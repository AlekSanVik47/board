package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.UserUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "DeleteController", description = "API контролера по удалению пользователя")
@Validated
public class UserDeleteController {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final UserUpdateService userService;

	@Operation(description = "Удаление пользователя")
	@DeleteMapping(value = "/v1/users-delete/{userId}")
	public ResponseEntity<Object> deleteUser(@Parameter (description = "Идентификатор для удаления",required = true)
			                              @PathVariable(value = "userId") Long userId){
		userService.deleteUserById(userId);
		return ResponseEntity.noContent().build();
	}
}
