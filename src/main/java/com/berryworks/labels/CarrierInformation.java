package com.berryworks.labels;

import static com.berryworks.edireader.util.FixedLength.isPresent;

public class CarrierInformation {

    private String scac;
    private String nonScacName;
    private String billOfLading;
    private String proInvoice;

    public String getSCAC() {
        return scac;
    }

    public String getScac() {
        return scac;
    }

    public void setScac(String scac) {
        this.scac = scac;
    }

    public String getNonScacName() {
        return nonScacName;
    }

    public void setNonScacName(String nonScacName) {
        this.nonScacName = nonScacName;
    }

    public String getBillOfLading() {
        return billOfLading;
    }

    public void setBillOfLading(String billOfLading) {
        this.billOfLading = billOfLading;
    }

    public String getProInvoice() {
        return proInvoice;
    }

    public void setProInvoice(String proInvoice) {
        this.proInvoice = proInvoice;
    }

    public String getCarrierName() {
        if (isPresent(scac)) {
            final String name = ScacDictionary.getName(scac);
            return isPresent(name) ? name : scac;
        }
        return nonScacName;
    }
}
