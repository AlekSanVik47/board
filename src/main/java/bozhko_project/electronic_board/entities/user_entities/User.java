package bozhko_project.electronic_board.entities.user_entities;

import bozhko_project.electronic_board.dto.dto_user.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	public enum Role {
		USER, ADMIN
	}

	;
//	@ManyToMany(fetch = FetchType.EAGER)
//	private Set<Role> roles;

	public enum State {
		NOT_CONFIRMED, CONFIRMED, DELETE, BANNED
	}

	;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(columnDefinition = "USER", name = "role_id")
	private Role role_id;

	@Enumerated(value = EnumType.STRING)
	@Column(columnDefinition = "CONFIRMED")
	private State state;


	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "password")
	private String password;

	@Column
	private String name;

	@Column
	private String surname;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String phone;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "status", nullable = false, columnDefinition = "NEW")
	private Status status;

	public Role getRole() {
		return role_id;
	}


}

