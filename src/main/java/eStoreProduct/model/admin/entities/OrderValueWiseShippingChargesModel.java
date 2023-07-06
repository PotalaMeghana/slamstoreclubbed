package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slam_ordervaluewiseshippingcharges")
public class OrderValueWiseShippingChargesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orvl_id")
	private int id;

	@Column(name = "orvl_from")
	private double from;

	@Column(name = "orvl_to")
	private double to;

	@Column(name = "orvl_shippingamount")
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

	public OrderValueWiseShippingChargesModel(int id, double from, double to, double shippingAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.shippingAmount = shippingAmount;
	}

	public OrderValueWiseShippingChargesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, and setters

}
