package bozhko_project.electronic_board.dto.dto_products;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
	private final String productName;
	private final String category_id;
	private final String description;
	private final double price;
	private final String imagePath;
}
