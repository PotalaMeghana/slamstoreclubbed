package eStoreProduct.model.customer.input;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ServicableRegionMapper implements RowMapper<ServiceableRegion> {
	@Override
	public ServiceableRegion mapRow(ResultSet rs, int rowNum) throws SQLException {
		int srrgId = rs.getInt("region_id");
		String srrgName = rs.getString("region_name");
		int srrgPinFrom = rs.getInt("region_pin_from");
		int srrgPinTo = rs.getInt("region_pin_to");
		double srrgPriceSurcharge = rs.getDouble("region_surcharge");
		double srrgPriceWaiver = rs.getDouble("region_pricewaiver");

		return new ServiceableRegion(srrgId, srrgName, srrgPinFrom, srrgPinTo, srrgPriceSurcharge, srrgPriceWaiver);
	}
}
