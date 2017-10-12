package com.berryworks.labels;

import com.berryworks.labels.model.CarrierInformation;
import com.berryworks.labels.model.PartyIdentification;
import com.berryworks.labels.model.ShippingLabelContent;
import com.berryworks.labels.model.Zone;

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
        carrier.setScac("BINE");
        slc.setCarrier(carrier);
        final Zone zoneE = new Zone();
        zoneE.setLine1("E line 1");
        zoneE.setLine2("E line 2");
        zoneE.setLine3("E line 3");
        zoneE.setLine4("E line 4");
        slc.setZoneE(zoneE);
        final Zone zoneF = new Zone();
        zoneF.setLine1("F line 1");
        zoneF.setLine2("F line 2");
        zoneF.setLine3("F line 3");
        slc.setZoneF(zoneF);
        final Zone zoneG = new Zone();
        zoneG.setLine1("G line 1");
        zoneG.setLine2("G line 2");
        slc.setZoneG(zoneG);
        final Zone zoneH = new Zone();
        zoneH.setLine1("H line 1");
        slc.setZoneH(zoneH);
        return slc;
    }
}
