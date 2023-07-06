package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slam_ProductStock")
public class productStockModel {
	@Id
	// @ManyToOne
	@Column(name = "prod_id")
	private int product;

	@Column(name = "prod_price")
	private double price;

	@Column(name = "prod_stock")
	private Integer stock;

	@Column(name = "prod_mrp")
	private double mrp;

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public productStockModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}