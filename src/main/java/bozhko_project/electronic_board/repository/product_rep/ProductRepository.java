package bozhko_project.electronic_board.repository.product_rep;

import bozhko_project.electronic_board.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Long categoryId);

	List<Product> findByBrandId(Long brandId);
	List<Product> findByProductName(String productName);

	Product findBrandIdById(Long id);

	@Override
	Optional<Product> findById(Long aLong);

	Product findCategoryIdById(Long id);
	Product findImageIdById(long id);
}