package eStoreProduct.DAO.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.output.CategoryReportViewModel;

@Component
public class CategoryReportDAOImpl implements CategoryReportDAO {
	@PersistenceContext
	private EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(CategoryReportDAOImpl.class);

    /**
     * Retrieves a list of CategoryReportViewModel objects containing category report data.
     *
     * @return The list of CategoryReportViewModel objects.
     */
	@Transactional
	@Override
public List<CategoryReportViewModel> getCatRep() {
    String hql = "select new eStoreProduct.model.admin.output.CategoryReportViewModel(spc.id, spc.prct_title, count(*), sum(sop.price), sum(sop.gst), sum(sop.quantity)) "
            + "from orderModel so, OrderProds sop, SlamProduct sp, productCategoryModel spc "
            + "where sop.productId = sp.id and sp.productCategory = spc.id group by spc.id";

    List<CategoryReportViewModel> result = entityManager.createQuery(hql, CategoryReportViewModel.class)
            .getResultList();

    // Log message indicating the execution of the method
    logger.info("Executed getCatRep() method in CategoryDAOImp");

    // Log the result for debugging purposes
    logger.debug("Category Report Result: {}", result);

    return result;
}


}
