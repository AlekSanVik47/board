package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Override
	List<Product> findAll();

	@Override
	List<Product> findAll(Sort sort);

}