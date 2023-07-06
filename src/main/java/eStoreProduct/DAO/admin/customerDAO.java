package eStoreProduct.DAO.admin;

import eStoreProduct.model.customer.entities.custCredModel;
import eStoreProduct.model.customer.input.customerInputModel;
import eStoreProduct.model.customer.output.customerOutputModel;

public interface customerDAO {
	boolean createCustomer(customerInputModel ccm);

	// custCredModel checkCustomer(String usr, String pswd);

	public void updatelastlogin(int cid);

	public void updatecustomer(customerInputModel cust);

	customerOutputModel getCustomerById(int custId);

	customerOutputModel getCustomer(String email, String psd);

	void updatePassword(String p2, String finalemail);

	customerOutputModel getCustomerByEmail(String email);

	void persist(custCredModel ccm);

	int getNoOfCustomers();

}