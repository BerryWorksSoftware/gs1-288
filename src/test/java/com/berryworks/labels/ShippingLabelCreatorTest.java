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
        // From
        final PartyIdentification from = new PartyIdentification();
        from.setName_N102("The Sender Company");
        from.setAddressLine1_N301("Suite 17");
        from.setAddressLine2_N302("193 Lakefront Avenue");
        from.setCity_N401("Franklin");
        from.setStateOrProvince_N402("FL");
        from.setPostalCode_N403("32799");
        slc.setShipFrom(from);
        // Ship To
        final PartyIdentification shipTo = new PartyIdentification();
        shipTo.setType_N101("ST");
        shipTo.setName_N102("John Smith");
        shipTo.setCity_N401("Houston");
        shipTo.setStateOrProvince_N402("TX");
        shipTo.setPostalCode_N403("77070");
        slc.setShipTo(shipTo);
        // PO
        slc.setPurchaseOrderNumber("ABC213");
        // Carrier
        final CarrierInformation carrierInformation = new CarrierInformation();
        carrierInformation.setScac("EUSA");
        carrierInformation.setBillOfLading_REF_BM("9379562");
        carrierInformation.setProInvoice_REF_CN("2659739");
        slc.setCarrier(carrierInformation);
        // SSCC
        slc.setSscc("00123456789012345678");
        // Create the printable label
        pdf = creator.createLabel(slc);
        assertTrue(pdf.exists());
    }
}
