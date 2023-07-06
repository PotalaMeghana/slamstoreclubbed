package eStoreProduct.model.customer.input;

import java.util.Date;

public class Order {

	private int custid;
	private int ordr_id;
	private String ord_billno;
	private double order_gst;
	private String custname;
	private String location;
	private String mobile;
	private String saddress;
	private String spincode;
	private double ordertotal;
	private String orderpayid;
	private Date orderdate;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getOrdr_id() {
		return ordr_id;
	}

	public void setOrdr_id(int ordr_id) {
		this.ordr_id = ordr_id;
	}

	public String getOrd_billno() {
		return ord_billno;
	}

	public void setOrd_billno(String ord_billno) {
		this.ord_billno = ord_billno;
	}

	public double getOrder_gst() {
		return order_gst;
	}

	public void setOrder_gst(double d) {
		this.order_gst = d;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSpincode() {
		return spincode;
	}

	public void setSpincode(String spincode) {
		this.spincode = spincode;
	}

	public double getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}

	public String getOrderpayid() {
		return orderpayid;
	}

	public void setOrderpayid(String orderpayid) {
		this.orderpayid = orderpayid;
	}

	
	  public Date getOrderdate() { return orderdate; }
	  
	  public void setOrderdate(Date orderdate) { this.orderdate = orderdate; }
	 

}
