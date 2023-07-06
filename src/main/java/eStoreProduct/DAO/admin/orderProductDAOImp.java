package eStoreProduct.DAO.admin;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.input.orderProductInput;
import eStoreProduct.model.admin.output.orderProductsModel;

@Component
public class orderProductDAOImp implements orderProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(orderProductDAOImp.class);

	@Override
	@Transactional
	public List<orderProductsModel> getOrderWiseOrderProducts(int orderid) {
		    logger.info("in orderProductDAOImp.getOrderWiseOrderProducts() ");

		String query = "SELECT NEW eStoreProduct.model.admin.output.orderProductsModel("
				+ "op.orderId,op.productId,op.quantity,op.gst,op.price,op.shipmentStatus) from orderProductModel op where "
				+ "op.orderId=:orderid";
				
		try {
			List<orderProductsModel> l = entityManager.createQuery(query, orderProductsModel.class)
					.setParameter("orderid", orderid).getResultList();

			for (orderProductsModel lis : l)
				System.out.println("Inside" + lis);
			return l;
		} catch (Exception e) {
			 logger.error("Error occurred in orderProductDAOImp.getOrderWiseOrderProducts() method: {}", e.getMessage());

			// Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
			e.printStackTrace();
			return Collections.emptyList(); // or throw an exception if required
		}

	}

	/*@Override
	@Transactional
	public int updateOrderProductStatus(orderProductInput op) {
				    logger.info("in orderProductDAOImp.updateOrderProductStatus() ");

		String status = op.getShipment_status();
		int oid = op.getOrdr_id();
		int pid = op.getProd_id();
		int x = entityManager.createQuery(
				"UPDATE orderProductModel op SET op.shipmentStatus = :status WHERE op.orderId = :oid AND op.productId = :pid")
				.setParameter("status", status).setParameter("oid", oid).setParameter("pid", pid).executeUpdate();
		System.out.print("\nrows affected: " + x);
		return x;
	}*/
	@Override
    @Transactional
    public int updateOrderProductStatus(orderProductInput op) {
        logger.info("in orderProductDAOImp.updateOrderProductStatus() ");

        String status = op.getShipment_status();
        int oid = op.getOrdr_id();
        int pid = op.getProd_id();

        try {
            int x = entityManager.createQuery(
                "UPDATE orderProductModel op SET op.shipmentStatus = :status WHERE op.orderId = :oid AND op.productId = :pid")
                .setParameter("status", status).setParameter("oid", oid).setParameter("pid", pid).executeUpdate();
            
            logger.info("Rows affected: {}", x);
            return x;
        } catch (Exception e) {
            logger.error("Error occurred in orderProductDAOImp.updateOrderProductStatus(): {}", e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow the exception or handle it appropriately
        }
    }

}
