package eStoreProduct.model.customer.input;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;


public class custCredModel {

	private int custId;
	private String custName;
	private String custMobile;
	private Timestamp custRegDate = Timestamp.from(Instant.now());
	private String custLocation;
	private String custEmail;
	private String custAddress;
	private String custSAddress;
	private String custPincode;
	private String custStatus = "A";
	private Timestamp custLastLoginDate = Timestamp.from(Instant.now());
	private String custPassword;
	private String custSpincode;

	public custCredModel() {

	}

	public custCredModel(String custName, String custMobile, String custLocation, String custEmail, String custAddress,String custPincode,
			String custSAddress,String custSpincode , Timestamp custLastLoginDate, String custPassword) {
		this.custName = custName;
		this.custMobile = custMobile;
		this.custRegDate = Timestamp.from(Instant.now());
		this.custLocation = custLocation;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custSAddress = custSAddress;
		this.custPincode = custPincode;
		this.custStatus = "A";
		this.custLastLoginDate = custLastLoginDate;
		this.custPassword = custPassword;
		this.custSpincode=custSpincode;
	}

	// Getters and Setters

	public String getCustSpincode() {
		return custSpincode;
	}

	public void setCustSpincode(String custSpincode) {
		System.out.println("spincode   "+custSpincode);
		this.custSpincode = custSpincode;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		System.out.println("id   "+custId);
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobile() {

		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Timestamp getCustRegDate() {
		return custRegDate;
	}

	public void setCustRegDate(Timestamp custRegDate) {
		this.custRegDate = custRegDate;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustSAddress() {
		return custSAddress;
	}

	public void setCustSAddress(String custSAddress) {
		this.custSAddress = custSAddress;
	}

	public String getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Timestamp getCustLastLoginDate() {
		return custLastLoginDate;
	}

	public void setCustLastLoginDate(Timestamp custLastLoginDate) {
		this.custLastLoginDate = custLastLoginDate;
	}

	public String getCustPassword() {
		// this.custPassword = passwordHashing.hashString(custPassword);

		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = passwordHashing.hashString(custPassword);
	}

	public String toString() {
		return "Employee{" + "Cust Name=" + custName + '}';
	}

}
