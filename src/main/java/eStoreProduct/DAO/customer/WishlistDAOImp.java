package eStoreProduct.DAO.customer;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.utility.ProductStockPriceForCust;
import eStoreProduct.model.customer.input.WishlistRowMapper;
import eStoreProduct.DAO.admin.ProdStockDAO;

@Component
public class WishlistDAOImp implements WishlistDAO {

	JdbcTemplate jdbcTemplate;
	private ProdStockDAO prodStockDAO;
	private WishlistDAO wishlistdao;
	private static final Logger logger = LoggerFactory.getLogger(WishlistDAOImp.class);

	@Autowired
	public WishlistDAOImp(DataSource dataSource, ProdStockDAO prodStockDAO) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		this.prodStockDAO = prodStockDAO;
	}

	public void setWishlistDAO(WishlistDAO wishlistdao) {
		this.wishlistdao = wishlistdao;
	}

	private String insert_slam_wishlist = "INSERT INTO slam_wishlist (cust_id,prod_id) VALUES (?, ?)";
	private String delete_slam_wishlist = "DELETE FROM slam_wishlist WHERE cust_id=? AND prod_id=?";
	private String select_slam_wishlist = "SELECT pd.* FROM slam_Products pd, slam_wishlist sc WHERE sc.cust_id = ? AND sc.prod_id = pd.prod_id";

	// method to add product to wishlist
	public int addToWishlist(int productId, int customerId) {
		logger.info("eStoreProduct:WishlistDAOImp:adding product to wishlist table");

		int r = jdbcTemplate.update(insert_slam_wishlist, customerId, productId);
		if (r > 0) {
			return productId;
		} else {
			return -1;
		}
	}

	// method to remove product to wishlist
	public int removeFromWishlist(int productId, int customerId) {
		logger.info("eStoreProduct:WishlistDAOImp:Deleting product from wishlist table");

		int r = jdbcTemplate.update(delete_slam_wishlist, customerId, productId);
		if (r > 0) {
			System.out.println("deleted from  cart");
			return productId;
		} else {
			return -1;
		}
	}

	// method to retrieve the all wishlist products
	public List<ProductStockPriceForCust> getWishlistProds(int cust_id) {
		logger.info("eStoreProduct:WishlistDAOImp: method to retrieve the all wishlist products");

		List<ProductStockPriceForCust> cproducts = null;
		try {
			cproducts = jdbcTemplate.query(select_slam_wishlist,new WishlistRowMapper(prodStockDAO), cust_id );
			System.out.println(cproducts.toString());
			return cproducts;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}
	}
}
