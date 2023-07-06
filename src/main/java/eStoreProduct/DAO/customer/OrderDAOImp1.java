package eStoreProduct.DAO.customer;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import eStoreProduct.model.admin.entities.orderModel;
import eStoreProduct.utility.ProductStockPriceForCust;

@Repository
public class OrderDAOImp1 implements OrderDAO1{
	JdbcTemplate jdbcTemplate;
	private static final Logger logger = 
			LoggerFactory.getLogger(OrderDAOImp1.class);

	@Autowired
	public OrderDAOImp1(javax.sql.DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertOrder(orderModel order) {
		logger.info("eStoreProduct:OrderDAOImp:insert order method");
		entityManager.persist(order);
	}
	private String ins = "INSERT INTO slam_orders (ordr_cust_id, ordr_billno, ordr_odate, ordr_total, ordr_gst, ordr_payreference, ordr_paymode, ordr_paystatus, ordr_saddress, ordr_shipment_status,ordr_shipment_date,ordr_spincode) VALUES (?, ?, CURRENT_TIMESTAMP,?, ?, ?, ?, ?, ?, ?, CURRENT_DATE + INTERVAL '5 days',?) RETURNING ordr_id";
	private String ins_ord_prd = "INSERT INTO slam_orderproducts (ordr_id, prod_id, orpr_qty, orpr_gst, orpr_price, orpr_shipment_status)\r\n"
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	@Override
	@Transactional
	public List<orderModel> getAllOrders() {
		logger.info("eStoreProduct:OrderDAOImp:method to get all the orders placed");
		Session currentSession = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<orderModel> criteriaQuery = criteriaBuilder.createQuery(orderModel.class);
		Root<orderModel> root = criteriaQuery.from(orderModel.class);
		criteriaQuery.select(root);

		TypedQuery<orderModel> query = currentSession.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateOrderProcessedBy(Long orderId, Integer processedBy) {
		logger.info("eStoreProduct:OrderDAOImp:method to update the order processed by which admin");
		// Retrieve the order entity based on the order ID
		orderModel order = entityManager.find(orderModel.class, orderId);

		// Check if the order exists
		if (order != null) {
			// Set the processed by information on the order entity
			order.setOrdr_processedby(processedBy);

			// Save the updated order entity to the database
			entityManager.merge(order);
		}
	}

	@Override
	@Transactional
	public List<orderModel> loadOrdersByDate(Timestamp startDate, Timestamp endDate) {
		logger.info("eStoreProduct:OrderDAOImp:load all the orders placed in the dates selected");
		//System.out.println("loading");
		Session currentSession = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<orderModel> criteriaQuery = criteriaBuilder.createQuery(orderModel.class);
		Root<orderModel> root = criteriaQuery.from(orderModel.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.between(root.get("orderDate"), startDate, endDate));

		TypedQuery<orderModel> query = currentSession.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateOrderShipmentStatus(int orderId, String status) {
		logger.info("eStoreProduct:OrderDAOImp:update the shipment status of the order placed");
		// Retrieve the order entity based on the order ID
		orderModel order = entityManager.find(orderModel.class, orderId);

		// Check if the order exists
		if (order != null) {
			// Set the processed by information on the order entity
			order.setShipment_status(status);

			// Save the updated order entity to the database
			entityManager.merge(order);
		}
	}
	
	
	@Override
	public void insertIntoOrders(orderModel or, List<ProductStockPriceForCust> al) {
		logger.info("eStoreProduct:OrderDAOImp:insert into orders and ordersplaced tables when order is placed ");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(ins, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, or.getOrdr_cust_id());
			ps.setString(2, or.getBillNumber());
			ps.setDouble(3, or.getTotal());
			ps.setDouble(4, or.getGst());
			ps.setString(5, or.getPaymentReference());
			ps.setString(6, "Online");
			ps.setString(7, "Success");
			ps.setString(8, or.getShippingAddress());
			ps.setString(9, "Order_Placed");
			ps.setInt(10, or.getShippingPincode());
			return ps;
		}, keyHolder);

		Number generatedOrderId = keyHolder.getKey();
		int ordrId = generatedOrderId != null ? generatedOrderId.intValue() : 0;

		for (ProductStockPriceForCust product : al) {
			jdbcTemplate.update(ins_ord_prd, ordrId, product.getProd_id(), product.getQuantity(), product.getGst(),
					product.getPrice(), "Order_Placed");
		}
	}

	
}
