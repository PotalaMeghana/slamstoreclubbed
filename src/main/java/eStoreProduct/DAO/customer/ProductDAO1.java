package eStoreProduct.DAO.customer;

import java.util.List;

import eStoreProduct.model.customer.input.Category;
import eStoreProduct.model.customer.input.Product;
import eStoreProduct.utility.ProductStockPriceForCust;

public interface ProductDAO1 {

	public boolean createProduct(Product p);


	public List<ProductStockPriceForCust> getProductsByCategory(Integer category);

	public List<ProductStockPriceForCust> getAllProducts();

	public List<Category> getAllCategories();

	public ProductStockPriceForCust getProductById(Integer productId);

	// -----------------------
	public boolean isPincodeValid(int pincode);

	public List<ProductStockPriceForCust> filterProductsByPriceRange(List<ProductStockPriceForCust> productList, double minPrice,
			double maxPrice);

	public List<ProductStockPriceForCust> sortProductsByPrice(List<ProductStockPriceForCust> productList, String sortOrder);

	public int getproductgstcid(int pid);

	public List<ProductStockPriceForCust> searchproducts(String search);

}