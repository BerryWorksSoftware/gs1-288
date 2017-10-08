package com.berryworks.labels;

public class PartyIdentification {

    private String type_N101;
    private String name_N102;
    private String addressLine1_N301;
    private String addressLine2_N302;
    private String city_N401;
    private String stateOrProvince_N402;
    private String postalCode_N403;

    public String getType_N101() {
        return type_N101;
    }

    public void setType_N101(String type_N101) {
        this.type_N101 = type_N101;
    }

    public String getName_N102() {
        return name_N102;
    }

    public void setName_N102(String name_N102) {
        this.name_N102 = name_N102;
    }

    public String getAddressLine1_N301() {
        return addressLine1_N301;
    }

    public void setAddressLine1_N301(String addressLine1_N301) {
        this.addressLine1_N301 = addressLine1_N301;
    }

    public String getAddressLine2_N302() {
        return addressLine2_N302;
    }

    public void setAddressLine2_N302(String addressLine2_N302) {
        this.addressLine2_N302 = addressLine2_N302;
    }

    public String getCity_N401() {
        return city_N401;
    }

    public void setCity_N401(String city_N401) {
        this.city_N401 = city_N401;
    }

    public String getStateOrProvince_N402() {
        return stateOrProvince_N402;
    }

    public void setStateOrProvince_N402(String stateOrProvince_N402) {
        this.stateOrProvince_N402 = stateOrProvince_N402;
    }

    public String getPostalCode_N403() {
        return postalCode_N403;
    }

    public void setPostalCode_N403(String postalCode_N403) {
        this.postalCode_N403 = postalCode_N403;
    }

    public String getCityStateZip() {
        StringBuilder result = new StringBuilder();
        result.append(getCity_N401()).append(", ");
        result.append(getStateOrProvince_N402()).append("  ");
        result.append(getPostalCode_N403());
        return result.toString();
    }
}
