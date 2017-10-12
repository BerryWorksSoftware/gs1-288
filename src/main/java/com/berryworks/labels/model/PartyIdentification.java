package com.berryworks.labels.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"type_N101", "name_N102", "addressLine1_N301", "addressLine2_N302", "city_N401", "stateOrProvince_N402", "postalCode_N403"})
public class PartyIdentification {

    private String type_N101;
    private String name_N102;
    private String addressLine1_N301;
    private String addressLine2_N302;
    private String city_N401;
    private String stateOrProvince_N402;
    private String postalCode_N403;

    @XmlElement
    public String getType_N101() {
        return type_N101;
    }

    public void setType_N101(String type_N101) {
        this.type_N101 = type_N101;
    }

    @XmlElement
    public String getName_N102() {
        return name_N102;
    }

    public void setName_N102(String name_N102) {
        this.name_N102 = name_N102;
    }

    @XmlElement
    public String getAddressLine1_N301() {
        return addressLine1_N301;
    }

    public void setAddressLine1_N301(String addressLine1_N301) {
        this.addressLine1_N301 = addressLine1_N301;
    }

    @XmlElement
    public String getAddressLine2_N302() {
        return addressLine2_N302;
    }

    public void setAddressLine2_N302(String addressLine2_N302) {
        this.addressLine2_N302 = addressLine2_N302;
    }

    @XmlElement
    public String getCity_N401() {
        return city_N401;
    }

    public void setCity_N401(String city_N401) {
        this.city_N401 = city_N401;
    }

    @XmlElement
    public String getStateOrProvince_N402() {
        return stateOrProvince_N402;
    }

    public void setStateOrProvince_N402(String stateOrProvince_N402) {
        this.stateOrProvince_N402 = stateOrProvince_N402;
    }

    @XmlElement
    public String getPostalCode_N403() {
        return postalCode_N403;
    }

    public void setPostalCode_N403(String postalCode_N403) {
        this.postalCode_N403 = postalCode_N403;
    }

    public String getCityStateZip() {
        return getCity_N401() + ", " + getStateOrProvince_N402() + "  " + getPostalCode_N403();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartyIdentification)) return false;

        PartyIdentification that = (PartyIdentification) o;

        if (getType_N101() != null ? !getType_N101().equals(that.getType_N101()) : that.getType_N101() != null)
            return false;
        if (getName_N102() != null ? !getName_N102().equals(that.getName_N102()) : that.getName_N102() != null)
            return false;
        if (getAddressLine1_N301() != null ? !getAddressLine1_N301().equals(that.getAddressLine1_N301()) : that.getAddressLine1_N301() != null)
            return false;
        if (getAddressLine2_N302() != null ? !getAddressLine2_N302().equals(that.getAddressLine2_N302()) : that.getAddressLine2_N302() != null)
            return false;
        if (getCity_N401() != null ? !getCity_N401().equals(that.getCity_N401()) : that.getCity_N401() != null)
            return false;
        if (getStateOrProvince_N402() != null ? !getStateOrProvince_N402().equals(that.getStateOrProvince_N402()) : that.getStateOrProvince_N402() != null)
            return false;
        return getPostalCode_N403() != null ? getPostalCode_N403().equals(that.getPostalCode_N403()) : that.getPostalCode_N403() == null;
    }

    @Override
    public int hashCode() {
        int result = getType_N101() != null ? getType_N101().hashCode() : 0;
        result = 31 * result + (getName_N102() != null ? getName_N102().hashCode() : 0);
        result = 31 * result + (getAddressLine1_N301() != null ? getAddressLine1_N301().hashCode() : 0);
        result = 31 * result + (getAddressLine2_N302() != null ? getAddressLine2_N302().hashCode() : 0);
        result = 31 * result + (getCity_N401() != null ? getCity_N401().hashCode() : 0);
        result = 31 * result + (getStateOrProvince_N402() != null ? getStateOrProvince_N402().hashCode() : 0);
        result = 31 * result + (getPostalCode_N403() != null ? getPostalCode_N403().hashCode() : 0);
        return result;
    }
}
