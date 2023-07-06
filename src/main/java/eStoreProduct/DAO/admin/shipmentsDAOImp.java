package eStoreProduct.DAO.admin;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class shipmentsDAOImp implements shipmentsDAO {

	private EntityManager entityManager;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public shipmentsDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
