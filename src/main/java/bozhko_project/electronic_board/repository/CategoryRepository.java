package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Override
	List<Category> findAll(Sort sort);

	@Override
	List<Category> findAll();
}