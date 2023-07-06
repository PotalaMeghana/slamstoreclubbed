package eStoreProduct.model.admin.input;

public class Category {
	private Integer prct_id;
	private String prct_title;
	private String prct_desc;

	public Category() {

	}

	public Category(long prct_id, String prct_title, String prct_desc) {
		super();
		this.prct_id = (int) prct_id;
		this.prct_title = prct_title;
		this.prct_desc = prct_desc;
	}

	public Category(int prct_id, String prct_title, String prct_desc) {
		super();
		this.prct_id = prct_id;
		this.prct_title = prct_title;
		this.prct_desc = prct_desc;
	}

	public Integer getPrct_id() {
		return prct_id;
	}

	public void setPrct_id(int prct_id) {
		this.prct_id = prct_id;
	}

	public String getPrct_title() {
		return prct_title;
	}

	public void setPrct_title(String prct_title) {
		this.prct_title = prct_title;
	}

	public String getPrct_desc() {
		return prct_desc;
	}

	public void setPrct_desc(String prct_desc) {
		this.prct_desc = prct_desc;
	}
}