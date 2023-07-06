package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.output.ProdStock;

public interface ProdStockDAO {

	List<ProdStock> getAllProdStocks();

	ProdStock getProdStockById(int prodId);

	double getProdMrpById(int prodId);

	double getProdPriceById(int prodId);

}