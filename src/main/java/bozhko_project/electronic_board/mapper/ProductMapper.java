package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
import bozhko_project.electronic_board.entities.products.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface ProductMapper {
	Product productToProductDTO (Product entity);
	Product productToUpdateDTO (Product entity);
	Product addProductDTO(Product entity);
	ProductUpdateDTO productUpdate(Product entity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Product updateProduct(ProductUpdateDTO dto, @MappingTarget Product entity);
}
