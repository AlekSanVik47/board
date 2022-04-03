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
@Table(name = "user_role")
public class Role implements GrantedAuthority {

//	public enum UserRole {
//		ADMIN,USER;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	@Column(columnDefinition = "USER")
	private Role role_id;

	@Override
	public String getAuthority() {
		return null;
	}
}