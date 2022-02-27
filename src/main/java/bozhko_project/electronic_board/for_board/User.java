package bozhko_project.electronic_board.for_board;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nick")
	private String nick;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String email;

	@Column
	private String phone;

}
