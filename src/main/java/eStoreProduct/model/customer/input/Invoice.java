package eStoreProduct.model.customer.input;

import java.time.LocalDate;

public class Invoice {
	private long orderId;
	private String billNo;
	private LocalDate orderDate;
	private String paymentMode;
	private String shippingAddress;
	private LocalDate shipmentDate;
	private int quantity;
	private double gst;
	private double price;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Invoice [orderId=" + orderId + ", billNo=" + billNo + ", orderDate=" + orderDate + ", paymentMode="
				+ paymentMode + ", shippingAddress=" + shippingAddress + ", shipmentDate=" + shipmentDate
				+ ", quantity=" + quantity + ", gst=" + gst + ", price=" + price + "]";
	}

}
