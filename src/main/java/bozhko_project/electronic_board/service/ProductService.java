package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
import bozhko_project.electronic_board.entities.products.Product;
import bozhko_project.electronic_board.mapper.ProductMapper;
import bozhko_project.electronic_board.repository.BrandRepository;
import bozhko_project.electronic_board.repository.CategoryRepository;
import bozhko_project.electronic_board.repository.ProductRepository;
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

	public List<Product> getListAllProductService(){return productRepository.findAll();}

	public List<Product> getListProductByCategoryService (Long categoryId){return productRepository.findByCategoryId(categoryId);}
	public List<Product> getListProductByCategoryTitleService (String title){return productRepository.findByCategoryId(categoryRepository.findIdByTitle(title));}

	public List<Product> getListProductByBrandIdService(Long brandId){return productRepository.findByBrandId(brandId);}
	public List<Product> getListProductByBrandService(String brand){return productRepository.findByBrandId(brandRepository.findIdByBrand(brand).getId());}

	public List<Product> getProductByProductNameService(String productName){return productRepository.findByProductName(productName);}
	public Optional<Product> getProductById(Long id){return productRepository.findById(id);}

	public Long getBrandIdService (String brand){
		return productMapper.toBrandId(brand).getBrandId();
	}

	public Long getCategoryIdService (String category){
		return productMapper.toBrandId(category).getCategoryId();
	}


	public boolean createProductService(CreateProductDto dto, String brand, String category){
		Product product = productMapper.productToCreateProductDto(dto);
		product.setProductName(dto.getProductName());
		product.setBrandId(getBrandIdService(brand));
		product.setCategoryId(getCategoryIdService(category));
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());

		productRepository.save(product);
		return true;
	}

	public void productUpdateService(ProductUpdateDTO dto, Long id){
		Product product = productMapper.productToUpdateDTO(dto, id);
		product.setProductName(dto.getProductName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setImagePath(dto.getImagePath());
		productRepository.save(product);
	}

	public void deleteProductService(Long id){
		productRepository.deleteById(id);
	}
}
