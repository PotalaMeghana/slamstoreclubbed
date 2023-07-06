package eStoreProduct.model.customer.input;

public class stockSummaryModel {
	private int prod_id;
	private String prod_title;
	private int prod_prct_id;
	private int prod_gstc_id;
	private String prod_brand;
	private String image_url;
	private String prod_desc;
	private int reorderlevel;
	private String prct_title;
	private double sgst;
	private double igst;
	private double cgst;
	private double gst;
	private double prod_price;
	private int prod_stock;
	private double prod_mrp;

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

	public int getProd_prct_id() {
		return prod_prct_id;
	}

	public void setProd_prct_id(int prod_prct_id) {
		this.prod_prct_id = prod_prct_id;
	}

	public int getProd_gstc_id() {
		return prod_gstc_id;
	}

	public void setProd_gstc_id(int prod_gstc_id) {
		this.prod_gstc_id = prod_gstc_id;
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

	public int getReorderlevel() {
		return reorderlevel;
	}

	public void setReorderlevel(int reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public String getPrct_title() {
		return prct_title;
	}

	public void setPrct_title(String prct_title) {
		this.prct_title = prct_title;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getProd_price() {
		return prod_price;
	}

	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_stock() {
		return prod_stock;
	}

	public void setProd_stock(int prod_stock) {
		this.prod_stock = prod_stock;
	}

	public double getProd_mrp() {
		return prod_mrp;
	}

	public void setProd_mrp(double prod_mrp) {
		this.prod_mrp = prod_mrp;
	}
}
