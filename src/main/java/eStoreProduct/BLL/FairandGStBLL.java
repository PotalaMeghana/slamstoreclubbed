
package eStoreProduct.BLL;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.customer.cartDAO;
import eStoreProduct.model.admin.entities.HSNCodeModel;
//import eStoreProduct.model.customer.input.HSNCodeModel;
import eStoreProduct.model.customer.input.ServiceableRegion;
import eStoreProduct.model.customer.input.custCredModel;
import eStoreProduct.DAO.customer.ProductDAO1;
import eStoreProduct.utility.ProductStockPriceForCust;

@Component
public class FairandGStBLL {
	ProductDAO1 pdaoimp;
	cartDAO cartimp;
	List<ProductStockPriceForCust> products = null;
	List<ProductStockPriceForCust> product2 = null;
	private static final Logger logger = LoggerFactory.getLogger(FairandGStBLL.class);

	@Autowired
	public FairandGStBLL(ProductDAO1 productdao, cartDAO ca) {
		pdaoimp = productdao;
		cartimp = ca;
	}

	// method to get  cart products total cost
	public double getCartCost(int id) {
logger.info("eStoreProduct:FairandGStBLL::getting cart products total cost");
		double cartcost = 0.0;
		List<ProductStockPriceForCust> cproducts = cartimp.getCartProds(id);
		for (ProductStockPriceForCust p : cproducts) {
			cartcost += p.getPrice() * p.getQuantity();
		}
		return cartcost;
	}

	// method returns the totalcost of cart products
	public double getCartCost(List<ProductStockPriceForCust> al) {
	logger.info("eStoreProduct:FairandGStBLL::returns the totalcost of cart products");
		double cost = 0.0;
		for (ProductStockPriceForCust p : al) {
			cost += p.getPrice() * p.getQuantity();
		}
		return cost;
	}

	public double getOrderGST(List<ProductStockPriceForCust> al) {
	logger.info("eStoreProduct:FairandGStBLL::returns getOrderGST");
		double gst = 0.0;
		for (ProductStockPriceForCust ps : al) {
			gst += (ps.getGst() * ps.getPrice()) / 100;
		}
		return gst;
	}

	// method to calculate the total fair for single buying product
	public ProductStockPriceForCust individualTotalfair(custCredModel cust, int pid, int qty) {
               	logger.info("eStoreProduct:FairandGStBLL::calculation for gsts");
		String spin = cust.getCustSpincode();
		int spincode = Integer.parseInt(spin);
		// retrieve the ServiceableRegion for surcharge and pricewaiver
		ServiceableRegion rgn = cartimp.getRegionByPincode(spincode);
		ProductStockPriceForCust p = pdaoimp.getProductById(pid);

		int prod_gstc_id = pdaoimp.getproductgstcid(pid);
		p.setProd_gstc_id(prod_gstc_id);

		p.setQuantity(qty);
		// calculate the gsts percentage and add the gsts percentage amount to respective product object
		setgsts(p, spin);
		double price = p.getPrice();
		p.setQtyprice(price * qty);
		double totalprice = p.getQtyprice();

		List<ProductStockPriceForCust> prds = new ArrayList<>();
		prds.add(p);
		calculatesurcharge(prds, totalprice, rgn);
		return p;

	}

	// method to calculate and set GSTS for each product
	public void setgsts(ProductStockPriceForCust p, String spin) {
	    logger.info("eStoreProduct:FairandGStBLL::calculate the gst,cgst,igst,sgst and set to respective product object");
		double salecost = p.getPrice();
		System.out.println("In bll=gstc_id=" + p.getProd_gstc_id());
		// retrieve the gst,sgst,cgst,igst percentages based on product hsn code
		HSNCodeModel hsn = cartimp.getHSNCodeByProductId(p.getProd_gstc_id());
		double sgstrate = hsn.getSgst();
		double igstrate = hsn.getIgst();
		double cgstrate = hsn.getCgst();
		double gstrate = hsn.getGst();
		double n1 = salecost * (100 / (100 + gstrate));
		double gstamount = salecost - n1;
		double orgcost = salecost - gstamount;
		System.out.println("original cost" + orgcost);

		// if Shipment pincode is not starts with 53 the pincode is in other states
		// so we just calculate the igst
		if (!spin.startsWith("53")) {
			System.out.println("In Other States");

			double igstamt = (igstrate / 100) * orgcost;

			double gst = igstamt;
			p.setGst(gst);
			System.out.println("gst: " + p.getGst());
			p.setIgst(igstamt);
			System.out.println("gst: " + p.getIgst());
		}
		// else the pincode is in AP so,we just calculate the cgst,sgst
		else {
			System.out.println("our AP");
			double cgstamt = (cgstrate / 100) * orgcost;
			double sgstamt = (sgstrate / 100) * orgcost;
			double gst = cgstamt + sgstamt;
			p.setCgst(cgstamt);
			p.setSgst(sgstamt);
			p.setGst(gst);

		}

	}

	// method to calculate the TotalFair of buying products
	public void calculateTotalfair(custCredModel cust) {
	logger.info("eStoreProduct:FairandGStBLL::calculation for totalfair of buying products");
		double pr = 0.0;
		product2 = cartimp.getCartProds(cust.getCustId());
		String spin = cust.getCustSpincode();
		int spincode = Integer.parseInt(spin);
		// retrieve the ServiceableRegion surcharge and pricewaiver
		ServiceableRegion rgn = cartimp.getRegionByPincode(spincode);

		for (ProductStockPriceForCust p : product2) {
			double cost = p.getPrice();
			setgsts(p, spin);

			int qty = p.getQuantity();
			cost = cost * qty;
			p.setQtyprice(cost);
			System.out.println("totalqtyprice++=" + p.getQtyprice());
			pr = pr + cost;

		}
		calculatesurcharge(product2, pr, rgn);

	}

	// method to calculate the surcharge of each product
	public void calculatesurcharge(List<ProductStockPriceForCust> products, double totalprice, ServiceableRegion rgn) {
	logger.info("eStoreProduct:FairandGStBLL::calculating the surcharge and shipping charges");
		double shipcharge = 0.0, wholeshipmentprice = 0.0, shipgst = 0.0;
		// to find the total shipment charge
		if (totalprice >= 0 && totalprice <= 1000) {
			shipcharge = 65;
		}
		double surcharge = rgn.getSrrgPriceSurcharge();

		double pricewaiver = rgn.getSrrgPriceWaiver();
		wholeshipmentprice = (shipcharge + surcharge) - pricewaiver;

		for (ProductStockPriceForCust p : products) {
			// retrieve the gst,sgst,cgst,igst percentages based on product hsn code
			HSNCodeModel hsn = cartimp.getHSNCodeByProductId(p.getProd_gstc_id());
			// calculation for find the total shipment amount and find the shipment gst for each product
			double prprice = p.getQtyprice();
			double prpercentage = (prprice / totalprice) * 100;
			double scharge = (prpercentage * wholeshipmentprice) / 100;
			double prdshipgst = ((hsn.getGst() / 100) * scharge);
			scharge = scharge + prdshipgst;
			shipgst += prdshipgst;
			System.out.println("each product shipment with gst");
			System.out.println(scharge);

			p.setShipcharge(scharge);

		}
		ProductStockPriceForCust.setTotal(wholeshipmentprice + totalprice + shipgst);

	}

	// method to return the products list that list contains the total gsts & surcharge calculation
	public List<ProductStockPriceForCust> GetQtyItems2() {
	logger.info("eStoreProduct:FairandGStBLL::return the products list which was contains the calculated gsts and surcharges");
		return product2;
	}
}
