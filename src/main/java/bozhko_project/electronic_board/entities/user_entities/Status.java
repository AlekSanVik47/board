package bozhko_project.electronic_board.entities.user_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "status_tbl")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Long id;

    @Column(name = "status_fld", columnDefinition = "NEW")
    private String status;


    public Long getId() {
        return id;
    }

   }
