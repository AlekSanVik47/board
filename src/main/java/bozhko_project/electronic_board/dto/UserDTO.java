package bozhko_project.electronic_board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String login;
    private String role;

}

