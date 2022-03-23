package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Регистрация пользователя")
public class UserCreationDTO {
    @NotBlank
    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Логин пользователя")
    private String login;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Фамилия")
    private String surname;

    @Schema(description = "Электронная почта")
    private String email;

    @Schema(description = "Номер телефона")
    private String phone;

    @Schema(description = "пароль")
    private String password;

    @Schema (description = "статус")
    private Status status;
}
