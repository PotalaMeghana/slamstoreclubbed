package eStoreProduct.model.admin.entities;

import javax.persistence.*;

@Entity
@Table(name = "slam_OrderProducts")
public class orderProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordr_id")
    private Integer orderId;

    @Column(name = "prod_id")
    private Integer productId;

  

    @Column(name = "orpr_qty")
    private Integer quantity;

    @Column(name = "orpr_gst")
    private double gst;

    @Column(name = "orpr_price")
    private double price;

    

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	@Column(name = "orpr_shipment_status")
    private String shipmentStatus;

	
	public orderProductModel(Integer orderId, Integer productId, Integer quantity, double gst, double price,
			String shipmentStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.gst = gst;
		this.price = price;
		this.shipmentStatus = shipmentStatus;
	}
	
	public orderProductModel() {
		
	}
    // Constructors, getters, and setters
}

