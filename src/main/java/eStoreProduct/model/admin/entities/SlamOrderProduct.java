package eStoreProduct.model.admin.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(SlamOrderProductId.class)
@Table(name = "slam_orderproducts")
public class SlamOrderProduct {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "op") private Integer id;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "ordr_id", referencedColumnName = "ordr_id") private SlamOrderModel slamOrder;
	 * 
	 * @Column(name = "prod_id") private Integer productId;
	 */

	@Id
	@ManyToOne
	@JoinColumn(name = "ordr_id", referencedColumnName = "ordr_id")
	private SlamOrderModel slamOrder;

	@Id
	@Column(name = "prod_id")
	private Integer productId;

	@Column(name = "orpr_qty")
	private Integer quantity;

	@Column(name = "orpr_gst")
	private Double gst;

	@Column(name = "orpr_price")
	private Double price;

	@Column(name = "orpr_shipment_status")
	private String shipmentStatus;

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */

	public SlamOrderModel getSlamOrder() {
		return slamOrder;
	}

	public void setSlamOrder(SlamOrderModel slamOrder) {
		this.slamOrder = slamOrder;
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

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public SlamOrderProduct(SlamOrderModel slamOrder, Integer productId, Integer quantity, Double gst,
		Double price, String shipmentStatus) {
		super();
		// this.id = id;
		this.slamOrder = slamOrder;
		this.productId = productId;
		this.quantity = quantity;
		this.gst = gst;
		this.price = price;
		this.shipmentStatus = shipmentStatus;
	}

	public SlamOrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, and setters (omitted for brevity)

	// Add any additional methods or relationships here
}
