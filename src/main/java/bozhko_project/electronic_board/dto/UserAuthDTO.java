package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Авторизация пользователя")
public class UserAuthDTO {

	@Schema(description = "Логин пользователя")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String login;

	@Schema(description = "пароль")
	private String password;
}
