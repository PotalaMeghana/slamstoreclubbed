package eStoreProduct.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.admin.customerDAO;
import eStoreProduct.DAO.common.OrderDAO;
import eStoreProduct.DAO.common.ProductDAO;


@Component
public class dashboardUtilityClass {
	private int noOfOrders;
	private int noOfProducts;
	private int noOfCustomers;
	OrderDAO od;
	customerDAO cd;
	ProductDAO pd;

	@Autowired
	public dashboardUtilityClass(OrderDAO orderdao, customerDAO cd, ProductDAO pd) {
		this.od = orderdao;
		this.cd = cd;
		this.pd = pd;
		initializeNoOfOrders();
		initializeNoOfCustomers();
		initializeNoOfProducts();
	}

	public void initializeNoOfOrders() {
		this.noOfOrders = od.getNoOfOrders();
	}

	public void initializeNoOfCustomers() {
		this.noOfCustomers = cd.getNoOfCustomers();
	}

	public void initializeNoOfProducts() {
		this.noOfProducts = pd.getNoOfProducts();
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public int getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(int noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
	}

	public OrderDAO getOd() {
		return od;
	}

	public void setOd(OrderDAO od) {
		this.od = od;
	}

}