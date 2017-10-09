package com.berryworks.labels;

import static com.berryworks.edireader.util.FixedLength.isPresent;

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
        if (isPresent(scac)) {
            final String name = ScacDictionary.getName(scac);
            return isPresent(name) ? name : scac;
        }
        return nonScacName;
    }
}
