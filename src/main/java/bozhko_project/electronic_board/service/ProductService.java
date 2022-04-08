package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
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

	public List<Product> getListAllProduct(){return productRepository.findAll();}

	public List<Product> getListProductByCategory (Long categoryId){return productRepository.findByCategoryId(categoryId);}
	public List<Product> getListProductByCategoryTitle (String title){return productRepository.findByCategoryId(categoryRepository.findIdByTitle(title));}

	public List<Product> getListProductByBrandId(Long brandId){return productRepository.findByBrandId(brandId);}
	public List<Product> getListProductByBrand(String brand){return productRepository.findByBrandId(brandRepository.findIdByBrand(brand).getId());}

	public Product getProductByProductName(String productName){return productRepository.findByProductName(productName);}

	public Long getBrandId (String brand){
		return productMapper.toBrandId(brand).getBrandId();
	}

	public Long getCategoryId (String category){
		return productMapper.toBrandId(category).getCategoryId();
	}



	public boolean createProduct(CreateProductDto dto, String brand, String category){
		Product product = productMapper.productToCreateProductDto(dto);
		product.setProductName(dto.getProductName());
		product.setBrandId(getBrandId(brand));
		product.setCategoryId(getCategoryId(category));
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());

		productRepository.save(product);
		return true;
	}
}
