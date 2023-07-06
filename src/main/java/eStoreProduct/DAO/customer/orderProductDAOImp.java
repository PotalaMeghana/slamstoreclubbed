package eStoreProduct.DAO.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import eStoreProduct.model.customer.input.orderProductsMapper;
import eStoreProduct.model.customer.input.orderProductsModel;

public class orderProductDAOImp implements orderProductDAO {
	private EntityManager entityManager;
	private final JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ORDERPRODUCTS="select * from slam_orderProducts where ordr_id=?";
	private final String SQL_UPDATE_STATUS="update slam_orderproducts set orpr_shipment_status=? where ordr_id=? and prod_id=?";
	
	@Autowired
	public orderProductDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public List<orderProductsModel> getOrderWiseOrderProducts(int orderid) {
		List<orderProductsModel> opList =jdbcTemplate.query(SQL_GET_ORDERPRODUCTS,new Object[] { orderid}, new orderProductsMapper());
		return opList;
	}


	@Override
	public int updateOrderProductStatus(int oid, int pid, String status) {
		System.out.print(oid+""+pid+""+status);
		int x=jdbcTemplate.update(SQL_UPDATE_STATUS,status,oid,pid);
		System.out.print("\nrows effected"+x);
		return x;
	}
	
}
