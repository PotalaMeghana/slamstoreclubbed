package eStoreProduct.model.admin.output;

public class orderProductsModel {
	private int ordr_id;
	private int prod_id;
	private int orpr_qty;
	private double orpr_gst;
	private double orpr_price;
	private String shipment_status;

	public int getOrdr_id() {
		return ordr_id;
	}

	public void setOrdr_id(int ordr_id) {
		this.ordr_id = ordr_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public int getOrpr_qty() {
		return orpr_qty;
	}

	public void setOrpr_qty(int orpr_qty) {
		this.orpr_qty = orpr_qty;
	}

	public double getOrpr_gst() {
		return orpr_gst;
	}

	public void setOrpr_gst(double orpr_gst) {
		this.orpr_gst = orpr_gst;
	}

	public double getOrpr_price() {
		return orpr_price;
	}

	public void setOrpr_price(double orpr_price) {
		this.orpr_price = orpr_price;
	}

	public String getShipment_status() {
		return shipment_status;
	}

	

	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}

	
	public orderProductsModel(int ordr_id, int prod_id, int orpr_qty, double orpr_gst, double orpr_price,
			String shipment_status) {
		super();
		this.ordr_id = ordr_id;
		this.prod_id = prod_id;
		this.orpr_qty = orpr_qty;
		this.orpr_gst = orpr_gst;
		this.orpr_price = orpr_price;
		this.shipment_status = shipment_status;
	}
	public orderProductsModel() {
		
	}
	
}
