package eStoreProduct.Exceptions;

public class QuantityExceedsStockException extends Exception {
	public QuantityExceedsStockException(String message) {

		super(message);
	}
}