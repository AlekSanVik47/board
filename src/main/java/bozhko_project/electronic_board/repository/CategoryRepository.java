package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}