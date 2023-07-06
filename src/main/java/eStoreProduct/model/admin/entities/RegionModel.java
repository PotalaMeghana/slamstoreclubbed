package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slam_regions")
public class RegionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_name", nullable = false)
    private String regionName;

    @Column(name = "region_pin_from", nullable = false)
    private Integer regionPinFrom;

    @Column(name = "region_pin_to", nullable = false)
    private Integer regionPinTo;

    @Column(name = "region_surcharge")
    private Double regionSurcharge;

    @Column(name = "region_pricewaiver")
    private Double regionPriceWaiver;

    // Constructors, getters, and setters

    public RegionModel() {
        // Default constructor
    }

    public RegionModel(String regionName, Integer regionPinFrom, Integer regionPinTo,
                      Double regionSurcharge, Double regionPriceWaiver) {
        this.regionName = regionName;
        this.regionPinFrom = regionPinFrom;
        this.regionPinTo = regionPinTo;
        this.regionSurcharge = regionSurcharge;
        this.regionPriceWaiver = regionPriceWaiver;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionPinFrom() {
        return regionPinFrom;
    }

    public void setRegionPinFrom(Integer regionPinFrom) {
        this.regionPinFrom = regionPinFrom;
    }

    public Integer getRegionPinTo() {
        return regionPinTo;
    }

    public void setRegionPinTo(Integer regionPinTo) {
        this.regionPinTo = regionPinTo;
    }

    public Double getRegionSurcharge() {
        return regionSurcharge;
    }

    public void setRegionSurcharge(Double regionSurcharge) {
        this.regionSurcharge = regionSurcharge;
    }

    public Double getRegionPriceWaiver() {
        return regionPriceWaiver;
    }

    public void setRegionPriceWaiver(Double regionPriceWaiver) {
        this.regionPriceWaiver = regionPriceWaiver;
    }
}
