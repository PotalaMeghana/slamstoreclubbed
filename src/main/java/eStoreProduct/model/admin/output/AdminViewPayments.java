package eStoreProduct.model.admin.output;

import java.util.Date;

public class AdminViewPayments {

	private long id;
	private String billNumber;
	private Date orderDate;
	private double total;
	private String paymentReference;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public AdminViewPayments(long id, String billNumber, Date orderDate, double total, String paymentReference) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.orderDate = orderDate;
		this.total = total;
		this.paymentReference = paymentReference;
	}

	public AdminViewPayments() {
		super();
		// TODO Auto-generated constructor stub
	}

}