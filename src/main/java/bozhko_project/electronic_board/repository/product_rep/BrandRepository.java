package bozhko_project.electronic_board.repository.product_rep;

import bozhko_project.electronic_board.entities.products.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from Brand b where b.id = ?1")
    Brand findBrandById(Long id);
    Brand findIdByBrand(String brand);

    @Override
    Optional<Brand> findById(Long aLong);

    Brand findByBrand(String brand);
}