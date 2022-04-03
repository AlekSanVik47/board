package bozhko_project.electronic_board.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "category_id")
	private String category_id;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "brand_id")
	private String brand_id;

	@Column(name = "image")
	private String imagePath;

}
