package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.input.orderProductInput;
import eStoreProduct.model.admin.output.orderProductsModel;

public interface orderProductDAO {
	public List<orderProductsModel> getOrderWiseOrderProducts(int orderid);

	public int updateOrderProductStatus(orderProductInput op);

}