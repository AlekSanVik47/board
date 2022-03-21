package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.service.UserUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

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
	

	@Operation(description = "Обновление пользователя")
	@PutMapping(
			value = "/v1/users/{userId}",
			produces = {"application/json"},
			consumes = {"application/json"}
	)
	public ResponseEntity<UserUpdateDTO>  updateUser (
			@Parameter(description = "Идентификатор пользователя", required = true)
			@PathVariable("userId") @PositiveOrZero int userId,
			@Param(value = "login") String login,
	@Parameter (description = "Запрос на обновление пользователя")
	@Valid @RequestBody(required = false) UserUpdateDTO request){
		return ResponseEntity.ok(updateService.userUpdateParam(userId, login, request));

	}

}
