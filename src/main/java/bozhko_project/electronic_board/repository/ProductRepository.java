package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.products.Brand;
import bozhko_project.electronic_board.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}