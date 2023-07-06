package eStoreProduct.model.customer.output;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrdersViewModel> {

	@Override
	public OrdersViewModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("prod_id");
		String name = resultSet.getString("prod_title");
		double price = resultSet.getDouble("prod_price");
		String description = resultSet.getString("prod_desc");
		String imageUrl = resultSet.getString("image_url");
		int ordid = resultSet.getInt("ordr_id");
		String ship_stat = resultSet.getString("orpr_shipment_status");

		return new OrdersViewModel(id, name, price, description, imageUrl, ordid, ship_stat);
	}
}
