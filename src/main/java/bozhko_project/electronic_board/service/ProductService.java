package bozhko_project.electronic_board.service;

import bozhko_project.electronic_board.entities.products.Product;
import bozhko_project.electronic_board.mapper.ProductMapper;
import bozhko_project.electronic_board.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
	private final ProductMapper productMapper;

	public List<Product> getListAllProduct(){return productRepository.findAll();}
	public List<Product> getListProductByCategory (Long categoryId){return productRepository.findByCategoryId(categoryId);}
	public List<Product> getListProductByBrand(Long brandId){return productRepository.findByBrandId(brandId);}

	public Product getProductByProductName(String productName){return productRepository.findByProductName(productName);}
}
