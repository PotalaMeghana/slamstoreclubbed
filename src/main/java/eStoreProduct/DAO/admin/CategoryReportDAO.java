package eStoreProduct.DAO.admin;
import java.util.List;
import eStoreProduct.model.admin.output.CategoryReportViewModel;

public interface CategoryReportDAO {
    public List<CategoryReportViewModel> getCatRep();
}
