package eStoreProduct.model.customer.input;

public class cartModel {

	private int cid;
	private int pid;
	private int qty;

	public cartModel(int cid, int pid, int qty) {
		this.cid = cid;
		this.pid = pid;
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}