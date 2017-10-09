package com.berryworks.labels;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ShippingLabelCreatorTest {
    private ShippingLabelCreator creator;
    private File pdf;

    @Test
    public void basics() throws IOException {
        creator = new ShippingLabelCreator();
        final ShippingLabelContent slc = new ShippingLabelContent();
        slc.setSscc("00123456789012345678");
        final PartyIdentification shipTo = new PartyIdentification();
        shipTo.setType_N101("ST");
        shipTo.setName_N102("John Smith");
        shipTo.setCity_N401("Houston");
        shipTo.setStateOrProvince_N402("TX");
        shipTo.setPostalCode_N403("77070");
        slc.setShipTo(shipTo);
        slc.setPurchaseOrderNumber("ABC213");
        final CarrierInformation carrierInformation = new CarrierInformation();
        carrierInformation.setScac("EUSA");
        carrierInformation.setBillOfLading("9379562");
        carrierInformation.setProInvoice("2659739");
        slc.setCarrier(carrierInformation);
        pdf = creator.createLabel(slc);
        assertTrue(pdf.exists());
    }
}
