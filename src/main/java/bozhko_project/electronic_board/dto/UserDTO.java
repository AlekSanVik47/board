package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class UserDTO {
	@Schema(description = "идентификатор")
	private Long id;
	@Schema(description = "имя")
	private String name;
	@Schema(description = "фамилия")
	private String surname;
	@Schema(description = "статус")
	private Status status;

}
