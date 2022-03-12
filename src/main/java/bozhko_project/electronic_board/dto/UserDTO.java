package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @Schema(description = "Идентификатор")
    private Integer id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Фамилия")
    private String surname;


}
