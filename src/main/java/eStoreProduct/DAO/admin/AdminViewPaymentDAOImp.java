package eStoreProduct.DAO.admin;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eStoreProduct.model.admin.output.AdminViewPayments;

@Component
public class AdminViewPaymentDAOImp implements AdminViewPaymentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = LoggerFactory.getLogger(AdminViewPaymentDAOImp.class);

	@Override
	@Transactional
	public List<AdminViewPayments> getPayments() {
		// System.out.println("in admin payments");

		logger.info("entered AdminViewPaymentDAOImp.getPayments() method to get all payments");
		TypedQuery<AdminViewPayments> query = entityManager.createQuery(

				"SELECT new eStoreProduct.model.admin.output.AdminViewPayments(om.id,om.billNumber,om.orderDate,om.total, om.paymentReference)"
						+ " FROM orderModel om",
				AdminViewPayments.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<AdminViewPayments> getPaymentsBetweenDates(Timestamp date1, Timestamp date2) {
		logger.info("entered AdminViewPaymentDAOImp.getPaymentsBetweenDates() method to get payments between dates selected");
		TypedQuery<AdminViewPayments> query = entityManager.createQuery(
				"SELECT new eStoreProduct.model.admin.output.AdminViewPayments(om.id, om.billNumber, om.orderDate, om.total, om.paymentReference) "
						+ "FROM orderModel om WHERE om.orderDate BETWEEN :date1 AND :date2",
				AdminViewPayments.class);
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<AdminViewPayments> getPaymentsInThePriceRange(double p1, double p2) {
		logger.info("entered AdminViewPaymentDAOImp.getPaymentsInThePriceRange() method to getthe payments in the price range");
		TypedQuery<AdminViewPayments> query = entityManager.createQuery(
				"SELECT new eStoreProduct.model.admin.output.AdminViewPayments(om.id,om.billNumber,om.orderDate,om.total, om.paymentReference) "
						+ "FROM orderModel om WHERE om.total BETWEEN :p1 AND :p2",
				AdminViewPayments.class);
		query.setParameter("p1", p1);
		query.setParameter("p2", p2);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<AdminViewPayments> getMaxPricePayment(double p1) {
		logger.info("entered AdminViewPaymentDAOImp.getMaxPricePayment() method to get highest paid payment");
		TypedQuery<AdminViewPayments> query = entityManager.createQuery(
				"SELECT new eStoreProduct.model.admin.output.AdminViewPayments(om.id,om.billNumber,om.orderDate,om.total, om.paymentReference)"
						+ " FROM orderModel om WHERE om.total > :p1",
				AdminViewPayments.class);
		query.setParameter("p1", p1);
		return query.getResultList();
	}

}