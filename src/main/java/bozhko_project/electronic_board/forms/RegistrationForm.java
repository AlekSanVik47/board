package bozhko_project.electronic_board.forms;

import bozhko_project.electronic_board.dto.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {

	private String login;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String password;


}
