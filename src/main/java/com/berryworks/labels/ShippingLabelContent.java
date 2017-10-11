package com.berryworks.labels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

    @XmlElement
    public PartyIdentification getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(PartyIdentification shipFrom) {
        this.shipFrom = shipFrom;
    }

    @XmlElement
    public PartyIdentification getShipTo() {
        return shipTo;
    }

    public void setShipTo(PartyIdentification shipTo) {
        this.shipTo = shipTo;
    }

    @XmlElement
    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    @XmlElement
    public CarrierInformation getCarrier() {
        return carrier;
    }

    public void setCarrier(CarrierInformation carrier) {
        this.carrier = carrier;
    }

    @XmlElement
    public Zone getZoneE() {
        return zoneE;
    }

    public void setZoneE(Zone zoneE) {
        this.zoneE = zoneE;
    }

    @XmlElement
    public Zone getZoneF() {
        return zoneF;
    }

    public void setZoneF(Zone zoneF) {
        this.zoneF = zoneF;
    }

    @XmlElement
    public Zone getZoneG() {
        return zoneG;
    }

    public void setZoneG(Zone zoneG) {
        this.zoneG = zoneG;
    }

    @XmlElement
    public Zone getZoneH() {
        return zoneH;
    }

    public void setZoneH(Zone zoneH) {
        this.zoneH = zoneH;
    }

    @XmlElement
    public String getSscc() {
        return sscc;
    }

    public void setSscc(String sscc) {
        this.sscc = sscc;
    }
}
