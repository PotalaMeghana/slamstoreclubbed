package eStoreProduct.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eStoreProduct.DAO.admin.CategoryReportDAO;
import eStoreProduct.DAO.admin.OrderRepDAO;
import eStoreProduct.DAO.admin.orderProductDAO;
import eStoreProduct.DAO.common.OrderDAO;
import eStoreProduct.model.admin.entities.SlamOrderModel;
import eStoreProduct.model.admin.entities.orderModel;
import eStoreProduct.model.admin.output.CategoryReportViewModel;
import eStoreProduct.model.admin.output.orderProductsModel;

@Controller

public class adminReportController {

	private OrderRepDAO odao;
	private CategoryReportDAO crd;
	OrderDAO od;
	orderProductDAO op;
	private static final Logger logger = LoggerFactory.getLogger(adminReportController.class);

	@Autowired
	public adminReportController(OrderRepDAO odao, CategoryReportDAO crd, OrderDAO od, orderProductDAO op) {
		this.odao = odao;
		this.crd = crd;
		this.od = od;
		this.op = op;

	}
	
	@GetMapping("/generateGSTReport")
	public String generateGSTReport(Model model) {
		logger.info("adminReportController  url: generateGSTReport  returns: GSTReports.jsp ");
		logger.info("generating the gst report");
		
		List<orderModel> om = od.getAllOrders();
		List<SlamOrderModel> som = new ArrayList<>();
		for (orderModel dh : om) {
			op.getOrderWiseOrderProducts(dh.getId().intValue());
		}
		List<orderModel> orders = od.getAllOrders();
		model.addAttribute("orders", orders);
		// model.addAttribute("orderReport", som);
		return "GSTReports";
	}

	@GetMapping("/categoryReport")
	public String categoryReport(Model model) {
		logger.info("adminReportController  url: categoryReport  returns: catReports.jsp ");
		logger.info("getting the category wise report");
		// List<orderModel> om=odao.getAllOrders();
		List<CategoryReportViewModel> cl = crd.getCatRep();
		model.addAttribute("categoryReport", cl);
		return "catReports";
	}

	@GetMapping("/displayProcessedOrderProducts")
	public String showProcessedOrderProducts(@RequestParam(value = "orderId") int o_id, Model model) {
		
		logger.info("adminReportController  url: displayProcessedOrderProducts  returns: orderProductsTable.jsp ");
		logger.info("diaplaying processedOrders");
		System.out.println("show OrderProducts");
		List<orderProductsModel> orderproducts = op.getOrderWiseOrderProducts(o_id);
		model.addAttribute("orderproducts", orderproducts);
		return "orderProductsTable";
	}

	/*
	 * @GetMapping("/categoryReportSort") public String categoryReportSort(Model model) { //List<orderModel>
	 * om=odao.getAllOrders(); List<CategoryReportViewModel> cl= model.addAttribute("categoryReport", cl); return
	 * "catReports"; }
	 */
}
