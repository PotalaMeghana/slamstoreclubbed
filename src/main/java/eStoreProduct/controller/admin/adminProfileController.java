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

@Controller
public class adminProfileController {
	adminDAO adao;
	private static final Logger logger = LoggerFactory.getLogger(adminProfileController.class);

	@Autowired
	public adminProfileController(adminDAO admindao) {
		adao = admindao;

	}

	//getting the adminProfile page to edit
	@RequestMapping(value = "/displayAdminProfile", method = RequestMethod.GET)
	public String getAdminLogin(Model model, HttpSession session) {
		logger.info("adminProfileController  url: displayAdminProfile  returns: adminProfile.jsp ");

		System.out.println("Admin Profile Page");
		adminModel am = (adminModel) session.getAttribute("admin");
		model.addAttribute("am", am);
		// call the view
		return "adminProfile";
	}

	//on clicking edit button allowing admin to edit his details
	@RequestMapping(value = "/editAdminProfile", method = RequestMethod.GET)
	public String editAdminDetails(Model model) {
		System.out.println("editable Admin Profile Page");
		logger.info("adminProfileController  url: editAdminProfile  returns: editableAdminProfile.jsp ");

		// call the view
		return "editableAdminProfile";
	}

	//on clicking update his details are updated
	@RequestMapping(value = "/updateAdminDetails", method = RequestMethod.GET)
	public String updateAdminDetails(@Validated adminLogin al, Model model) {
		logger.info("adminProfileController  url: updateAdminDetails  returns: adminProfile.jsp ");

		System.out.println("updating Admin Profile Page");
		adminModel am = adao.getAdmin(al.getEmail(), al.getPassword());
		adao.updateAdmin(am);
		// call the view
		return "adminProfile";
	}

}