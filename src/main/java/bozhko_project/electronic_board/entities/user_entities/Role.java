package bozhko_project.electronic_board.entities.user_entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_tbl")
public enum Role {

	ADMIN,
	USER;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "role_fld",columnDefinition = "USER")
	private String role;



}
