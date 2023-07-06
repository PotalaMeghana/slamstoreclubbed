package eStoreProduct.DAO.admin;

import eStoreProduct.model.admin.entities.adminModel;

public interface adminDAO {

	public adminModel getAdmin(String email, String psd);

	public void updateAdmin(adminModel am);
}
