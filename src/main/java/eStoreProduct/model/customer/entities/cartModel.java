package eStoreProduct.model.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import eStoreProduct.model.admin.entities.productsModel;

@Entity
@Table(name = "slam_cart")
public class cartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cartId;

	@OneToOne
	@JoinColumn(name = "cust_id")
	private custCredModel customer;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private productsModel product;

	@Column(name = "quantity")
	private Integer quantity;

	// ...

	public cartModel() {
	}

	public cartModel(custCredModel customer, productsModel product, Integer quantity) {
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public custCredModel getCustomer() {
		return customer;
	}

	public void setCustomer(custCredModel customer) {
		this.customer = customer;
	}

	public productsModel getProduct() {
		return product;
	}

	public void setProduct(productsModel product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public cartModel(Integer cartId, custCredModel customer, productsModel product, Integer quantity) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

}
