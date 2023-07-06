package eStoreProduct.model.customer.input;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class stockMapperMapper implements RowMapper<stockSummaryModel> {

	public stockSummaryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		stockSummaryModel ssm = new stockSummaryModel();
		ssm.setProd_id(rs.getInt("prod_id"));
		ssm.setProd_title(rs.getString("prod_title"));
		ssm.setProd_prct_id(Integer.parseInt(rs.getString("prod_prct_id")));
		ssm.setProd_gstc_id(Integer.parseInt(rs.getString("prod_gstc_id")));
		ssm.setProd_brand(rs.getString("prod_brand"));
		ssm.setImage_url(rs.getString("image_url"));
		ssm.setProd_desc(rs.getString("prod_desc"));
		ssm.setReorderlevel(rs.getInt("reorderlevel"));
		ssm.setPrct_title(rs.getString("prct_title"));
		ssm.setSgst(rs.getDouble("sgst"));
		ssm.setCgst(rs.getDouble("cgst"));
		ssm.setIgst(rs.getDouble("igst"));
		ssm.setGst(rs.getDouble("gst"));
		ssm.setProd_price(rs.getDouble("prod_price"));
		ssm.setProd_stock(rs.getInt("prod_stock"));
		ssm.setProd_mrp(rs.getDouble("prod_mrp"));
		return ssm;
	}
}
