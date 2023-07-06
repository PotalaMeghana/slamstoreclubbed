package eStoreProduct.DAO.customer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.customer.input.ServicableRegionMapper;
import eStoreProduct.model.customer.input.ServiceableRegion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ServicableRegionDAOImp implements ServicableRegionDAO {
	private String getPincodes = "select * from slam_regions";
	JdbcTemplate jdbcTemplate;
	private static final Logger logger = 
			LoggerFactory.getLogger(ServicableRegionDAOImp.class);

	@Autowired
	public ServicableRegionDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public boolean getValidityOfPincode(int pincode) {
		//method to get check the pincode validation
		logger.info("eStoreProduct:DAO:ServicableRegionDAOImp:checking the pincode validation");
		List<ServiceableRegion> rg = jdbcTemplate.query(getPincodes, new ServicableRegionMapper());
		for (ServiceableRegion r : rg) {
			if (pincode >= r.getSrrgPinFrom() && pincode <= r.getSrrgPinTo()) {
				return true;
			}
		}
		return false;
	}
}
