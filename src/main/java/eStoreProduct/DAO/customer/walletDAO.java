package eStoreProduct.DAO.customer;

import eStoreProduct.model.customer.input.wallet;

public interface walletDAO {
	public wallet getWalletAmount(int custid);

	public void updatewallet(double amt, int custid);

}
