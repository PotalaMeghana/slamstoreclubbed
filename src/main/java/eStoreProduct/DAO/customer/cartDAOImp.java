package eStoreProduct.DAO.customer;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.entities.HSNCodeModel;
import eStoreProduct.model.customer.input.CartProductRowMapper;
//import eStoreProduct.model.customer.input.HSNCodeModel;
import eStoreProduct.model.customer.input.ServiceableRegion;
import eStoreProduct.model.customer.input.cartModel;
import eStoreProduct.DAO.admin.ProdStockDAO;
import eStoreProduct.utility.ProductStockPriceForCust;

@Component
public class cartDAOImp implements cartDAO {
	JdbcTemplate jdbcTemplate;
	private ProdStockDAO prodStockDAO;
	private static final Logger logger = LoggerFactory.getLogger(cartDAOImp.class);

	@Autowired
	public cartDAOImp(DataSource dataSource, ProdStockDAO prodStockDAO) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		this.prodStockDAO = prodStockDAO;
	}

	private String insert_slam_cart = "INSERT INTO slam_cart (cust_id,prod_id,quantity) VALUES (?, ?,1)";
	private String delete_slam_cart = "DELETE FROM SLAM_CART WHERE cust_id=? AND prod_id=?";
	private String select_cart_products = "SELECT pd.*,sc.* FROM slam_Products pd, slam_cart sc WHERE sc.cust_id = ? AND sc.prod_id = pd.prod_id";
	private String update_qty = "update slam_cart set quantity=? where cust_id=? and prod_id=?";
	private String insert = "insert into slam_cart values(?,?,?);";
	private String select_checkcart_products = "SELECT pd.*,sc.* FROM slam_Products pd, slam_cart sc WHERE sc.cust_id = ? AND sc.prod_id = pd.prod_id and pd.prod_id=?";

	// method to add the product to customet cart
	public String addToCart(int productId, int customerId) {
		logger.info("eStoreProduct:cartDAOImp::adding product to cart table in database");

		List<ProductStockPriceForCust> cproducts = jdbcTemplate.query(select_checkcart_products,
				new CartProductRowMapper(prodStockDAO), customerId, productId);
		int r;
		int flag = 0;
		for (ProductStockPriceForCust product : cproducts) {
			System.out.println(product.getProd_id() + "         " + productId);
			if (product.getProd_id() == productId) {
				flag = 1;
			}
		}
		if (flag == 0) {
			r = jdbcTemplate.update(insert_slam_cart, customerId, productId);
			if (r > 0) {
				System.out.println("inserted into cart");
				return "Added to cart";
			}
			return "error";
		}
		return "Already added to cart";
	}

	// method to remove item from cart
	public int removeFromCart(int productId, int customerId) {
		logger.info("eStoreProduct:cartDAOImp::Deleting product from cart table");

		int r = jdbcTemplate.update(delete_slam_cart, customerId, productId);
		if (r > 0) {
			System.out.println("deleted from  cart");
			return productId;
		} else {
			return -1;
		}
	}

	// method to get all cart products
	public List<ProductStockPriceForCust> getCartProds(int cust_id) {
		logger.info("eStoreProduct:cartDAOImp::Retriving all products from cart");

		System.out.println(cust_id + " from model");
		try {
			List<ProductStockPriceForCust> cproducts = jdbcTemplate.query(select_cart_products,
					new CartProductRowMapper(prodStockDAO), cust_id);
			System.out.println(cproducts.toString());
			return cproducts;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}

	}

	// update the quantity
	@Override
	public int updateQty(cartModel cm) {
		logger.info("eStoreProduct:cartDAOImp::updating the quantity of  product in cart table");
		int r = jdbcTemplate.update(update_qty, cm.getQty(), cm.getCid(), cm.getPid());
		if (r > 0) {
			System.out.println("updated in cart");
			return r;
		} else {
			return -1;
		}
	}

	// insert
	public int updateinsert(List<ProductStockPriceForCust> products, int cust_id) {
		int r = -1;
		for (ProductStockPriceForCust ps : products) {
			r = jdbcTemplate.update(insert, cust_id, ps.getProd_id(), ps.getQuantity());
		}
		return r;
	}

	// get gsts by respective hsncode
	public HSNCodeModel getHSNCodeByProductId(int prodId) {
		logger.info("eStoreProduct:cartDAOImp::getting the gsts based on the product hsn_code from data base");

		String sql = "SELECT hsn_code, sgst, igst, cgst, gst " + "FROM slam_HSN_Code " + "WHERE hsn_code = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { prodId }, (resultSet, rowNum) -> {
			HSNCodeModel hsnCodeModel = new HSNCodeModel();
			hsnCodeModel.setHsnCode(resultSet.getInt("hsn_code"));
			hsnCodeModel.setSgst(resultSet.getDouble("sgst"));
			hsnCodeModel.setIgst(resultSet.getDouble("igst"));
			hsnCodeModel.setCgst(resultSet.getDouble("cgst"));
			hsnCodeModel.setGst(resultSet.getDouble("gst"));
			return hsnCodeModel;
		});
	}

	// method to get the servicable regions data
	public ServiceableRegion getRegionByPincode(int pincode) {
		logger.info("eStoreProduct:cartDAOImp::based on pincode get the surcharges and pricewaivers data from regions table ");

		String query = "SELECT * FROM slam_regions WHERE ? BETWEEN region_pin_from AND region_pin_to";

		// Define the RowMapper to map the query result to the RegionModel object
		RowMapper<ServiceableRegion> rowMapper = (rs, rowNum) -> {
			ServiceableRegion region = new ServiceableRegion();
			region.setSrrgId(rs.getInt("region_id"));
			region.setSrrgPriceSurcharge(rs.getDouble("region_surcharge"));
			region.setSrrgPriceWaiver(rs.getDouble("region_pricewaiver"));
			return region;
		};

		// Execute the query and retrieve the region based on the pincode
		List<ServiceableRegion> regions = jdbcTemplate.query(query, rowMapper, pincode);

		// Check if a region was found and return it, otherwise return null
		if (regions.isEmpty()) {
			return null;
		} else {
			return regions.get(0);
		}
	}

	
}
