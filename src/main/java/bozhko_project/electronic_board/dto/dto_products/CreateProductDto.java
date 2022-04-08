package bozhko_project.electronic_board.dto.dto_products;

import bozhko_project.electronic_board.entities.products.Brand;
import bozhko_project.electronic_board.entities.products.Category;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto implements Serializable {
    private String productName;
    private Brand brand;
    private Category category;
    private double price;
    private String description;
}
