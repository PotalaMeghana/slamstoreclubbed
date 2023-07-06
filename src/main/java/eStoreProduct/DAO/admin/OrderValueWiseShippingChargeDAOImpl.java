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

import eStoreProduct.model.admin.entities.OrderValueWiseShippingChargesModel;
import eStoreProduct.model.admin.input.OrderValueWiseShippingChargesInput;
import eStoreProduct.model.admin.output.OrderValueWiseShippingCharge;

@Component
public class OrderValueWiseShippingChargeDAOImpl implements OrderValueWiseShippingChargeDAO {
    private static final Logger logger = LoggerFactory.getLogger(OrderValueWiseShippingChargeDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<OrderValueWiseShippingCharge> getAll() {
				    logger.info("in OrderValueWiseShippingChargeDAOImpl.getAll() ");

		try {
			TypedQuery<OrderValueWiseShippingCharge> query = entityManager.createQuery(
					"SELECT NEW eStoreProduct.model.admin.output.OrderValueWiseShippingCharge("
							+ "ow.id,ow.from,ow.to,ow.shippingAmount)"
							+ " FROM eStoreProduct.model.admin.entities.OrderValueWiseShippingChargesModel ow",
					OrderValueWiseShippingCharge.class);
			List<OrderValueWiseShippingCharge> ordervaluecharges = query.getResultList();
			System.out.print("in getting all ordervaluecharges\n");

			return ordervaluecharges;
		} catch (Exception e) {
									 logger.error("Error occurred in OrderValueWiseShippingChargeDAOImpl.getAll() method: {}", e.getMessage());

			// Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}
	}

	@Override
	@Transactional
	public boolean addCharge(OrderValueWiseShippingChargesInput ord) {
						    logger.info("in OrderValueWiseShippingChargeDAOImpl.addCharge() ");

		// TODO Auto-generated method stub
		OrderValueWiseShippingChargesModel ordervaluecharges = new OrderValueWiseShippingChargesModel();
		ordervaluecharges.setId(ord.getId());
		ordervaluecharges.setFrom(ord.getFrom());
		ordervaluecharges.setTo(ord.getTo());
		ordervaluecharges.setShippingAmount(ord.getShippingAmount());
		try {
			entityManager.merge(ordervaluecharges);
			return true;
		}

		catch (Exception e) {
												 logger.error("Error occurred in OrderValueWiseShippingChargeDAOImpl.addCharge() method: {}", e.getMessage());

			// Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
			e.printStackTrace();
			return false; // or throw an exception if required
		}
	}

	@Override
	@Transactional
	public boolean deleteCharge(OrderValueWiseShippingChargesInput ord) {
								    logger.info("in OrderValueWiseShippingChargeDAOImpl.deleteCharge() ");

		int id = ord.getId();
		OrderValueWiseShippingChargesModel ordervaluecharges = entityManager
				.find(OrderValueWiseShippingChargesModel.class, id);
		if (ordervaluecharges != null) {
			entityManager.remove(ordervaluecharges);
			return true;
		}
										    logger.info("in OrderValueWiseShippingChargeDAOImpl.deleteCharge() no record is found");

		return false;
	}

	@Override
	@Transactional
	public boolean updateCharge(OrderValueWiseShippingChargesInput ord) {
										    logger.info("in OrderValueWiseShippingChargeDAOImpl.updateCharge() ");

		try {
			int id = ord.getId();
			OrderValueWiseShippingChargesModel ordervaluecharges = entityManager
					.find(OrderValueWiseShippingChargesModel.class, id);
			if (ordervaluecharges != null) {
				ordervaluecharges.setFrom(ord.getFrom());
				ordervaluecharges.setTo(ord.getTo());
				ordervaluecharges.setShippingAmount(ord.getShippingAmount());
				entityManager.merge(ordervaluecharges);
				return true;
			}
			return false;
		} catch (Exception e) {
															 logger.error("Error occurred in OrderValueWiseShippingChargeDAOImpl.updateCharge() method: {}", e.getMessage());

			e.printStackTrace();
			return false;
		}
	}

}
