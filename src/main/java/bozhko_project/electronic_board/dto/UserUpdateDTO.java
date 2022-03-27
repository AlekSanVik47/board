package bozhko_project.electronic_board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Schema(description = "Обновления данных пользователя")
public class UserUpdateDTO {

//   @Schema(description = "Id пользователя")
//   @Id
//   @GeneratedValue(strategy = GenerationType.SEQUENCE)
//   private Integer id;

    @Schema(description = "Имя пользователя")
    private String name;

    @Schema(description = "Фамилия пользователя")
    String surname;

    @Schema(description = "Логин пользователя")
    private String login;

    @Schema(description = "Электронная почта")
    private String email;

    @Schema(description = "Номер телефона")
    private String phone;

    @Schema (description = "Пароль")
    private String password;

//    @Schema (description = "статус")
//    private Status status = Status.NEW;


}
