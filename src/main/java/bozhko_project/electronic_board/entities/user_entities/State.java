package bozhko_project.electronic_board.entities.user_entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state_tbl")
public enum State {
	NOT_CONFIRMED, CONFIRMED, DELETE, BANNED;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	@Column(name = "state_fld", columnDefinition = "CONFIRMED")
	private String state;

	public void setId(Long id) {
		this.id = id;
	}
}
