package bozhko_project.electronic_board.dto.dto_products;

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
    private Long brandId;
    private Long categoryId;
    private double price;
    private String description;
}