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

import eStoreProduct.model.admin.entities.RegionModel;
import eStoreProduct.model.admin.input.Regions;
import eStoreProduct.model.admin.output.RegionsOutput;


@Component
public class RegionDAOImpl implements RegionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(RegionDAOImpl.class);


	@Override
	@Transactional
	public List<RegionsOutput> getRegions() {
						    logger.info("in RegionDAOImpl.getRegions() ");

		try {

            TypedQuery<RegionsOutput> query = entityManager.createQuery("SELECT NEW eStoreProduct.model.admin.output.RegionsOutput("
            		+ "r.regionId, r.regionName,r.regionPinFrom,r.regionPinTo,r.regionSurcharge,r.regionPriceWaiver)"
            		+ " FROM RegionModel r", RegionsOutput.class);
            List<RegionsOutput> regions = query.getResultList();
            System.out.print("in getting all regions\n");
            //System.out.print(regions);
            return regions;
        } catch (Exception e) {
															 logger.error("Error occurred in RegionDAOImpl.getRegions() method: {}", e.getMessage());

            // Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
            e.printStackTrace();
            return Collections.emptyList(); // or throw an exception if required
        }
	}

	@Override
	@Transactional
	public void addRegion(Regions reg) {
								    logger.info("in RegionDAOImpl.addRegion() ");

		RegionModel reg1=new RegionModel() ;
		reg1.setRegionId(reg.getRegionId());
		reg1.setRegionName(reg.getRegionName());
		reg1.setRegionPinFrom(reg.getRegionPinFrom());
		reg1.setRegionPinTo(reg.getRegionPinTo());
		reg1.setRegionPriceWaiver(reg.getRegionPriceWaiver());
		reg1.setRegionSurcharge(reg.getRegionSurcharge());
        entityManager.merge(reg1);
    }
	
	
	@Override
	@Transactional
	public void removeRegion(int id) {
										    logger.info("in RegionDAOImpl.removeRegion() ");

		RegionModel region = entityManager.find(RegionModel.class, id);
        if (region != null) {

            entityManager.remove(region);
																    logger.info("in RegionDAOImpl.removeRegion() removed region");

        }
    }
}