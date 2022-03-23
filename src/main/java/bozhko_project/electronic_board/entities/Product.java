package bozhko_project.electronic_board.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Product;

	@Column
	private String productName;

	@Column
	private String category;

	@Column
	private String description;

	@Column
	private double price;

	@Column
	private String vendor;

	@Column
	private String imagePath;

}
