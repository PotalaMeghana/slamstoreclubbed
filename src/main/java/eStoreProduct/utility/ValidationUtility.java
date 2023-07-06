/*
 * package eStoreProduct.utility; import org.springframework.beans.factory.annotation.Autowired;
 * 
 * //import eStoreProduct.DAO.cust import eStoreProduct.DAO.customerDAO; import eStoreProduct.model.custCredModel;
 * public class ValidationUtility {
 * 
 * private customerDAO custDAO; // Inject your DAO implementation here
 * 
 * @Autowired public ValidationUtility(customerDAO custDAO) { this.custDAO = custDAO; }
 * 
 * public custCredModel validateCustomer(String email, String psd) { // Retrieve the customer from the database using
 * the DAO custCredModel cust = custDAO.getCustomer(email, psd);
 * 
 * // Perform your validation logic based on the retrieved customer return cust; } }
 */