package bozhko_project.electronic_board.dto.dto_products;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
	private final String productName;
	private final String category_id;
	private final double price;
	private final String brand_id;
}
