package com.berryworks.labels;

public class ShippingLabelContent {

    private String sscc;
    private PartyIdentification shipTo;

    public String getSSCC() {
        return sscc;
    }

    public void setSscc(String sscc) {
        this.sscc = sscc;
    }

    public PartyIdentification getShipTo() {
        return shipTo;
    }

    public void setShipTo(PartyIdentification shipTo) {
        this.shipTo = shipTo;
    }
}
