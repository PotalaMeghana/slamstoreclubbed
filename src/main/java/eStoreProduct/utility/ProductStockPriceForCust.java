package eStoreProduct.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.admin.ProdStockDAO;
import eStoreProduct.model.admin.output.ProdStock;

@Component
public class ProductStockPriceForCust implements Comparable<ProductStockPriceForCust> {

	private int prod_id;
	private double gst;
	private String prod_title;
	private String prod_brand;
	private String image_url;
	private String prod_desc;
	private double price;
	private int quantity;
	private int prod_gstc_id;
	private int product_stock;
	//private int productstock;
	private ProdStockDAO productStockDAO;

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock() {
		this.product_stock = productStockDAO.getProdStockById(prod_id).getProdStock();;
	}

	public int getProd_gstc_id() {
		return prod_gstc_id;
	}

	public void setProd_gstc_id(int prod_gstc_id) {
		this.prod_gstc_id = prod_gstc_id;
	}

	double qtyprice;
	double mrp;
	double sgst;
	double cgst;
	double igst;
	double shipcharge;
	static double total;

	

	public double getGst() {
		return gst;
	}

	public double getMrp() {
		return mrp;
	}

	public double getQtyprice() {
		return qtyprice;
	}

	public void setQtyprice(double qtyprice) {
		this.qtyprice = qtyprice;
	}

	public void setMrp() {
		mrp = productStockDAO.getProdMrpById(prod_id);
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getShipcharge() {
		return shipcharge;
	}

	public void setShipcharge(double shipcharge) {
		this.shipcharge = shipcharge;
	}

	public static double getTotal() {
		return total;
	}

	public static void setTotal(double total) {
		ProductStockPriceForCust.total = total;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	@Autowired
	public ProductStockPriceForCust(ProdStockDAO productStockDAO) {
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
		price = productStockDAO.getProdPriceById(prod_id);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(ProductStockPriceForCust o) {
		if (this.getPrice() > o.getPrice())
			return 1;
		else if (this.getPrice() == o.getPrice())
			return 0;
		return -1;

	}
}
