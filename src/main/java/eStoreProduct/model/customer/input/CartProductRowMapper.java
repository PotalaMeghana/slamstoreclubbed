package eStoreProduct.model.customer.input;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.admin.ProdStockDAO;
import eStoreProduct.utility.ProductStockPriceForCust;

@Component
public class CartProductRowMapper implements RowMapper<ProductStockPriceForCust> {
	private ProdStockDAO prodStockDAO;

	public CartProductRowMapper(ProdStockDAO prodStockDAO) {
		this.prodStockDAO = prodStockDAO;
	}

	@Override
	public ProductStockPriceForCust mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductStockPriceForCust product = new ProductStockPriceForCust(prodStockDAO);
		product.setProd_id(rs.getInt("prod_id"));
		product.setProd_title(rs.getString("prod_title"));
		product.setProd_brand(rs.getString("prod_brand"));
		product.setImage_url(rs.getString("image_url"));
		product.setProd_desc(rs.getString("prod_desc"));
		product.setPrice();
		product.setMrp();
		product.setQuantity(rs.getInt("quantity"));
		product.setProd_gstc_id(rs.getInt("prod_gstc_id"));
		product.setProduct_stock();

		return product;
	}
}