package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.entities.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}