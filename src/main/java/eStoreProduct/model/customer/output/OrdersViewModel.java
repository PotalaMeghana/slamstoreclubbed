package eStoreProduct.model.customer.output;

public class OrdersViewModel implements Comparable<OrdersViewModel> {
	private int id;
	private String name;
	private double price;
	private String description;
	private String imageUrl;
	private int ordid;
	private String ship_stat;

	public OrdersViewModel(int id, String name, double price, String description, String imageUrl, int ordid,
			String ship_stat) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.ordid = ordid;
		this.ship_stat = ship_stat;
	}

	// Getters and setters for the class properties

	public String getShipStat() {
		return ship_stat;
	}

	public void setShipStat(String ship_stat) {
		this.ship_stat = ship_stat;
	}

	public int getOrdId() {
		return ordid;
	}

	public void setOrdId(int ordid) {
		this.ordid = ordid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int compareTo(OrdersViewModel o) {
		if (this.getPrice() > o.getPrice())
			return 1;
		else if (this.getPrice() == o.getPrice())
			return 0;
		return -1;

	}

}