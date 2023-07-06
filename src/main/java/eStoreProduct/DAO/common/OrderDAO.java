package eStoreProduct.DAO.common;

import java.sql.Timestamp;
import java.util.List;

import eStoreProduct.model.admin.entities.orderModel;

public interface OrderDAO {
	void insertOrder(orderModel order);

	List<orderModel> loadOrdersByDate(Timestamp startDate, Timestamp endDate);

	void updateOrderProcessedBy(Long orderId, Integer processedBy);

	void updateOrderShipmentStatus(int orderId, String status);

	public int getNoOfOrders();

	long getTotalOrders();

	List<orderModel> getOrders(int page, int pageSize);

	List<orderModel> getAllOrders();
}