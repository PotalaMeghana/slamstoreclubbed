package eStoreProduct.DAO.admin;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.entities.SlamOrderModel;
import eStoreProduct.model.admin.entities.SlamOrderProduct;

@Component
public class OrderRepDAOImpl implements OrderRepDAO {
	@PersistenceContext
	private EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(OrderRepDAOImpl.class);

	@Override
	@Transactional
	public List<SlamOrderModel> getAllOrders() {
		    logger.info("in OrderRepDAOImpl.getAllOrders() ");

		List<SlamOrderModel> slamOrders;
		try {
			// Retrieve all SlamOrders
			System.out.println("in OrderRepDAOImpl getAllOrders");
			TypedQuery<SlamOrderModel> query = entityManager.createQuery("SELECT o FROM SlamOrderModel o",
					SlamOrderModel.class);
			slamOrders = query.getResultList();

			for (SlamOrderModel slamOrder : slamOrders) {
				// Access SlamOrder properties

				double orderId = slamOrder.getId();
				Integer customerId = slamOrder.getOrdr_cust_id();
				System.out.println("ordr id:" + orderId + "  customerId:" + customerId);
				// ...

				// Access related SlamOrderProducts
				List<SlamOrderProduct> orderProducts = slamOrder.getOrderProducts();
				for (SlamOrderProduct orderProduct : orderProducts) {
					// Access SlamOrderProduct properties
					Integer productId = orderProduct.getProductId();
					Integer quantity = orderProduct.getQuantity();
					System.out.println("in orderprods");
					System.out.println("productId:" + productId + "  quantity:" + quantity);
					// ...
				}
				return slamOrders;
			}
		} catch (Exception e) {
						 logger.error("Error occurred in OrderRepDAOImpl.getAllOrders() method: {}", e.getMessage());

			// Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}
		return slamOrders;
	}

}
