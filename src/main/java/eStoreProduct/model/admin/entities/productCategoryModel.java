package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SLAM_PRODUCTCATEGORIES")
public class productCategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prct_id")
	private Long id;

	@Column(name = "prct_title")
	private String prct_title;

	@Column(name = "prct_desc")
	private String description;

	public String getPrct_title() {
		return prct_title;
	}

	public void setPrct_title(String prct_title) {
		this.prct_title = prct_title;
	}

	public productCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}