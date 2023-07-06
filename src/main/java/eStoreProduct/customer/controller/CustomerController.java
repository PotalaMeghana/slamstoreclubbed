package eStoreProduct.customer.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eStoreProduct.BLL.FairandGStBLL;
import eStoreProduct.BLL.OrderIdCreationBLL;
import eStoreProduct.BLL.WalletCalculationBLL;
import eStoreProduct.DAO.customer.OrderDAO1;
import eStoreProduct.DAO.customer.ProductDAO1;
import eStoreProduct.DAO.customer.StockUpdaterDAO;
import eStoreProduct.DAO.customer.cartDAO;
import eStoreProduct.DAO.customer.customerDAO1;
import eStoreProduct.DAO.customer.walletDAO;
import eStoreProduct.Exceptions.QuantityExceedsStockException;
import eStoreProduct.externalServices.InvoiceMailSending;
import eStoreProduct.model.admin.entities.orderModel;
import eStoreProduct.model.customer.input.custCredModel;
import eStoreProduct.model.customer.input.wallet;
import eStoreProduct.utility.ProductStockPriceForCust;

@Controller
public class CustomerController {
	customerDAO1 cdao;
	cartDAO cartimp;
	FairandGStBLL BLL;
	OrderIdCreationBLL bl2;
	String buytype = null;
	ProductDAO1 pdaoimp;
	OrderDAO1 odao;
	walletDAO wdao;
	StockUpdaterDAO stckdao;
	List<ProductStockPriceForCust> products = null;
	List<ProductStockPriceForCust> product2 = new ArrayList<ProductStockPriceForCust>();
	orderModel om;
	InvoiceMailSending invoiceMail;
	WalletCalculationBLL obj;
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	public CustomerController(cartDAO cartdao, customerDAO1 customerdao, StockUpdaterDAO stckdao, orderModel om,
			OrderIdCreationBLL bl2, FairandGStBLL bl1, ProductDAO1 productdao, OrderDAO1 odao, walletDAO w,
			WalletCalculationBLL ob, InvoiceMailSending invoiceMail) {
		cdao = customerdao;
		cartimp = cartdao;
		this.bl2 = bl2;
		this.BLL = bl1;
		pdaoimp = productdao;
		this.odao = odao;
		wdao = w;
		this.om = om;
		this.stckdao = stckdao;
		obj = ob;
		this.invoiceMail = invoiceMail;
	}

	// called when user clicks on profile
	@RequestMapping(value = "/profilePage")
	public String sendProfilePage(Model model, HttpSession session) {
		logger.info("estoreproduct:customer controller::profile page");

		// Retrieve customer information from the session
		custCredModel cust = (custCredModel) session.getAttribute("customer");

		// Add customer information to the model
		model.addAttribute("cust", cust);
		return "profile";
	}

	// called when user tries to update the profile data
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String userupdate(@ModelAttribute("Customer") custCredModel cust, Model model, HttpSession session) {
		// Update the customer information in the database
		cdao.updatecustomer(cust);
		logger.info("estoreproduct:customer controller::update the customer profile");

		// Retrieve the updated customer information
		custCredModel custt = cdao.getCustomerById(cust.getCustId());
		if (custt != null) {
			// Add the updated customer information to the model
			model.addAttribute("cust", custt);
		}
		return "profile";
	}

	// for payment fair in the cart
	@GetMapping("/buycartitems")
	public String confirmbuycart(Model model, HttpSession session) {
		logger.info("estoreproduct:customer controller::customer buying the cart items");

		// Retrieve customer information from the session
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		if (cust1 != null) {
			// Calculate the total fair for cart items
			BLL.calculateTotalfair(cust1);

			// Get the quantity and price information of the cart items
			products = BLL.GetQtyItems2();

			// Add the products and buy type information to the model
			model.addAttribute("products", products);
			buytype = "cartproducts";

			// Get the wallet amount of the customer
			wallet Wallet = wdao.getWalletAmount(cust1.getCustId());
			model.addAttribute("Wallet", Wallet);

			return "paymentpreview";
		} else {
			return "signIn";
		}
	}

	@GetMapping("/getOrderId")
	@ResponseBody
	public String getOrderId(@RequestParam(value = "amt") double amt, HttpSession session) {
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		if (cust1 != null) {
			List<ProductStockPriceForCust> products = cartimp.getCartProds(cust1.getCustId());
			for (ProductStockPriceForCust p : products) {
				try {
					stckdao.updateQtyBeforeCheckOut(p.getProd_id(), p.getQuantity());
				} catch (QuantityExceedsStockException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
					return "Error";
				}

			}
		}
		double amountInPaisa = amt;

		// Create a Razorpay order and retrieve the order ID
		String orderId = bl2.createRazorpayOrder(amountInPaisa);
		return orderId;
	}

	@GetMapping("/cancelPayment")
	@ResponseBody
	public String cancelPayment(HttpSession session) {
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		if (cust1 != null) {
			List<ProductStockPriceForCust> products = cartimp.getCartProds(cust1.getCustId());
			for (ProductStockPriceForCust p : products) {
				try {
					stckdao.updateQtyAfterPayFail(p.getProd_id(), p.getQuantity());
				} catch (Exception e) {
					return "failed to update";
				}

			}
		}

		return "updated succesfully";
	}

	// updating the customers's shipping address
	@PostMapping("/updateshipment")
	@ResponseBody
	public String handleFormSubmission(@RequestParam(value = "name") String name,
			@RequestParam(value = "custSAddress") String caddress, @RequestParam(value = "custSpincode") String pincode,
			HttpSession session) {
		logger.info("estoreproduct:customer controller::update the customers's shipping address ");
		custCredModel cust = (custCredModel) session.getAttribute("customer");
		// checks whether the pincode is valid or not
		boolean isValid = pdaoimp.isPincodeValid(Integer.parseInt(pincode));
		// if valid case
		if (isValid) {
			cust.setCustName(name);
			cust.setCustSAddress(caddress);
			cust.setCustSpincode(pincode);
			// shipment details get updated
			String update_status = cdao.updateShpimentDetails(cust);
			// if the shipment details updated
			if (update_status.equals("Updated"))
				return "Valid";
			else
				return "Not Valid";
		}
		return "Not Valid";
	}

	// method for showing invoice
	@PostMapping(value = "/invoice")
	public String invoice(@RequestParam("paymentReference") String id, @RequestParam("total") String total, Model model,
			HttpSession session, @Validated orderModel om, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("estoreproduct:customer controller::after payment completed showing invoice ");
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		// gets wallet amount of user
		wallet Wallet = wdao.getWalletAmount(cust1.getCustId());
		double payamount = Double.parseDouble(total);
		// total payable amount
		double totalamount = ProductStockPriceForCust.getTotal();
		// amount used from wallet
		double walletusedamount = totalamount - payamount;
		if (walletusedamount > 0) {
			double x = Wallet.getAmount() - walletusedamount;
			// updating remaining wallet amount
			wdao.updatewallet(x, cust1.getCustId());
		}

		if (buytype.equals("cartproducts")) {
			products = BLL.GetQtyItems2();
		} else {
			products = product2;
		}
		// getting orders gst
		om.setGst(BLL.getOrderGST(products));
		model.addAttribute("payment_id", om.getPaymentReference());
		odao.insertIntoOrders(om, products);
		for (ProductStockPriceForCust p : products) {
			System.out.print("product stock" + p.getProduct_stock());
			int updatestock = p.getProduct_stock() - p.getQuantity();
			stckdao.updateStocks(p.getProd_id(), updatestock);
		}
		// adding requried attributes to the model
		model.addAttribute("customer", cust1);
		model.addAttribute("payid", id);
		model.addAttribute("products", products);
		invoiceMail.sendEmail(request, response, om, cust1.getCustEmail());
		model.addAttribute("invoicecustomer", cust1);
		model.addAttribute("payid", id);
		session.setAttribute("products", products);
		session.setAttribute("customer", cust1);
		return "invoice";
	}

	// buying an individual product directly without cart
	@GetMapping("/buythisproduct")
	public String buythisproduct(@RequestParam(value = "productId", required = true) int productId,
			@RequestParam(value = "qty", required = true) int qty, Model model, HttpSession session)
			throws NumberFormatException, SQLException {
		logger.info("estoreproduct:customer controller::customer want to buy the individual product");

		product2.clear();
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		// calculating the fare
		ProductStockPriceForCust product = BLL.individualTotalfair(cust1, productId, qty);
		product2.add(product);

		buytype = "individual";
		// adding wallet amount
		logger.info("estoreproduct:customer controller::getting wallet amount and add as model attribute ");
		wallet Wallet = wdao.getWalletAmount(cust1.getCustId());
		model.addAttribute("Wallet", Wallet);

		model.addAttribute("products", product2);

		return "paymentpreview";
	}

	// verify whether person logged in or not before proceeding to buy
	@GetMapping("/checkloginornot")
	@ResponseBody
	public String buyproduct(Model model, HttpSession session) throws NumberFormatException, SQLException {
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		logger.info("estoreproduct:customer controller::checking customer is login or not ");

		if (cust1 != null) {
			return "true";
		} else {
			return "false";
		}
	}

	// method for checking wallet amount
	@GetMapping("/wallet")
	@ResponseBody
	public String wallet(@RequestParam(value = "wallet", required = true) double walletamt,
			@RequestParam(value = "orderamt", required = true) double ordamt, Model model, HttpSession session)
			throws NumberFormatException, SQLException {
		logger.info("estoreproduct:customer controller::user selected the wallet option");
		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		// method to get the customer actual wallet amount
		wallet Wallet = wdao.getWalletAmount(cust1.getCustId());
		// if user wallet amount is zero it throws an Exception

		double remain = obj.WalletCalc(Wallet, ordamt);
		return remain + "";

	}

}
