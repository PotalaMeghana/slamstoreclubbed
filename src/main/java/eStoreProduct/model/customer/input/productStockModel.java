/*
 * package eStoreProduct.model.customer.input;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "slam_ProductStock") public class productStockModel implements
 * Serializable {
 * 
 * @Id
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "prod_id") private productsModel product;
 * 
 * @Column(name = "prod_price") private double price;
 * 
 * public productsModel getProduct() { return product; }
 * 
 * public void setProduct(productsModel product) { this.product = product; }
 * 
 * public double getPrice() { return price; }
 * 
 * public void setPrice(double price) { this.price = price; }
 * 
 * public Integer getStock() { return stock; }
 * 
 * public void setStock(Integer stock) { this.stock = stock; }
 * 
 * public Integer getMrp() { return mrp; }
 * 
 * public void setMrp(Integer mrp) { this.mrp = mrp; }
 * 
 * @Column(name = "prod_stock") private Integer stock;
 * 
 * @Column(name = "prod_mrp") private Integer mrp;
 * 
 * }
 */