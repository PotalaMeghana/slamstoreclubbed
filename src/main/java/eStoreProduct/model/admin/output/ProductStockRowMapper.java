package eStoreProduct.model.admin.output;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductStockRowMapper implements RowMapper<ProdStock> {
	@Override
	public ProdStock mapRow(ResultSet rs, int rowNum) throws SQLException {
		int prodId = rs.getInt("prod_id");
		double prodPrice = rs.getDouble("prod_price");
		int prodStock = rs.getInt("prod_stock");
		double prodMrp = rs.getDouble("prod_mrp");

		return new ProdStock(prodId, prodPrice, prodStock, prodMrp);
	}
} 