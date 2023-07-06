package eStoreProduct.model.admin.output;

public class ProdStock {
	private int prod_id;
	private double prod_price;
	private int prod_stock;
	private double prod_mrp;

	public ProdStock(int prod_id, double prod_price, int prod_stock, double prod_mrp) {
		this.prod_id = prod_id;
		this.prod_price = prod_price;
		this.prod_stock = prod_stock;
		this.prod_mrp = prod_mrp;
	}

	public int getProdId() {
		return prod_id;
	}

	public void setProdId(int prod_id) {
		this.prod_id = prod_id;
	}

	public double getProdPrice() {
		return prod_price;
	}

	public void setProdPrice(double prod_price) {
		this.prod_price = prod_price;
	}

	public int getProdStock() {
		return prod_stock;
	}

	public void setProdStock(int prod_stock) {
		this.prod_stock = prod_stock;
	}

	public double getProdMrp() {
		return prod_mrp;
	}

	public void setProdMrp(double prod_mrp) {
		this.prod_mrp = prod_mrp;
	}
}