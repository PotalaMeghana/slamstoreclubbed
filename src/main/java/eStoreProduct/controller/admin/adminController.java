package eStoreProduct.controller.admin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eStoreProduct.DAO.admin.adminDAO;
import eStoreProduct.model.admin.entities.adminModel;
import eStoreProduct.model.admin.input.adminLogin;
import eStoreProduct.utility.dashboardUtilityClass;

@Controller
public class adminController {
	adminDAO adao;
	dashboardUtilityClass du;
	private static final Logger logger = LoggerFactory.getLogger(adminController.class);

	@Autowired
	public adminController(adminDAO adminDAO, dashboardUtilityClass du) {
		adao = adminDAO;
		this.du = du;

	}

	//to get login page 
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String getAdminLogin(Model model) {
		logger.info("adminController: adminLogin : adminSignIn.jsp ");
		logger.info("to get login page ");
		System.out.println("Admin Page");

		// call the view
		return "adminSignIn";
	}

	//based on the credentials user entered checking against the db if valid enter into the site or in the same page
	@RequestMapping(value = "/adminSignOk", method = RequestMethod.POST)
	public String getHomeFinal(@Validated adminLogin al, Model model, HttpSession session) {

		System.out.println("checking admin sign in");

		adminModel ad = adao.getAdmin(al.getEmail(), al.getPassword());
		logger.info("adminController: adminSignOk : admin.jsp ");
		System.out.println("checking sign in 1");
		if (ad != null) {
			logger.info("valid admin ");
			session.setAttribute("admin", ad); // Store admin object
			session.setAttribute("dash", du);
			System.out.println(ad.getTitle());
			model.addAttribute("admin", ad);
			System.out.println(ad.getTitle());

		} else {
			logger.info("invalid admin credentials");
			return "adminSignIn";
		}

		return "admin";
	}

}