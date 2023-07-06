package eStoreProduct.model.customer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "slam_wishlist")
public class WishlistModel {

	@EmbeddedId
	private WishlistItemId id;

	public WishlistItemId getId() {
		return id;
	}

	public void setId(WishlistItemId id) {
		this.id = id;
	}

	@MapsId("custId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private custCredModel customer;

	public WishlistModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishlistModel(WishlistItemId id) {
		super();
		this.id = id;
	}

	// Constructors, getters, and setters
}

@Embeddable
class WishlistItemId implements Serializable {

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "prod_id")
	private int prodId;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public WishlistItemId(int custId, int prodId) {
		super();
		this.custId = custId;
		this.prodId = prodId;
	}

	public WishlistItemId() {
		super();
		// TODO Auto-generated constructor stub
	}

}
