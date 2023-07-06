package eStoreProduct.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eStoreProduct.DAO.admin.stockSummaryDAO;
import eStoreProduct.model.admin.output.stockSummaryModel;

@Controller
public class adminStockController {
	private stockSummaryDAO ssd;
	private static final Logger logger = LoggerFactory.getLogger(adminOrderController.class);
	/*
	 * private HSNCodeModel a; private productCategoryModel b; private productsModel c; private productStockModel d;
	 */

	@Autowired
	adminStockController(stockSummaryDAO stockdao) {
		ssd = stockdao;
		/*
		 * a = hsnm; b = pcm; c = pm; d = psm;
		 */
	}

	/*
	 * @GetMapping("/listStock") public String showStocks(Model model) { System.out.println("enter stock controller");
	 * List<stockSummaryModel> stocks = ssd.getStocks(); model.addAttribute("stocks", stocks); return "stockSummary"; }
	 */

	@GetMapping("/listStock")
	public String showStocks(Model model, @RequestParam(defaultValue = "0") int page) {
		logger.info("adminStockController url: listStock returns: stockSummary.jsp ");
		System.out.println("\n page:" + page);
		int pageSize = 5; // Number of records per page
		List<stockSummaryModel> stocks = ssd.getStocks(page, pageSize);
		int totalPages = (int) Math.ceil(ssd.getTotalStocks() / (double) pageSize); // Calculate total pages
		System.out.println("totalpages:\n" + totalPages);
		model.addAttribute("stocks", stocks);
		model.addAttribute("page", page);
		model.addAttribute("totalPages", totalPages); // Add totalPages to the model

		return "stockSummary";
	}

	@GetMapping("/listStocksForPagination")
	public String showStocksForPagination(Model model, @RequestParam(value = "nextPage") Integer page) {
		logger.info("adminStockController url: listStocksForPagination returns: stockSummary.jsp ");
		System.out.println("\n page:" + page);
		int pageSize = 5; // Number of records per page
		List<stockSummaryModel> stocks = ssd.getStocks(page, pageSize);
		int totalPages = (int) Math.ceil(ssd.getTotalStocks() / (double) pageSize); // Calculate total pages
		System.out.println("totalpages:\n" + totalPages);
		model.addAttribute("stocks", stocks);
		model.addAttribute("page", page);
		model.addAttribute("totalPages", totalPages); // Add totalPages to the model

		return "stockSummary";
	}

}
