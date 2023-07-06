package eStoreProduct.DAO.admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.entities.productCategoryModel;
import eStoreProduct.model.admin.input.Category;

@Component
public class CategoryDAOImp implements CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImp.class);

    /**
     * Retrieves the maximum category ID from the productCategoryModel table.
     * 
     * @return The maximum category ID or 0 if no categories exist.
     */
    @Transactional
    public Integer getMaxCategoryId() {
        logger.info("Entered CategoryDAOImp.getMaxCategoryId() method");

        String query = "SELECT MAX(c.id) FROM productCategoryModel c";
        TypedQuery<Integer> maxIdQuery = entityManager.createQuery(query, Integer.class);
        Integer maxId = maxIdQuery.getSingleResult();

        return maxId != null ? maxId : 0;
    }

    /**
     * Adds a new category to the productCategoryModel table.
     * 
     * @param catg The Category object containing the category details.
     * @return True if the category was added successfully, false otherwise.
     */
    @Override
    @Transactional
    public boolean addNewCategory(Category catg) {
		        logger.info("Entered CategoryDAOImp.addNewCategory() method");

        int c_id = getMaxCategoryId();
        c_id = c_id + 1;
        System.out.println(c_id + "Category_id\n");

        productCategoryModel categoryEntity = new productCategoryModel();
        categoryEntity.setId((long) c_id);
        categoryEntity.setPrct_title(catg.getPrct_title());
        categoryEntity.setDescription(catg.getPrct_desc());

        entityManager.merge(categoryEntity);

        return categoryEntity.getId() == null;
    }

    /**
     * Retrieves a list of all categories from the productCategoryModel table.
     * 
     * @return The list of category titles.
     */
    public List<String> getAllCategories() {
				        logger.info("Entered CategoryDAOImp.getAllCategories() method");

        List<String> categories = new ArrayList<>();

        try {
            // Create a new EntityManager from the factory
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            // Prepare the JPA query
            String query = "SELECT c.prct_title FROM eStoreProduct.model.admin.entities.productCategoryModel c";
            TypedQuery<String> typedQuery = entityManager.createQuery(query, String.class);

            // Execute the query
            List<String> results = typedQuery.getResultList();

            // Add the results to the categories list
            categories.addAll(results);

            // Close the EntityManager
            entityManager.close();
        } catch (Exception e) {
            logger.error("Error occurred in getAllCategories() method: {}", e.getMessage());
            e.printStackTrace();
        }

        return categories;
    }
}
