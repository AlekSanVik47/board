package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.products.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from Brand b where b.id = ?1")
    Brand findBrandById(Long id);
    Brand findIdByBrand(String brand);

}