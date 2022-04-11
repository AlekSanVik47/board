package bozhko_project.electronic_board.repository.product_rep;

import bozhko_project.electronic_board.entities.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    String findTitleById(long id);
    Long findIdByTitle(String title);


    @Override
    Optional<Category> findById(Long aLong);

    Category findByTitle(String title);


}