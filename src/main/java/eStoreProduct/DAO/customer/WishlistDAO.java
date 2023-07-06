package eStoreProduct.DAO.customer;

import java.util.List;

import eStoreProduct.utility.ProductStockPriceForCust;

public interface WishlistDAO {

	public int addToWishlist(int productId, int customerId);

	public int removeFromWishlist(int productId, int customerId);

	public List<ProductStockPriceForCust> getWishlistProds(int cust_id);

}