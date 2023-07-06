package eStoreProduct.DAO.common;

import java.util.List;

import eStoreProduct.model.admin.entities.productsModel;
import eStoreProduct.model.admin.input.Category;
import eStoreProduct.model.admin.input.Product;
import eStoreProduct.utility.ProductStockPrice;

public interface ProductDAO {

	public boolean createProduct(Product p);

	public List<String> getAllProductCategories();

	public List<ProductStockPrice> getProductsByCategory(Integer category);

	public List<ProductStockPrice> getAllProducts();

	public List<Category> getAllCategories();

	public ProductStockPrice getProductById(Integer productId);

	// -----------------------
	public boolean isPincodeValid(int pincode);

	public List<ProductStockPrice> filterProductsByPriceRange(double minPrice, double maxPrice);

	public List<ProductStockPrice> sortProductsByPrice(List<ProductStockPrice> productList, String sortOrder);

	/* boolean createProduct(eStoreProduct.model.admin.input.Product p); */

	Integer getMaxProductId();

	productsModel getProductModelById(int prodid);

	public int getNoOfProducts();
}