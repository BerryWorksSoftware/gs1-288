package com.berryworks.labels;

import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;

import java.io.File;
import java.io.IOException;

import static com.berryworks.edireader.util.FixedLength.isPresent;

public class ShippingLabelCreator {
    private static final String PDF_FILENAME = "temp.pdf";
    private static final float FONT_SIZE = 8.0f;
    public static final int POINTS_PER_INCH = 72;

    public File createLabel(ShippingLabelContent slc) throws IOException {
        final File file = new File(PDF_FILENAME);
        final PdfWriter pdfWriter = new PdfWriter(file);
        final PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        final PageSize pageSize = new PageSize(4 * POINTS_PER_INCH, 6 * POINTS_PER_INCH);
        final Document document = new Document(pdfDocument, pageSize);
        Table table = new Table(2);
        //
        // Zone A - From
        //
        table.addCell(createShipFrom(slc.getShipFrom()));
        //
        // Zone B - Ship To (readable)
        //
        table.addCell(createShipTo(slc.getShipTo()));
        //
        // Zone C - Ship To: postal code as barcode
        //
        table.addCell(createShipToPostalBarcode(pdfDocument, slc.getShipTo()));
        //
        // Zone D - Carrier
        //
        table.addCell(createCarrier(slc.getCarrier()));
        //
        // Zone E - general purpose
        //
        table.addCell(createGeneralPurposeCell(slc.getZoneE()));
        //
        // Zone F - general purpose
        //
        table.addCell(createGeneralPurposeCell(slc.getZoneF()));
        //
        // Zone G - general purpose
        //
        table.addCell(createGeneralPurposeCell(slc.getZoneG()));
        //
        // Zone H - general purpose
        //
        table.addCell(createGeneralPurposeCell(slc.getZoneH()));
        //
        // Zone I - SSCC
        //
        table.addCell(createSSCC(pdfDocument, slc.getSscc()));
        //
        // Finish
        //
        document.add(table);
        document.close();
        return file;
    }

    private Cell createShipFrom(PartyIdentification shipFrom) {
        return createNameAndAddressCell("FROM", shipFrom);
    }

    private Cell createShipTo(PartyIdentification shipTo) {
        return createNameAndAddressCell("TO", shipTo);
    }

    private Cell createShipToPostalBarcode(PdfDocument pdfDocument, PartyIdentification shipTo) {
        final Cell shipToPostalCodeCell = new Cell();
        add(shipToPostalCodeCell, "Ship To Postal Code:");

        final Barcode128 barCode = new Barcode128(pdfDocument);
        final String postalCode = shipTo.getPostalCode_N403();
        final String postalCodeWithPrefix = "420" + postalCode;
        barCode.setCode(postalCodeWithPrefix);
        barCode.setAltText(displayPostalCode(postalCodeWithPrefix));
        final Image image = new Image(barCode.createFormXObject(null, null, pdfDocument));
        image.setHorizontalAlignment(HorizontalAlignment.CENTER);
        shipToPostalCodeCell.add(image);

        return shipToPostalCodeCell;
    }

    private Cell createCarrier(CarrierInformation carrier) {
        final Cell carrierCell = new Cell();
        add(carrierCell, "Carrier:");
        final String scac = carrier.getScac();
        if (isPresent(scac)) {
            add(carrierCell, scac);
            final String expandedName = carrier.expandCarrierNameFromSCAC();
            if (isPresent(expandedName)) {
                add(carrierCell, expandedName);
            }
        } else {
            final String nonScacName = carrier.getNonScacName();
            if (isPresent(nonScacName)) {
                add(carrierCell, nonScacName);
            }
        }
        final String proInvoice = carrier.getProInvoice_REF_CN();
        if (isPresent(proInvoice)) {
            add(carrierCell, "PRO: " + proInvoice);
        }
        final String billOfLading = carrier.getBillOfLading_REF_BM();
        if (isPresent(billOfLading)) {
            add(carrierCell, "B/L: " + billOfLading);
        }
        return carrierCell;
    }

    private Cell createGeneralPurposeCell(Zone zone) {
        final Cell cell = new Cell();
        if (zone == null) {
            return cell;
        }
        final String line1 = zone.getLine1();
        if (isPresent(line1)) {
            add(cell, line1);
        }
        final String line2 = zone.getLine2();
        if (isPresent(line2)) {
            add(cell, line2);
        }
        final String line3 = zone.getLine3();
        if (isPresent(line3)) {
            add(cell, line3);
        }
        final String line4 = zone.getLine4();
        if (isPresent(line4)) {
            add(cell, line4);
        }
        return cell;
    }

    private Cell add(Cell cell, String line) {
        cell.add(new Paragraph(line).setFontSize(FONT_SIZE));
        return cell;
    }

    private Cell createPurchaseOrderDetail(ShippingLabelContent slc) {
        return add(new Cell(1, 2), "PO# " + slc.getPurchaseOrderNumber());
    }

    private Cell createSSCC(PdfDocument inPdfDocument, String sscc) {
        final Cell ssccCell = new Cell(1, 2);
        add(ssccCell, "SSCC-18");
        final Barcode128 barcode = new Barcode128(inPdfDocument);
        barcode.setCodeType(Barcode128.CODE128_UCC);
        barcode.setCode(sscc);
        barcode.setAltText(displaySSCC(sscc));

        final Image image = new Image(barcode.createFormXObject(null, null, inPdfDocument));
        image.setHorizontalAlignment(HorizontalAlignment.CENTER);
        ssccCell.add(image);
        return ssccCell;
    }

    private Cell createNameAndAddressCell(String title, PartyIdentification party) {
        final Cell cell = new Cell();
        add(cell, title + ":");
        add(cell, party.getName_N102());
        final String addressLine1 = party.getAddressLine1_N301();
        if (isPresent(addressLine1)) {
            add(cell, addressLine1);
        }
        final String addressLine2 = party.getAddressLine2_N302();
        if (isPresent(addressLine2)) {
            add(cell, addressLine2);
        }
        add(cell, party.getCityStateZip());
        return cell;
    }

    private String displayPostalCode(String postalCode) {
        if (!isPresent(postalCode)) return "";
        if (postalCode.length() < 8) return postalCode;
        final String prefix = postalCode.substring(0, 3);
        final StringBuilder sb = new StringBuilder("(").append(prefix).append(") ");
        postalCode = postalCode.substring(3);
        if (postalCode.length() == 9) {
            sb.append(postalCode.substring(0, 5)).append("-").append(postalCode.substring(5));
        } else {
            sb.append(postalCode);
        }
        return sb.toString();
    }

    private String displaySSCC(String sscc) {
        if (sscc == null || sscc.length() != 20) return sscc;
        //  (00) 1 2345678 901234567 8
        //   +   + +       +         +
        //   0   2 3       10        19   index of sub-field
        //
        return "(" + sscc.substring(0, 2) + ") " +
                sscc.substring(2, 3) + " " +
                sscc.substring(3, 10) + " " +
                sscc.substring(10, 19) + " " +
                sscc.substring(19, 20);
    }
}
