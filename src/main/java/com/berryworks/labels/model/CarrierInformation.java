package com.berryworks.labels.model;

import com.berryworks.labels.ScacDictionary;

import static com.berryworks.edireader.util.FixedLength.isPresent;

public class CarrierInformation {

    private String scac;
    private String nonScacName;
    private String billOfLading_REF_BM;
    private String proInvoice_REF_CN;

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

    public String expandCarrierNameFromSCAC() {
        return isPresent(scac) ? ScacDictionary.getName(scac) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrierInformation)) return false;

        CarrierInformation that = (CarrierInformation) o;

        if (getScac() != null ? !getScac().equals(that.getScac()) : that.getScac() != null) return false;
        if (getNonScacName() != null ? !getNonScacName().equals(that.getNonScacName()) : that.getNonScacName() != null)
            return false;
        if (getBillOfLading_REF_BM() != null ? !getBillOfLading_REF_BM().equals(that.getBillOfLading_REF_BM()) : that.getBillOfLading_REF_BM() != null)
            return false;
        return getProInvoice_REF_CN() != null ? getProInvoice_REF_CN().equals(that.getProInvoice_REF_CN()) : that.getProInvoice_REF_CN() == null;
    }

    @Override
    public int hashCode() {
        int result = getScac() != null ? getScac().hashCode() : 0;
        result = 31 * result + (getNonScacName() != null ? getNonScacName().hashCode() : 0);
        result = 31 * result + (getBillOfLading_REF_BM() != null ? getBillOfLading_REF_BM().hashCode() : 0);
        result = 31 * result + (getProInvoice_REF_CN() != null ? getProInvoice_REF_CN().hashCode() : 0);
        return result;
    }
}
