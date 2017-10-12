package com.berryworks.labels.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"shipFrom", "shipTo", "carrier", "sscc", "purchaseOrderNumber", "zoneE", "zoneF", "zoneG", "zoneH"})
public class ShippingLabelContent {

    private PartyIdentification shipFrom, shipTo;
    private String purchaseOrderNumber;
    private CarrierInformation carrier;
    private Zone zoneE, zoneF, zoneG, zoneH;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingLabelContent)) return false;

        ShippingLabelContent that = (ShippingLabelContent) o;

        if (getShipFrom() != null ? !getShipFrom().equals(that.getShipFrom()) : that.getShipFrom() != null)
            return false;
        if (getShipTo() != null ? !getShipTo().equals(that.getShipTo()) : that.getShipTo() != null) return false;
        if (getPurchaseOrderNumber() != null ? !getPurchaseOrderNumber().equals(that.getPurchaseOrderNumber()) : that.getPurchaseOrderNumber() != null)
            return false;
        if (getCarrier() != null ? !getCarrier().equals(that.getCarrier()) : that.getCarrier() != null) return false;
        if (getZoneE() != null ? !getZoneE().equals(that.getZoneE()) : that.getZoneE() != null) return false;
        if (getZoneF() != null ? !getZoneF().equals(that.getZoneF()) : that.getZoneF() != null) return false;
        if (getZoneG() != null ? !getZoneG().equals(that.getZoneG()) : that.getZoneG() != null) return false;
        if (getZoneH() != null ? !getZoneH().equals(that.getZoneH()) : that.getZoneH() != null) return false;
        return getSscc() != null ? getSscc().equals(that.getSscc()) : that.getSscc() == null;
    }

    @Override
    public int hashCode() {
        int result = getShipFrom() != null ? getShipFrom().hashCode() : 0;
        result = 31 * result + (getShipTo() != null ? getShipTo().hashCode() : 0);
        result = 31 * result + (getPurchaseOrderNumber() != null ? getPurchaseOrderNumber().hashCode() : 0);
        result = 31 * result + (getCarrier() != null ? getCarrier().hashCode() : 0);
        result = 31 * result + (getZoneE() != null ? getZoneE().hashCode() : 0);
        result = 31 * result + (getZoneF() != null ? getZoneF().hashCode() : 0);
        result = 31 * result + (getZoneG() != null ? getZoneG().hashCode() : 0);
        result = 31 * result + (getZoneH() != null ? getZoneH().hashCode() : 0);
        result = 31 * result + (getSscc() != null ? getSscc().hashCode() : 0);
        return result;
    }
}
