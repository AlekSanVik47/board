package bozhko_project.electronic_board.entities.user_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_tbl")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


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

	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(name = "user_role_tbl", joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")})
	private List<Role> roles;


	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "status_id")
	private Long statusId;



	public void getState() {
	}
}

