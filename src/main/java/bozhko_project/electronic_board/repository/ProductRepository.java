package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}