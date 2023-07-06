package eStoreProduct.DAO.admin;

import java.util.List;

import eStoreProduct.model.admin.input.OrderValueWiseShippingChargesInput;
import eStoreProduct.model.admin.output.OrderValueWiseShippingCharge;

public interface OrderValueWiseShippingChargeDAO {
	public List<OrderValueWiseShippingCharge> getAll();

	public boolean addCharge(OrderValueWiseShippingChargesInput ord);

	public boolean deleteCharge(OrderValueWiseShippingChargesInput ord);

	public boolean updateCharge(OrderValueWiseShippingChargesInput ord);
}
