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
@Table(name = "product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "product_name")
	private String productName;



	@Column(name = "category_id")
	@NotNull(message = "категория не выбрана")
	private Long categoryId;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "brand_id")
	private Long brandId;

	@Column(name = "image_id")
	private Long imageId;

}
