package bozhko_project.electronic_board.dto.dto_user;

import bozhko_project.electronic_board.entities.user_entities.Role;
import bozhko_project.electronic_board.entities.user_entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String login;
    private Role role;

    public UserDTO(String login, User.Role[] role) {
    }
}

