package com.berryworks.labels;

import com.berryworks.labels.model.CarrierInformation;
import com.berryworks.labels.model.PartyIdentification;
import com.berryworks.labels.model.ShippingLabelContent;

public class Sample {

    public static ShippingLabelContent sample() {
        final ShippingLabelContent slc = new ShippingLabelContent();
        slc.setSscc("00123456789012345678");
        final PartyIdentification shipFrom = new PartyIdentification();
        shipFrom.setName_N102("FromName");
        shipFrom.setAddressLine1_N301("Line 1");
        shipFrom.setAddressLine2_N302("Line 2");
        shipFrom.setCity_N401("Nashville");
        shipFrom.setStateOrProvince_N402("TN");
        shipFrom.setPostalCode_N403("37218");
        slc.setShipFrom(shipFrom);
        final PartyIdentification shipTo = new PartyIdentification();
        shipTo.setName_N102("ToName");
        shipTo.setAddressLine1_N301("Line 1");
        shipTo.setAddressLine2_N302("Line 2");
        shipTo.setCity_N401("Eustis");
        shipTo.setStateOrProvince_N402("FL");
        shipTo.setPostalCode_N403("32713");
        slc.setShipTo(shipTo);
        final CarrierInformation carrier = new CarrierInformation();
        carrier.setScac("");
        slc.setCarrier(carrier);
        return slc;
    }
}
