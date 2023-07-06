package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slam_HSN_Code")
public class HSNCodeModel {
	@Id
	@Column(name = "hsn_code")
	private Integer hsnCode;

	public HSNCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "sgst")
	private double sgst;

	@Column(name = "igst")
	private double igst;

	@Column(name = "cgst")
	private double cgst;

	@Column(name = "gst")
	private double gst;

	public Integer getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Integer hsnCode) {
		this.hsnCode = hsnCode;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	// Constructors, getters, and setters

	// ...
}
