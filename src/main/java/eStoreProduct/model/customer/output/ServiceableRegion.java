package eStoreProduct.model.customer.output;

public class ServiceableRegion {
	private int srrgId;
	private String srrgName;
	private int srrgPinFrom;
	private int srrgPinTo;
	private double srrgPriceSurcharge;
	private double srrgPriceWaiver;

	// Default constructor
	public ServiceableRegion() {
	}

	public ServiceableRegion(int srrgId, String srrgName, int srrgPinFrom, int srrgPinTo, double srrgPriceSurcharge,
			double srrgPriceWaiver) {
		super();
		this.srrgId = srrgId;
		this.srrgName = srrgName;
		this.srrgPinFrom = srrgPinFrom;
		this.srrgPinTo = srrgPinTo;
		this.srrgPriceSurcharge = srrgPriceSurcharge;
		this.srrgPriceWaiver = srrgPriceWaiver;
	}

	// Getters and setters
	public int getSrrgId() {
		return srrgId;
	}

	public void setSrrgId(int srrgId) {
		this.srrgId = srrgId;
	}

	public String getSrrgName() {
		return srrgName;
	}

	public void setSrrgName(String srrgName) {
		this.srrgName = srrgName;
	}

	public int getSrrgPinFrom() {
		return srrgPinFrom;
	}

	public void setSrrgPinFrom(int srrgPinFrom) {
		this.srrgPinFrom = srrgPinFrom;
	}

	public int getSrrgPinTo() {
		return srrgPinTo;
	}

	public void setSrrgPinTo(int srrgPinTo) {
		this.srrgPinTo = srrgPinTo;
	}

	public double getSrrgPriceSurcharge() {
		return srrgPriceSurcharge;
	}

	public void setSrrgPriceSurcharge(double srrgPriceSurcharge) {
		this.srrgPriceSurcharge = srrgPriceSurcharge;
	}

	public double getSrrgPriceWaiver() {
		return srrgPriceWaiver;
	}

	public void setSrrgPriceWaiver(double srrgPriceWaiver) {
		this.srrgPriceWaiver = srrgPriceWaiver;
	}
}
