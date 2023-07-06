package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.input.Regions;
import eStoreProduct.model.admin.output.RegionsOutput;


public interface RegionDAO {
	List<RegionsOutput> getRegions();

	void addRegion(Regions reg);

	void removeRegion(int id);
}
