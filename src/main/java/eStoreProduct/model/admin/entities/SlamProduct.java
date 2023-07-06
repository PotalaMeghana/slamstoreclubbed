package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slam_products")
public class SlamProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Integer id;

	@Column(name = "prod_title")
	private String title;

	@Column(name = "prod_prct_id")
	Integer productCategory;

	@Column(name = "prod_gstc_id")
	Integer hsnCode;

	@Column(name = "prod_brand")
	private String brand;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "prod_desc")
	private String description;

	@Column(name = "reorderLevel")
	private Integer reorderLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Integer productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Integer hsnCode) {
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

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public SlamProduct(Integer id, String title, Integer productCategory, Integer hsnCode, String brand,
			String imageUrl, String description, Integer reorderLevel) {
		super();
		this.id = id;
		this.title = title;
		this.productCategory = productCategory;
		this.hsnCode = hsnCode;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.description = description;
		this.reorderLevel = reorderLevel;
	}

	public SlamProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
