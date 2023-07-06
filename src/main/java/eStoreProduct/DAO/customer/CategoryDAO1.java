package eStoreProduct.DAO.customer;
import java.util.List;

import eStoreProduct.model.customer.input.Category;
public interface CategoryDAO1 {

	public List<Category> getAllCategories();
	boolean addNewCategory(Category catg);
}