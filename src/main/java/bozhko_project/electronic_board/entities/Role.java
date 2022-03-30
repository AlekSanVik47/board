package bozhko_project.electronic_board.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
public class Role implements GrantedAuthority {

	@Id
	private Long id;
	private String role;
	@Override
	public String getAuthority() {
		return null;
	}
}
