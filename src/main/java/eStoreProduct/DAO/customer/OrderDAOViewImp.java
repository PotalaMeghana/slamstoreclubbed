package eStoreProduct.DAO.customer;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import eStoreProduct.model.customer.input.Invoice;
import eStoreProduct.model.customer.input.InvoiceRowMapper;
import eStoreProduct.model.customer.input.OrdersMapper;
import eStoreProduct.model.customer.input.OrdersViewModel;

@Component
public class OrderDAOViewImp implements OrderDAOView {

	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<OrdersViewModel> ordersMapper;
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOViewImp.class);

	public OrderDAOViewImp(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.ordersMapper = new OrdersMapper();
	}

	// Retrieve ordered products for a given customer ID
	public List<OrdersViewModel> getorderProds(int custid) {
		logger.info("eStoreProduct:OrderDAOViewImp:getting all the orders placed by the customer based on their id");
		String query = "SELECT sp.prod_id, sp.prod_title, " + "sp.image_url, sp.prod_desc, "
				+ "sps.prod_price, o.ordr_id, op.orpr_shipment_status " + "FROM slam_orders o "
				+ "JOIN slam_orderproducts op ON o.Ordr_id = op.Ordr_id "
				+ "JOIN slam_products sp ON op.prod_id = sp.prod_id "
				+ "JOIN slam_productstock sps ON sp.prod_id = sps.prod_id " + "WHERE o.ordr_cust_id = ?";

		return jdbcTemplate.query(query, new Object[] { custid }, ordersMapper);
	}

	// Retrieve the details of a specific ordered product by customer ID and product ID
	public OrdersViewModel OrdProductById(int c, Integer productId, int orderid) {
		String query = "SELECT sp.prod_id, sp.prod_title, " + "sp.image_url, sp.prod_desc, "
				+ "sps.prod_price, o.ordr_id, op.orpr_shipment_status " + "FROM slam_orders o "
				+ "JOIN slam_orderproducts op ON o.Ordr_id = op.Ordr_id "
				+ "JOIN slam_products sp ON op.prod_id = sp.prod_id "
				+ "JOIN slam_productstock sps ON sp.prod_id = sps.prod_id "
				+ "WHERE o.ordr_cust_id = ? AND sp.prod_id = ? AND o.ordr_id=?";

		return jdbcTemplate.queryForObject(query, new Object[] { c, productId, orderid }, ordersMapper);
	}

	// Cancel an order by product ID and order ID
	public void cancelorderbyId(Integer productId, int orderId) {
		logger.info("eStoreProduct:OrderDAOViewImp:cancelling the order selected");
		String updateQuery_products = "UPDATE slam_OrderProducts SET orpr_shipment_status = 'cancelled' WHERE prod_id = ? and ordr_id=?";
		jdbcTemplate.update(updateQuery_products, productId, orderId);
	}

	// Get the shipment status of an order by product ID and order ID
	public String getShipmentStatus(int productId, int orderId) {
		logger.info("eStoreProduct:OrderDAOViewImp:getting the shipment status for tracking");
		String sql = "SELECT orpr_shipment_status FROM slam_orderproducts WHERE prod_id = ? and ordr_id=?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { productId, orderId }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null; // Handle the case when shipment status is not found
		}
	}

	// Check if all products in an order are cancelled
	public boolean areAllProductsCancelled(int orderId) {
		logger.info("eStoreProduct:OrderDAOViewImp:getting all the cancelled orders");
		String selectQuery = "SELECT COUNT(*) FROM slam_OrderProducts WHERE ordr_id = ? AND orpr_shipment_status != 'cancelled'";
		int count = jdbcTemplate.queryForObject(selectQuery, Integer.class, orderId);
		return count == 0;
	}

	// Update the shipment status of an order
	public void updateOrderShipmentStatus(int orderId, String shipmentStatus) {
		logger.info("eStoreProduct:OrderDAOViewImp:updating the order shipment status by admin");
		String updateQuery_orders = "UPDATE slam_Orders SET ordr_shipment_status = ? WHERE ordr_id = ?";
		jdbcTemplate.update(updateQuery_orders, shipmentStatus, orderId);
	}

	// getting invoice by order id
	public Invoice getInvoiceByOrderId(int orderId, int productId) {
		String query = "SELECT o.ordr_id, o.ordr_billno, o.ordr_odate, o.ordr_paymode, o.ordr_saddress, "
				+ "o.ordr_shipment_date, op.orpr_qty, op.orpr_gst, op.orpr_price " + "FROM slam_orders o "
				+ "INNER JOIN slam_orderproducts op ON o.ordr_id = op.ordr_id "
				+ "WHERE o.ordr_id = ? and op.prod_id=?";

		return jdbcTemplate.queryForObject(query, new Object[] { orderId, productId }, new InvoiceRowMapper());
	}

	@Override
	public int getProductQuantity(int productId, int orderId) {
		return jdbcTemplate.queryForObject("select orpr_qty from slam_orderproducts where ordr_id=? and prod_id=?",
				new Object[] { orderId, productId }, Integer.class);
	}

	@Override
	public int getProductStock(int productId) {
		return jdbcTemplate.queryForObject("select prod_stock from slam_productstock where  prod_id=?",
				new Object[] { productId }, Integer.class);
	}

	@Override
	public void updateStock(int productId, int orderId) {
		int qty = getProductQuantity(productId, orderId);
		int quantity = qty + getProductStock(productId);
		String update_stock = "update slam_productStock set prod_stock=? where prod_id=? ";
		jdbcTemplate.update(update_stock, quantity, productId);
	}

}
