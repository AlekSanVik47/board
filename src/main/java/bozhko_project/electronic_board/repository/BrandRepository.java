package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.products.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}