package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Schema(description = "Логин пользователя")
    private String login;

    @NotBlank
    @Schema(description = "Имя")
    private String name;

    @NotBlank
    @Schema(description = "Фамилия")
    private String surname;

    @NotBlank
    @Schema(description = "Электронная почта")
    private String email;

    @NotBlank
    @Schema(description = "Номер телефона")
    private String phone;

    @NotBlank
    @Schema(description = "пароль")
    private String password;

    @NotBlank
    @Schema (description = "статус")
    private Status status;



}
