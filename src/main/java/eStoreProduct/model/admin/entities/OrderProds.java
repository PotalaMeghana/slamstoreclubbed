package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "slam_orderproducts")
public class OrderProds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op")
    private Integer id;

    
    @Column(name = "ordr_id")
    private Integer slamOrder;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlamOrder() {
        return slamOrder;
    }

    public void setSlamOrder(Integer slamOrder) {
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

   
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

}
