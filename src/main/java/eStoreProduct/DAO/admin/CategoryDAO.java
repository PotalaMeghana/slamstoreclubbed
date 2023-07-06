package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.input.Category;;

public interface CategoryDAO {

	public List<String> getAllCategories();

	boolean addNewCategory(Category catg);
}