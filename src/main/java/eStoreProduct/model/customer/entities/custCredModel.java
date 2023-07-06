package eStoreProduct.model.customer.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import eStoreProduct.model.customer.input.customerInputModel;
import eStoreProduct.model.customer.output.customerOutputModel;

@Entity
@Table(name = "slam_customers")
public class custCredModel {
	@Id
	@Column(name = "cust_id")
	private int custId;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private cartModel cart;

	// ...

	public cartModel getCart() {
		return cart;
	}

	public void setCart(cartModel cart) {
		this.cart = cart;
	}
	// @OneToOne(fetch = FetchType.LAZY)

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<WishlistModel> wishlistItems = new ArrayList<>();

	public List<WishlistModel> getWishlistItems() {
		return wishlistItems;
	}

	public void setWishlistItems(List<WishlistModel> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_mobile")
	private String custMobile;

	@Column(name = "cust_regdate")
	private Timestamp custRegDate = Timestamp.from(Instant.now());

	@Column(name = "cust_location")
	private String custLocation;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "cust_address")
	private String custAddress;

	@Column(name = "cust_pincode")
	private int custPincode;

	@Column(name = "cust_saddress")
	private String custSAddress;

	@Column(name = "cust_spincode")
	private int custSpincode;

	@Column(name = "cust_status")
	private String custStatus = "A";

	@Column(name = "cust_lastlogindate")
	private Timestamp custLastLoginDate = Timestamp.from(Instant.now());

	@Column(name = "cust_password")
	private String custPassword;

	public custCredModel() {

	}

	public custCredModel(customerInputModel cim) {
		this.custName = cim.getCustName();
		this.custMobile = cim.getCustMobile();
		this.custRegDate = Timestamp.from(Instant.now());
		this.custLocation = cim.getCustLocation();
		this.custEmail = cim.getCustEmail();
		this.custAddress = cim.getCustAddress();
		this.custSAddress = cim.getCustSAddress();
		this.custPincode = cim.getCustPincode();
		this.custStatus = "A";
		this.custLastLoginDate = cim.getCustLastLoginDate();
		this.custPassword = cim.getCustPassword();
		this.custSpincode = cim.getCustSpincode();
	}

	public custCredModel(String custName, String custMobile, String custLocation, String custEmail, String custAddress,
			int custPincode, String custSAddress, int custSpincode, Timestamp custLastLoginDate, String custPassword) {
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
		this.custSpincode = custSpincode;
	}

	// Getters and Setters

	public int getCustSpincode() {
		return custSpincode;
	}

	public void setCustSpincode(int custSpincode) {
		System.out.println("spincode   " + custSpincode);
		this.custSpincode = custSpincode;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		System.out.println("id   " + custId);
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

	public int getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(int custPincode) {
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
		this.custPassword = custPassword;
	}

	public custCredModel(int custId, cartModel cart, List<WishlistModel> wishlistItems, String custName,
			String custMobile, Timestamp custRegDate, String custLocation, String custEmail, String custAddress,
			int custPincode, String custSAddress, int custSpincode, String custStatus, Timestamp custLastLoginDate,
			String custPassword) {
		super();
		this.custId = custId;
		this.cart = cart;
		this.wishlistItems = wishlistItems;
		this.custName = custName;
		this.custMobile = custMobile;
		this.custRegDate = custRegDate;
		this.custLocation = custLocation;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custPincode = custPincode;
		this.custSAddress = custSAddress;
		this.custSpincode = custSpincode;
		this.custStatus = custStatus;
		this.custLastLoginDate = custLastLoginDate;
		this.custPassword = custPassword;
	}

	public custCredModel(customerOutputModel cim) {
		// TODO Auto-generated constructor stub
		this.custName = cim.getCustName();
		this.custMobile = cim.getCustMobile();
		this.custRegDate = Timestamp.from(Instant.now());
		this.custLocation = cim.getCustLocation();
		this.custEmail = cim.getCustEmail();
		this.custAddress = cim.getCustAddress();
		this.custSAddress = cim.getCustSAddress();
		this.custPincode = cim.getCustPincode();
		this.custStatus = "A";
		this.custLastLoginDate = cim.getCustLastLoginDate();
		this.custPassword = cim.getCustPassword();
		this.custSpincode = cim.getCustSpincode();
	}

	public String toString() {
		return "Employee{" + "Cust Name=" + custName + '}';
	}

}