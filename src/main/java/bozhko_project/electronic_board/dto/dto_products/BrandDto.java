package bozhko_project.electronic_board.dto.dto_products;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandDto implements Serializable {
	private final Long id_category;
	private final String brand;
	private final String productName;
}
