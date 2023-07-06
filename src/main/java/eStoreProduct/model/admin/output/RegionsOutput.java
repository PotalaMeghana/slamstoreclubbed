package eStoreProduct.model.admin.output;

public class RegionsOutput {
	private int regionId;
	private String regionName;
	private int regionPinFrom;
	private int regionPinTo;
	private double regionSurcharge;
	private double regionPriceWaiver;

	public RegionsOutput(int regionId, String regionName, int regionPinFrom, int regionPinTo, double regionSurcharge,
			double regionPriceWaiver) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionPinFrom = regionPinFrom;
		this.regionPinTo = regionPinTo;
		this.regionSurcharge = regionSurcharge;
		this.regionPriceWaiver = regionPriceWaiver;
	}

	public RegionsOutput() {
		// TODO Auto-generated constructor stub
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getRegionPinFrom() {
		return regionPinFrom;
	}

	public void setRegionPinFrom(int regionPinFrom) {
		this.regionPinFrom = regionPinFrom;
	}

	public int getRegionPinTo() {
		return regionPinTo;
	}

	public void setRegionPinTo(int regionPinTo) {
		this.regionPinTo = regionPinTo;
	}

	public double getRegionSurcharge() {
		return regionSurcharge;
	}

	public void setRegionSurcharge(double regionSurcharge) {
		this.regionSurcharge = regionSurcharge;
	}

	public double getRegionPriceWaiver() {
		return regionPriceWaiver;
	}

	public void setRegionPriceWaiver(double regionPriceWaiver) {
		this.regionPriceWaiver = regionPriceWaiver;
	}
}