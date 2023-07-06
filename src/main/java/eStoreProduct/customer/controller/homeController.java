package eStoreProduct.customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eStoreProduct.DAO.customer.cartDAO;
import eStoreProduct.DAO.customer.customerDAO1;
import eStoreProduct.model.customer.input.custCredModel;

@Controller
public class homeController {
	static boolean flag = false;
	customerDAO1 cdao;
	cartDAO cd;
	private static final Logger logger = LoggerFactory.getLogger(homeController.class);

	// dependency injection
	@Autowired
	public homeController(customerDAO1 customerdao, cartDAO cd) {
		cdao = customerdao;
		this.cd = cd;

	}

	// url mapping for home page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model model) {
	logger.info("eStoreProduct:homeController:calling the home view page");
		// call the view
		return "home";
	}

	// url mapping for logged in user to get back to home
	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	public String getHomeFoeLoggedUser(Model model) {
	logger.info("eStoreProduct:homeController:after sign in getting the home view page");
		// setting flag variable to maintain status and add to model
		flag = true;
		model.addAttribute("fl", flag);
		// call the view
		return "home";
	}

	// url mapping to open signup page for new customer
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String getSignUpPage(Model model) {
		logger.info("eStoreProduct:homeController:calling the signup view page");
		// call the view
		return "signUp";
	}

	// url mapping to open signin page
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String getSignInPage(Model model) {
	logger.info("eStoreProduct:homeController:calling the signin view page");
		// call the view
		return "signIn";
	}

	// url mapping when customer completed the signup form
	@RequestMapping(value = "/signInCreateAccount", method = RequestMethod.POST)
	public String createAccount(@Validated custCredModel ccm, Model model) {
	logger.info("eStoreProduct:homeController:Adding the new Customer to data base");
		// add customer to database
		boolean b = cdao.createCustomer(ccm);
		// set it to the model
		if (b) {
			model.addAttribute("customer", ccm);
		}
		// call the view
		return "createdMsg";
	}

	// url mapping to redirect to home page by changing login status
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userlogout(Model model, HttpSession session) {
		logger.info("eStoreProduct:homeController:user logout");
		// get the logged in session customer
		// change the login status and add to model
		flag = false;
		model.addAttribute("fl", flag);
		if (model.containsAttribute("customer"))
			model.addAttribute("customer", null);
		session.invalidate();
		// call view
		return "home";
	}

}
