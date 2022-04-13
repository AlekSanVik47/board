package bozhko_project.electronic_board.entities;

import bozhko_project.electronic_board.entities.products.Product;
import bozhko_project.electronic_board.entities.user_entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "announcement_tbl")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private Long id;


    @OneToOne (fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name="user_id")
    private User userId;


    @OneToOne (fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name="product_id")
    private Product productId;
}
