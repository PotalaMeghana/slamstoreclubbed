package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.output.stockSummaryModel;

public interface stockSummaryDAO {
	/* public List<Object[]> fetchStockSummary(); */

	public List<stockSummaryModel> getStocks();

	/*
	 * public void updateStocks(int prodid, String imageurl, int gstcid, int reorderlevel, int updatedstock, double
	 * mrp);
	 */
	long getTotalStocks();

	int totalStocks(int count);

	List<stockSummaryModel> getStocks(int page, int pageSize);

	void updateStocks(int prodid, String imageurl, String desc, int reorderlevel, int stock, double mrp, double price);

	public void updatePrice(int id, double mrp, double price);
}