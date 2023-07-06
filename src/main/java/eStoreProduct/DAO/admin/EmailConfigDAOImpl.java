
package eStoreProduct.DAO.admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eStoreProduct.model.admin.entities.EmailConfigModel;

@Component
public class EmailConfigDAOImpl implements EmailConfigDAO {
	@PersistenceContext
	private EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(EmailConfigDAOImpl.class);

	private final String SELECT_EMAIL = "SELECT e FROM EmailConfigModel e WHERE e.id = 1";
	private final String UPDATE_EMAIL = "UPDATE EmailConfigModel e SET e.email = :email, e.pwd = :pwd WHERE e.id = 1";

	@Override
@Transactional
public void changeEmail(EmailConfigModel ecm) {
    // Update the email configuration in the database
    entityManager.createQuery(UPDATE_EMAIL)
            .setParameter("email", ecm.getEmail())
            .setParameter("pwd", ecm.getPwd())
            .executeUpdate();

    // Log message indicating the change of email configuration
    logger.info("EmailConfigDAOImpl.changeEmail() Email configuration changed");
}

@Override
@Transactional
public EmailConfigModel getEmail() {
    // Retrieve the email configuration from the database
    EmailConfigModel emailConfig = entityManager.createQuery(SELECT_EMAIL, EmailConfigModel.class)
            .getSingleResult();

    // Log message indicating the retrieval of email configuration
    logger.info("EmailConfigDAOImpl.EmailConfigModel() Retrieved email configuration");

    return emailConfig;
}

}
