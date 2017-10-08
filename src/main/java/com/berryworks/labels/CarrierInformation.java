package com.berryworks.labels;

public class CarrierInformation {

    private String scac;
    private String nonScacName;

    public String getSCAC() {
        return scac;
    }

    public void setSCAC(String scac) {
        this.scac = scac;
    }

    public String getNonScacName() {
        return nonScacName;
    }

    public void setNonScacName(String nonScacName) {
        this.nonScacName = nonScacName;
    }

    public String getCarrierName() {
        if (scac != null && scac.length() > 0) {
            return scac;
        }
        return nonScacName;
    }
}
