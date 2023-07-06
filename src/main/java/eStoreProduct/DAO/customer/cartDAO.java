package eStoreProduct.DAO.customer;

import java.util.List;

import eStoreProduct.model.admin.entities.HSNCodeModel;
//import eStoreProduct.model.customer.input.HSNCodeModel;
import eStoreProduct.model.customer.input.ServiceableRegion;
import eStoreProduct.model.customer.input.cartModel;
import eStoreProduct.utility.ProductStockPriceForCust;

public interface cartDAO {
	public String addToCart(int productId, int customerId);

	public int removeFromCart(int productId, int customerId);

	public List<ProductStockPriceForCust> getCartProds(int cust_id);

	public int updateQty(cartModel cm);

	public int updateinsert(List<ProductStockPriceForCust> products, int cust_id);

	public HSNCodeModel getHSNCodeByProductId(int prod_gstc_id);

	public ServiceableRegion getRegionByPincode(int i);

}