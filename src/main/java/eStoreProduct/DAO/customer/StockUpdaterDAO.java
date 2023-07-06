package eStoreProduct.DAO.customer;

import eStoreProduct.Exceptions.QuantityExceedsStockException;

public interface StockUpdaterDAO {
	void updateStocks(int prod_id, int qty);

	public int getProductStock(int productId);

	public void updateQtyBeforeCheckOut(int prod_id, int qty) throws QuantityExceedsStockException;

	public void updateQtyAfterPayFail(int prod_id, int qty);
}
