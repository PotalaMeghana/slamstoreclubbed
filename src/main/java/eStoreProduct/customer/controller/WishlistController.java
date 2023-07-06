package eStoreProduct.customer.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eStoreProduct.DAO.customer.WishlistDAO;
import eStoreProduct.model.customer.input.custCredModel;
import eStoreProduct.utility.ProductStockPriceForCust;

@Controller
public class WishlistController {
	private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

	WishlistDAO wishlistdao;

	@Autowired
	public WishlistController(WishlistDAO wishlistimp) {
		wishlistdao = wishlistimp;
	}

	// method to add product to wishlist
	@GetMapping("/addToWishlist")
	@ResponseBody
	public String addToWishlist(@RequestParam(value = "productId", required = true) int productId, Model model,
			HttpSession session) throws NumberFormatException, SQLException {
		logger.info("eStoreProduct:WishlistController::adding product to wishlist");

		custCredModel cust = (custCredModel) session.getAttribute("customer");
		wishlistdao.addToWishlist(productId, cust.getCustId());
		return "Item added to wishlist";
	}

	// method to remove product from wishlist
	@GetMapping("/removeFromWishlist")
	@ResponseBody
	public String removeFromWishlist(@RequestParam(value = "productId", required = true) int productId, Model model,
			HttpSession session) throws NumberFormatException, SQLException {
		logger.info("eStoreProduct:WishlistController::Removing  product from wishlist");

		custCredModel cust = (custCredModel) session.getAttribute("customer");
		wishlistdao.removeFromWishlist(productId, cust.getCustId());
		return "Item removed from wishlist";
	}

	// method to display the wishlist items
	@RequestMapping("/wishlistItems")
	public String userWishlistItems(Model model, HttpSession session) throws NumberFormatException, SQLException {
		logger.info("eStoreProduct:WishlistController::when user clicks on wishlist button Displaying the items from wishlist");

		custCredModel cust1 = (custCredModel) session.getAttribute("customer");
		List<ProductStockPriceForCust> products = wishlistdao.getWishlistProds(cust1.getCustId());

		model.addAttribute("products", products);

		return "wishlistCatalog";
	}

}
