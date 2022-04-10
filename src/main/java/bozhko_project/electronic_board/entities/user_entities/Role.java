package bozhko_project.electronic_board.entities.user_entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_tbl")
public class Role implements GrantedAuthority {

	public enum UserRole {
		ADMIN,USER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;



	@Column(columnDefinition = "USER", name = "role_fld")
	private Role role;

	@Override
	public String getAuthority() {
		return null;
	}
}
