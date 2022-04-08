package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
import bozhko_project.electronic_board.entities.products.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface ProductMapper {
    Product productToProductDTO(ProductDto entity);

    Product productToUpdateDTO(Product entity);

    Product addProductDTO(Product entity);

    ProductUpdateDTO productUpdate(Product entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProduct(ProductUpdateDTO dto, @MappingTarget Product entity);

    Product createProductDtoToProduct(CreateProductDto createProductDto);

    Product productToCreateProductDto(CreateProductDto product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromCreateProductDto(CreateProductDto createProductDto, @MappingTarget Product product);



    Product productToUpdateDTO(ProductUpdateDTO dto, Long id);
}
