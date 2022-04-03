package bozhko_project.electronic_board.dto.dto_products;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
	private final Long id;
	private final String title;
}
