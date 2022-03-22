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

	//@Autowired
	//private final UserUpdateDTO dto;
	

	@Operation(description = "Обновление пользователя")
	@PutMapping(value = "/v1/users/{userId}")
	public ResponseEntity<UserUpdateDTO> updateUser (
			@Parameter(description = "Идентификатор пользователя", required = true)
			@PathVariable("userId")  Long userId,
			@RequestParam("login") String login,
		//	@Parameter
		//	@Validated
			@RequestBody(required = false) UserUpdateDTO request){
		System.out.println(1);
		return ResponseEntity.ok(updateService.userUpdateD(userId, request));
	}

}
