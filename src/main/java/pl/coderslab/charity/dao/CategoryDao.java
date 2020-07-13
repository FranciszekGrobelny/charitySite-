package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCategory(Category category){entityManager.persist(category);}
}
