package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category getCategoryByName(String name);

    List<Category> findAllByNameIn(List<String> names);
}
