package eStoreProduct.model.admin.input;

public class orderProductInput {
	private int prod_id;
	private int ordr_id;
	private String shipment_status;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public int getOrdr_id() {
		return ordr_id;
	}
	public void setOrdr_id(int ordr_id) {
		this.ordr_id = ordr_id;
	}
	public String getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
	
}
