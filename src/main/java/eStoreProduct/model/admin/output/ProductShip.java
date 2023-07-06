package eStoreProduct.model.admin.output;

public class ProductShip {
    private int prod_id;
    private String prod_title;
    private double prod_price;
    private double shipment_charges;
    
    public int getProd_id() {
        return prod_id;
    }
    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
    public String getProd_title() {
        return prod_title;
    }
    public void setProd_title(String prod_title) {
        this.prod_title = prod_title;
    }
    public double getProd_price() {
        return prod_price;
    }
    public void setProd_price(double prod_price) {
        this.prod_price = prod_price;
    }
    public double getShipment_charges() {
        return shipment_charges;
    }
    public void setShipment_charges(double shipment_charges) {
        this.shipment_charges = shipment_charges;
    }
    
    
}
