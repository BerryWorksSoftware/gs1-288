package com.berryworks.labels;

public class ShippingLabelContent {

    private PartyIdentification shipFrom;
    private PartyIdentification shipTo;
    private String purchaseOrderNumber;
    private CarrierInformation carrier;
    private Zone zoneE;
    private Zone zoneF;
    private Zone zoneG;
    private Zone zoneH;
    private String sscc;

    public void setShipFrom(PartyIdentification shipFrom) {
        this.shipFrom = shipFrom;
    }

    public PartyIdentification getShipFrom() {
        return shipFrom;
    }

    public PartyIdentification getShipTo() {
        return shipTo;
    }

    public void setShipTo(PartyIdentification shipTo) {
        this.shipTo = shipTo;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public void setCarrier(CarrierInformation carrier) {
        this.carrier = carrier;
    }

    public CarrierInformation getCarrier() {
        return carrier;
    }

    public Zone getZoneE() {
        return zoneE;
    }

    public void setZoneE(Zone zoneE) {
        this.zoneE = zoneE;
    }

    public Zone getZoneF() {
        return zoneF;
    }

    public void setZoneF(Zone zoneF) {
        this.zoneF = zoneF;
    }

    public Zone getZoneG() {
        return zoneG;
    }

    public void setZoneG(Zone zoneG) {
        this.zoneG = zoneG;
    }

    public Zone getZoneH() {
        return zoneH;
    }

    public void setZoneH(Zone zoneH) {
        this.zoneH = zoneH;
    }

    public String getSscc() {
        return sscc;
    }

    public void setSscc(String sscc) {
        this.sscc = sscc;
    }
}
