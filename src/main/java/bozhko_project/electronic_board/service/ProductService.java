package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
import bozhko_project.electronic_board.entities.products.Product;
import bozhko_project.electronic_board.mapper.ProductMapper;
import bozhko_project.electronic_board.repository.product_rep.BrandRepository;
import bozhko_project.electronic_board.repository.product_rep.CategoryRepository;
import bozhko_project.electronic_board.repository.product_rep.ImageRepository;
import bozhko_project.electronic_board.repository.product_rep.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final BrandRepository brandRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final ImageRepository imageRepository;


    public List<Product> getListAllProductService() {
        return productRepository.findAll();
    }

    public List<Product> getListProductByCategoryService(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getListProductByCategoryTitleService(String title) {
        return productRepository.findByCategoryId(categoryRepository.findIdByTitle(title));
    }

    public List<Product> getListProductByBrandIdService(Long brandId) {
        return productRepository.findByBrandId(brandId);
    }

    public List<Product> getListProductByBrandService(String brand) {
        return productRepository.findByBrandId(brandRepository.findIdByBrand(brand).getId());
    }

    public List<Product> getProductByProductNameService(String productName) {
        return Optional.ofNullable(productRepository.findByProductName(productName)).orElse(null);
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElse(null));
    }

    public void createProductService(CreateProductDto dto) {
        Product product = productMapper.productToCreateProductDto(dto);
        product.setProductName(dto.getProductName());
        product.setBrandId(dto.getBrandId());
        product.setCategoryId(dto.getCategoryId());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        productRepository.save(product);
    }

    public void productUpdateService(ProductUpdateDTO dto, Long id) {
        Product product = productMapper.productToUpdateDTO(dto, id);
        product.setBrandId(productRepository.findBrandIdById(id).getBrandId());
        product.setCategoryId(productRepository.findCategoryIdById(id).getCategoryId());
        product.setImageId(dto.getImageId());
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        productRepository.save(product);
    }
    public void productNameUpdateService(ProductUpdateDTO dto, Long id) {
        Product product = productRepository.getById(id);
        product.setProductName(dto.getProductName());
        productRepository.saveAndFlush(product);
    }
    public void productDescriptionUpdateService(ProductUpdateDTO dto, Long id) {
        Product product = productMapper.productToUpdateDTO(dto, id);
        product.setDescription(dto.getDescription());
        productRepository.saveAndFlush(product);
    }
    public void productPriceUpdateService(ProductUpdateDTO dto, Long id) {
        Product product = productMapper.productToUpdateDTO(dto, id);
        product.setPrice(dto.getPrice());
        productRepository.saveAndFlush(product);
    }
    public void productImageUpdateService(ProductUpdateDTO dto, Long id) {
        Product product = productMapper.productToUpdateDTO(dto, id);
        product.setImageId(dto.getImageId());
        productRepository.saveAndFlush(product);
    }

    public void deleteProductService(Long id) {
        productRepository.deleteById(id);
    }


}
