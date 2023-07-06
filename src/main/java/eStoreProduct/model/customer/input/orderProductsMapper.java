package eStoreProduct.model.customer.input;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class orderProductsMapper implements RowMapper<orderProductsModel> {

	public orderProductsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		orderProductsModel opm = new orderProductsModel();
		opm.setOrdr_id(rs.getInt("ordr_id"));
		opm.setProd_id(rs.getInt("prod_id"));
		opm.setOrpr_qty(rs.getInt("orpr_qty"));
		opm.setOrpr_gst(rs.getDouble("orpr_gst"));
		opm.setOrpr_price(rs.getDouble("orpr_price"));
		opm.setShipment_status(rs.getString("orpr_shipment_status"));
		return opm;
	}
}
