package eStoreProduct.DAO.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.customer.input.custCredModel;
import eStoreProduct.model.customer.input.customerMapper;
import eStoreProduct.model.customer.input.passwordHashing;

@Component
public class customerDAOImp1 implements customerDAO1 {

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_CUSTOMER = "insert into slam_customers(cust_name,  cust_mobile , cust_regdate ,cust_location , cust_email ,cust_address, cust_pincode , cust_saddress,cust_spincode,cust_status ,cust_lastlogindate, cust_password ) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_CHECK_CUSTOMER = "select * from slam_customers where cust_email=? and cust_password=? ";

	// dependency injection
	@Autowired
	public customerDAOImp1(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@PersistenceContext
	private EntityManager em;

	public void persist(custCredModel ccm) {
		em.persist(ccm);
	}

	// method to save new customer
	public boolean createCustomer(custCredModel ccm) {
		System.out.println("spincode:" + ccm.getCustSpincode());
		return jdbcTemplate.update(SQL_INSERT_CUSTOMER, ccm.getCustName(), ccm.getCustMobile(), ccm.getCustRegDate(),
				ccm.getCustLocation(), ccm.getCustEmail(), ccm.getCustAddress(), ccm.getCustPincode(),
				ccm.getCustSAddress(), ccm.getCustSpincode(), ccm.getCustStatus(), ccm.getCustLastLoginDate(),
				ccm.getCustPassword()) > 0;
	}

	// method to update the last login of the customer
	public void updateLastLogin(int cid) {
		String updateQuery = "UPDATE slam_customers SET cust_lastlogindate = CURRENT_TIMESTAMP WHERE cust_id = ?";
		jdbcTemplate.update(updateQuery, cid);
	}

	// method to update the details updated by the customer
	public void updateCustomer(custCredModel ccm) {
		String updateQuery = "UPDATE slam_customers SET cust_name = ?, cust_mobile = ?, cust_location = ?, cust_address = ?,cust_pincode = ?, cust_saddress = ?,cust_spincode=?  WHERE cust_id = ?";

		jdbcTemplate.update(updateQuery, ccm.getCustName(), ccm.getCustMobile(), ccm.getCustLocation(),
				ccm.getCustAddress(), ccm.getCustPincode(), ccm.getCustSAddress(), ccm.getCustSpincode(),
				ccm.getCustId());
	}

	// method to get the customer based on id
	public custCredModel getCustomerById(int id) {
		String custSelect = "SELECT * FROM slam_customers WHERE cust_id=?";
		custCredModel cu = null;

		try {
			cu = jdbcTemplate.queryForObject(custSelect, new Object[] { id }, new customerMapper());
			return cu;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// method to check the customer with usermail and password for validation
	public custCredModel getCustomer(String email, String password) {
		password = passwordHashing.hashString(password);
		String custSelectQuery = "SELECT * FROM slam_customers WHERE cust_email = ? AND cust_password = ?";
		custCredModel cu = null;
		try {
			cu = jdbcTemplate.queryForObject(custSelectQuery, new Object[] { email, password }, new customerMapper());
			return cu;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// method to update the customer details
	public void updatecustomer(custCredModel customer) {
		String updateQuery = "UPDATE slam_customers SET cust_name = ?, cust_mobile = ?, cust_location = ?, cust_address = ?,cust_pincode = ?, cust_saddress = ?,cust_spincode = ?  WHERE cust_id = ?";

		jdbcTemplate.update(updateQuery, customer.getCustName(), customer.getCustMobile(), customer.getCustLocation(),
				customer.getCustAddress(), customer.getCustPincode(), customer.getCustSAddress(),
				customer.getCustSpincode(), customer.getCustId());
	}

	// method to update the user password
	public void updatePassword(String password, String email) {
		// performing hashing before saving in the database
		password = passwordHashing.hashString(password);
		String sql = "UPDATE slam_customers SET cust_password=? WHERE cust_email=?";

		jdbcTemplate.update(sql, password, email);
	}

	// method to check the email present in the database for signin and signup
	@Override
	public custCredModel getCustomerByEmail(String email) {
		String custSelect = "SELECT * FROM slam_customers WHERE cust_email=?";
		custCredModel cu = null;

		try {
			cu = jdbcTemplate.queryForObject(custSelect, new Object[] { email }, new customerMapper());
			return cu;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// method to update the shipment details when placing order
	@Override
	public String updateShpimentDetails(custCredModel ccm) {
		String update_shipment_details = "update slam_customers set cust_name=? , cust_saddress=? , cust_spincode=? where cust_id=?";
		int ur = jdbcTemplate.update(update_shipment_details, ccm.getCustName(), ccm.getCustSAddress(),
				ccm.getCustSpincode(), ccm.getCustId());
		if (ur > 0) {
			return "Updated";
		} else {
			return "Not updated";
		}

	}

	@Override
	// method to update the last login of the customer
	public void updatelastlogin(int cid) {
		String updateQuery = "UPDATE slam_customers SET cust_lastlogindate = CURRENT_TIMESTAMP WHERE cust_id = ?";
		jdbcTemplate.update(updateQuery, cid);
		// TODO Auto-generated method stub

	}

}
