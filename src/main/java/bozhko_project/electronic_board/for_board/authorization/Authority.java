package bozhko_project.electronic_board.for_board.authorization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** Модель ролей */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authority {

    /** Логин */
    @Id
    @Column(name = "login")
    private String login;

    /** Роль */
    private String authority;

}