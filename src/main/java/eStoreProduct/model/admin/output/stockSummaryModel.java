package eStoreProduct.model.admin.output;

public class stockSummaryModel {
	// prod

	private int id;
	private String title;
	private int productCategory;
	private int hsnCode;
	private String brand;
	private String imageUrl;
	private String description;
	private int reorderLevel;
	// prodCAtegories
	private String prct_title;
	// from hsn code model
	private double sgst;
	private double igst;
	private double cgst;
	private double gst;
	// from prod stock model
	private double price;
	private int stock;
	private double mrp;

	public stockSummaryModel() {

	}

	public stockSummaryModel(int id, String title, int productCategory, int hsnCode, String brand, String imageUrl,
			String description, int reorderLevel, String prct_title, double sgst, double igst, double cgst, double gst,
			double price, int stock, double mrp) {
		super();
		this.id = id;
		this.title = title;
		this.productCategory = productCategory;
		this.hsnCode = hsnCode;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.description = description;
		this.reorderLevel = reorderLevel;
		this.prct_title = prct_title;
		this.sgst = sgst;
		this.igst = igst;
		this.cgst = cgst;
		this.gst = gst;
		this.price = price;
		this.stock = stock;
		this.mrp = mrp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public int getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(int hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReorderlevel() {
		return reorderLevel;
	}

	public void setReorderlevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getMrp() {
		return mrp;
	}

	@Override
	public String toString() {
		return "stockSummaryModel [id=" + id + ", title=" + title + ", productCategory=" + productCategory
				+ ", hsnCode=" + hsnCode + ", brand=" + brand + ", imageUrl=" + imageUrl + ", description="
				+ description + ", reorderLevel=" + reorderLevel + ", prct_title=" + prct_title + ", sgst=" + sgst
				+ ", igst=" + igst + ", cgst=" + cgst + ", gst=" + gst + ", price=" + price + ", stock=" + stock
				+ ", mrp=" + mrp + "]";
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

}
