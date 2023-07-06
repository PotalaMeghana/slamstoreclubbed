package eStoreProduct.model.admin.input;

public class OrderValueWiseShippingChargesInput {

	private int id;
	private double from;
	private double to;
	private double shippingAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFrom() {
		return from;
	}

	public void setFrom(double from) {
		this.from = from;
	}

	public double getTo() {
		return to;
	}

	public void setTo(double to) {
		this.to = to;
	}

	public double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public OrderValueWiseShippingChargesInput(int id, double from, double to, double shippingAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.shippingAmount = shippingAmount;
	}

	public OrderValueWiseShippingChargesInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors

}
