package com.berryworks.labels;

public class ShippingLabelContent {

    private PartyIdentification shipFrom;
    private PartyIdentification shipTo;
    private String purchaseOrderNumber;
    private CarrierInformation carrier;
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

    public String getSSCC() {
        return sscc;
    }

    public void setSscc(String sscc) {
        this.sscc = sscc;
    }
}
