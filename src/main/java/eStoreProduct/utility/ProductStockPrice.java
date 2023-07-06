package eStoreProduct.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.admin.ProdStockDAO;

@Component
public class ProductStockPrice implements Comparable<ProductStockPrice> {

	private int prod_id;

	private String prod_title;
	private String prod_brand;
	private String image_url;
	private String prod_desc;
	private double price;
	private int quantity;

	private ProdStockDAO productStockDAO;

	@Autowired
	public ProductStockPrice(ProdStockDAO productStockDAO) {
		this.productStockDAO = productStockDAO;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_title() {
		return prod_title;
	}

	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}

	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice() {
		System.out.println("In setting price " + productStockDAO.getProdMrpById(prod_id) + "  for pid   " + prod_id);
		price = productStockDAO.getProdMrpById(prod_id);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(ProductStockPrice o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ProductStockPrice(int prod_id, String prod_title, String prod_brand, String image_url, String prod_desc,
			double price, int quantity) {
		super();
		this.prod_id = prod_id;

		this.prod_title = prod_title;
		this.prod_brand = prod_brand;
		this.image_url = image_url;
		this.prod_desc = prod_desc;
		this.price = price;
		this.quantity = quantity;

	}

	public ProductStockPrice(int prod_id, String prod_title, String prod_brand, String image_url, String prod_desc,
			double price) {
		super();
		this.prod_id = prod_id;

		this.prod_title = prod_title;
		this.prod_brand = prod_brand;
		this.image_url = image_url;
		this.prod_desc = prod_desc;
		this.price = price;
	}
}
