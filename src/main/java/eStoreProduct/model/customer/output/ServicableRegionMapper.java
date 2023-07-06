package eStoreProduct.model.customer.output;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ServicableRegionMapper implements RowMapper<ServiceableRegion> {
	@Override
	public ServiceableRegion mapRow(ResultSet rs, int rowNum) throws SQLException {
		int srrgId = rs.getInt("srrg_id");
		String srrgName = rs.getString("srrg_name");
		int srrgPinFrom = rs.getInt("srrg_pinfrom");
		int srrgPinTo = rs.getInt("srrg_pinto");
		double srrgPriceSurcharge = rs.getDouble("srrg_pricesurcharge");
		double srrgPriceWaiver = rs.getDouble("srrg_pricewaiver");

		return new ServiceableRegion(srrgId, srrgName, srrgPinFrom, srrgPinTo, srrgPriceSurcharge, srrgPriceWaiver);
	}
}
