package eStoreProduct.BLL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eStoreProduct.DAO.customer.walletDAO;
import eStoreProduct.model.customer.input.wallet;

@Component
public class WalletCalculationBLL {
	walletDAO wdao;
	private static final Logger logger = LoggerFactory.getLogger(WalletCalculationBLL.class);

	// method for calculate the total order price on wallet
	public double WalletCalc(wallet w, double orderprice) {
		logger.info(
				"eStoreProduct:WalletCalculationBLL::customer selects the wallet option then minus the wallet amount on actual order price");
		double walletamt = w.getAmount();
		double amttopay = 0;
		// customer only use the 0.8% of amount on order price
		double walletlimitused = 0.8;

		walletlimitused = walletlimitused * orderprice;
		if ((walletamt != 0 && walletlimitused < walletamt)) {
			amttopay = orderprice - walletlimitused;
		} else if ((walletamt != 0 && walletlimitused >= walletamt)) {
			amttopay = orderprice - walletamt;

		}
		// if wallet amount is zero its throw the exception
		else if (w.getAmount() == 0) {

			amttopay = orderprice;
		}
		return amttopay;

	}

}
