package eStoreProduct.DAO.admin;

import java.sql.Timestamp;
import java.util.List;

import eStoreProduct.model.admin.output.AdminViewPayments;

public interface AdminViewPaymentDAO {

	public List<AdminViewPayments> getPayments();

	// public List<AdminViewPayments> getDatePayments();

	public List<AdminViewPayments> getPaymentsBetweenDates(Timestamp date1, Timestamp date2);

	public List<AdminViewPayments> getPaymentsInThePriceRange(double p1, double p2);

	public List<AdminViewPayments> getMaxPricePayment(double p1);
}