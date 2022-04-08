package bozhko_project.electronic_board.entities.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

	@Column(name = "product_name")
	private String productName;


	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "категория не выбрана")
	private Category category;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;


	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name = "image")
	private String imagePath;

}
