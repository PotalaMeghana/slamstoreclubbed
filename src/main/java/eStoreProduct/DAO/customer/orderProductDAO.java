package eStoreProduct.DAO.customer;

import java.util.List;

import eStoreProduct.model.customer.input.orderProductsModel;

public interface orderProductDAO {
	public List<orderProductsModel> getOrderWiseOrderProducts(int orderid);
	public int updateOrderProductStatus(int oid,int pid,String status);
	
}