package eStoreProduct.model.admin.output;

public class CategoryReportViewModel {
	private long ptct_id;
	private String ptct_name;
	private long total_sales;
	private double total_amount;
	private double total_gst;
	private int total_products;

	public long getPtct_id() {
		return ptct_id;
	}

	public void setPtct_id(long ptct_id) {
		this.ptct_id = ptct_id;
	}

	public String getPtct_name() {
		return ptct_name;
	}

	public void setPtct_name(String ptct_name) {
		this.ptct_name = ptct_name;
	}

	public long getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(long total_sales) {
		this.total_sales = total_sales;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public int getTotal_products() {
		return total_products;
	}

	public void setTotal_products(int total_products) {
		this.total_products = total_products;
	}

	public double getTotal_gst() {
		return total_gst;
	}

	public void setTotal_gst(double total_gst) {
		this.total_gst = total_gst;
	}

	public CategoryReportViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryReportViewModel(long id, String prct_title, long total_sales, double total_amount, double total_gst,
			long total_products) {
		super();
		this.ptct_id = id;
		this.ptct_name = prct_title;
		this.total_sales = total_sales;
		this.total_amount = total_amount;
		this.total_gst = total_gst;
		this.total_products = (int) total_products;
	}

	@Override
	public String toString() {
		return "CategoryReportViewModel [ptct_id=" + ptct_id + ", ptct_name=" + ptct_name + ", total_sales="
				+ total_sales + ", total_amount=" + total_amount + ", total_gst=" + total_gst + ", total_products="
				+ total_products + "]";
	}

}
