package eStoreProduct.DAO.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import eStoreProduct.Exceptions.QuantityExceedsStockException;

@Component
public class StockUpdaterDAOImp implements StockUpdaterDAO {
	private final DataSourceTransactionManager transactionManager;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public StockUpdaterDAOImp(DataSourceTransactionManager transactionManager, JdbcTemplate jdbcTemplate) {
		this.transactionManager = transactionManager;
		this.jdbcTemplate = jdbcTemplate;
	}

	// @Override
	public int getProductStock(int productId) {
		return jdbcTemplate.queryForObject("select prod_stock from slam_productstock where  prod_id=?",
				new Object[] { productId }, Integer.class);
	}

	// @Override
	public void updateStocks(int prod_id, int qty) {
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		System.out.println("   qty " + qty);

		try {

			int stock = getProductStock(prod_id) - qty;
			String update_stock = "update slam_productStock set prod_stock=? where prod_id=? ";
			jdbcTemplate.update(update_stock, stock, prod_id);
			/*
			 * String sql = "SELECT * FROM slam_productstock FOR UPDATE"; jdbcTemplate.query(sql, rs -> { String
			 * updateSql = "UPDATE slam_productstock SET prod_stock = prod_stock - ? WHERE prod_id = ?";
			 * jdbcTemplate.update(updateSql, qty, prod_id); });
			 */

			// Perform any additional update operations here

			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			// Handle the exception
		}
	}

	@Override
	public void updateQtyBeforeCheckOut(int prod_id, int qty) throws QuantityExceedsStockException {

		if (getProductStock(prod_id) >= qty) {
			String updateSt = "update slam_productstock set prod_stock = prod_stock - ? WHERE prod_id = ?";
			jdbcTemplate.update(updateSt, qty, prod_id);

		} else
			throw new QuantityExceedsStockException("Quantity exceeds product stock");

	}

	@Override
	public void updateQtyAfterPayFail(int prod_id, int qty) {

		String updateSt = "update slam_productstock set prod_stock = prod_stock + ? WHERE prod_id = ?";
		jdbcTemplate.update(updateSt, qty, prod_id);

	}
}