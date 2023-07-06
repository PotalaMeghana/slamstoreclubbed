package eStoreProduct.DAO.admin;

import eStoreProduct.model.admin.entities.EmailConfigModel;

public interface EmailConfigDAO {
	void changeEmail(EmailConfigModel ecm);

	EmailConfigModel getEmail();
}