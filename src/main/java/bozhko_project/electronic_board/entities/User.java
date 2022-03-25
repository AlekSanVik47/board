package bozhko_project.electronic_board.entities;

import bozhko_project.electronic_board.dto.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="users")
public class User  {

	public enum Role{
		USER,ADMIN
	};
	public enum State{
		NOT_CONFIRMED, CONFIRMED, DELETE, BANNED
	};

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	private Role role;

	@Enumerated(value = EnumType.STRING)
	private State state;


	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String email;

	@Column
	private String phone;

	@Enumerated(value = EnumType.STRING)
	@Column (name = "status", nullable = false)
	private Status status;



}

