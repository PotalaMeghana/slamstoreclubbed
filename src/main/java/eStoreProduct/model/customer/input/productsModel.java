/*
 * package eStoreProduct.model.customer.input;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "slam_products") public class productsModel {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "prod_id") private Integer id;
 * 
 * @Column(name = "prod_title") private String title;
 * 
 * // @ManyToOne // @JoinColumn(name = "prod_prct_id")
 * 
 * @Column(name = "prod_prct_id") Integer productCategory;
 * 
 * // @ManyToOne // @JoinColumn(name = "prod_gstc_id")
 * 
 * @Column(name = "prod_gstc_id") Integer hsnCode; // private HSNCodeModel
 * hsnCode;
 * 
 * public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public String getTitle() { return title; }
 * 
 * public void setTitle(String title) { this.title = title; }
 * 
 * public Integer getProductCategory() { return productCategory; }
 * 
 * public void setProductCategory(Integer productCategory) {
 * this.productCategory = productCategory; }
 * 
 * public Integer getHsnCode() { return hsnCode; }
 * 
 * public void setHsnCode(Integer hsnCode) { this.hsnCode = hsnCode; }
 * 
 * public String getBrand() { return brand; }
 * 
 * public void setBrand(String brand) { this.brand = brand; }
 * 
 * public String getImageUrl() { return imageUrl; }
 * 
 * public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
 * 
 * public String getDescription() { return description; }
 * 
 * public void setDescription(String description) { this.description =
 * description; }
 * 
 * public Integer getReorderLevel() { return reorderLevel; }
 * 
 * public void setReorderLevel(Integer reorderLevel) { this.reorderLevel =
 * reorderLevel; }
 * 
 * @Column(name = "prod_brand") private String brand;
 * 
 * @Column(name = "image_url") private String imageUrl;
 * 
 * @Column(name = "prod_desc") private String description;
 * 
 * @Column(name = "reorderLevel") private Integer reorderLevel;
 * 
 * // Constructors, getters, and setters
 * 
 * // ... }
 */