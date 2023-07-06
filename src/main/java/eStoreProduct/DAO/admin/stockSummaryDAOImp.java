package eStoreProduct.DAO.admin;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eStoreProduct.model.admin.entities.productStockModel;
import eStoreProduct.model.admin.entities.productsModel;
import eStoreProduct.model.admin.output.stockSummaryModel;

@Component
public class stockSummaryDAOImp implements stockSummaryDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = LoggerFactory.getLogger(stockSummaryDAOImp.class);

	@Override
	@Transactional
	public List<stockSummaryModel> getStocks() {
		logger.info("getting the total stocks from stockSummaryModel");
		String query = "SELECT NEW eStoreProduct.model.admin.output.stockSummaryModel("
				+ "p.id, p.title, p.productCategory, p.hsnCode, p.brand, p.imageUrl, p.description, p.reorderLevel, pc.prct_title, "
				+ "hsn.sgst, hsn.igst, hsn.cgst, hsn.gst, ps.price, ps.stock, ps.mrp) "
				+ "FROM eStoreProduct.model.admin.entities.productsModel p, eStoreProduct.model.admin.entities.productCategoryModel pc, eStoreProduct.model.admin.entities.HSNCodeModel hsn, eStoreProduct.model.admin.entities.productStockModel ps "
				+ "WHERE p.id = ps.product AND p.hsnCode = hsn.hsnCode AND pc.id = p.productCategory";

		try {
			TypedQuery<stockSummaryModel> typedQuery = entityManager.createQuery(query, stockSummaryModel.class);
			return typedQuery.getResultList();
		} catch (Exception e) {
			logger.error("Error retrieving stocks: " + e.getMessage(), e);
			return Collections.emptyList(); // or throw an exception if required
		}
	}

	@Override
	@Transactional
	public long getTotalStocks() {
		logger.info("getting the total number of records in stocks for pagination purpose");
		String query = "SELECT COUNT(*) FROM eStoreProduct.model.admin.entities.productsModel";

		try {
			TypedQuery<Long> countQuery = entityManager.createQuery(query, Long.class);
			return countQuery.getSingleResult();
		} catch (Exception e) {
			logger.error("Error retrieving total stocks: " + e.getMessage(), e);
			return 0; // or throw an exception if required
		}
	}

	@Override
	@Transactional
	public List<stockSummaryModel> getStocks(int page, int pageSize) {
		logger.info("getting the specific set of records based on page number");
		String query = "SELECT NEW eStoreProduct.model.admin.output.stockSummaryModel("
				+ "p.id, p.title, p.productCategory, p.hsnCode, p.brand, p.imageUrl, p.description, p.reorderLevel, pc.prct_title, "
				+ "hsn.sgst, hsn.igst, hsn.cgst, hsn.gst, ps.price, ps.stock, ps.mrp) "
				+ "FROM eStoreProduct.model.admin.entities.productsModel p, eStoreProduct.model.admin.entities.productCategoryModel pc, eStoreProduct.model.admin.entities.HSNCodeModel hsn, eStoreProduct.model.admin.entities.productStockModel ps "
				+ "WHERE p.id = ps.product AND p.hsnCode = hsn.hsnCode AND pc.id = p.productCategory";

		try {
			TypedQuery<stockSummaryModel> typedQuery = entityManager.createQuery(query, stockSummaryModel.class);
			typedQuery.setFirstResult(page * pageSize);
			typedQuery.setMaxResults(pageSize);
			return typedQuery.getResultList();
		} catch (Exception e) {
			logger.error("Error retrieving stocks for page " + page + ": " + e.getMessage(), e);
			return Collections.emptyList(); // or throw an exception if required
		}
	}

	@Override
	@Transactional
	public void updateStocks(int prodid, String imageurl, String desc, int reorderlevel, int stock, double mrp,
			double price) {
		logger.info("updating the stocks based on the input");
		System.out.println("In the method: " + prodid + " stock " + stock);

		try {
			productsModel product = entityManager.find(productsModel.class, prodid);

			productStockModel psm = entityManager.find(productStockModel.class, prodid);

			if (product != null) {
				product.setReorderLevel(reorderlevel);
				product.setImageUrl(imageurl);
				product.setDescription(desc);
				entityManager.merge(product);
				System.out.println("Product updated successfully.");
			} else {
				System.out.println("Product not found.");
			}

			if (psm != null) {
				psm.setStock(stock);
				// psm.setPrice(price);
				entityManager.merge(psm);
				System.out.println("Stock updated successfully.");
			} else {
				System.out.println("Stock not found.");
			}
		} catch (Exception e) {
			logger.error("Error updating the product: " + e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void updatePrice(int id, double mrp, double price) {
		logger.info("updating the price of the product based on price review");

		try {
			productsModel product = entityManager.find(productsModel.class, id);
			productStockModel psm = entityManager.find(productStockModel.class, id);

			if (psm != null) {
				psm.setPrice(price);
				entityManager.merge(psm);
				System.out.println("Price updated successfully.");
			} else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			logger.error("Error updating the product price: " + e.getMessage(), e);
		}
	}

	@Override
	public int totalStocks(int count) {
		// TODO Auto-generated method stub
		return 0;
	}
}
