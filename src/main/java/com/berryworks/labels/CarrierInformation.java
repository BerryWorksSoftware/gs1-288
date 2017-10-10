package com.berryworks.labels;

import static com.berryworks.edireader.util.FixedLength.isPresent;

public class CarrierInformation {

    private String scac;
    private String nonScacName;
    private String billOfLading_REF_BM;
    private String proInvoice_REF_CN;

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

    public String getBillOfLading_REF_BM() {
        return billOfLading_REF_BM;
    }

    public void setBillOfLading_REF_BM(String billOfLading_REF_BM) {
        this.billOfLading_REF_BM = billOfLading_REF_BM;
    }

    public String getProInvoice_REF_CN() {
        return proInvoice_REF_CN;
    }

    public void setProInvoice_REF_CN(String proInvoice_REF_CN) {
        this.proInvoice_REF_CN = proInvoice_REF_CN;
    }

    public String getCarrierName() {
        if (isPresent(scac)) {
            final String name = ScacDictionary.getName(scac);
            return isPresent(name) ? name : scac;
        }
        return nonScacName;
    }
}
