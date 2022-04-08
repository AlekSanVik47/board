package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Long categoryId);

	List<Product> findByBrandId(Long brandId);

	Product findByProductName(String productName);

	boolean existsByImagePath(String imagePath);
}