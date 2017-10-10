package com.berryworks.labels;

import com.itextpdf.barcodes.Barcode128;
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

    public File createLabel(ShippingLabelContent slc) throws IOException {
        final File file = new File(PDF_FILENAME);
        final PdfWriter pdfWriter = new PdfWriter(file);
        final PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        final Document document = new Document(pdfDocument);
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
        // Zone E - PO
        //
        table.addCell(createPurchaseOrderDetail(slc));
        //
        // Zone F - UPC
        //
        final Cell upcCell = new Cell();
        upcCell.add("UPC");
        table.addCell(upcCell);
        //
        // Zone G - UPC
        //
        final Cell zoneGCell = new Cell();
        zoneGCell.add("G");
        table.addCell(zoneGCell);
        //
        // Zone H - SSCC
        //
        table.addCell(createSSCC(pdfDocument, slc.getSSCC()));
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
        shipToPostalCodeCell.add("Ship To Postal Code:");

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
        carrierCell.add("Carrier:");
        carrierCell.add(carrier.getCarrierName());
        final String proInvoice = carrier.getProInvoice_REF_CN();
        if (isPresent(proInvoice)) {
            carrierCell.add("PRO: " + proInvoice);
        }
        final String billOfLading = carrier.getBillOfLading_REF_BM();
        if (isPresent(billOfLading)) {
            carrierCell.add("B/L: " + billOfLading);
        }
        return carrierCell;
    }

    private Cell createPurchaseOrderDetail(ShippingLabelContent slc) {
        final Cell poCell = new Cell(1, 2);
        poCell.add("PO# " + slc.getPurchaseOrderNumber());
        return poCell;
    }

    private Cell createSSCC(PdfDocument inPdfDocument, String sscc) {
        final Cell ssccCell = new Cell(1, 2);
        final Paragraph paragraph = new Paragraph("SSCC-18");
        paragraph.setFontSize(FONT_SIZE);
        ssccCell.add(paragraph);
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
        cell.add(title + ":");
        cell.add(new Paragraph(party.getName_N102()).setFontSize(FONT_SIZE));
        final String addressLine1 = party.getAddressLine1_N301();
        if (isPresent(addressLine1)) {
            cell.add(new Paragraph(addressLine1).setFontSize(FONT_SIZE));
            final String addressLine2 = party.getAddressLine2_N302();
            if (isPresent(addressLine2)) {
                cell.add(new Paragraph(addressLine2).setFontSize(FONT_SIZE));
            }
        }
        cell.add(new Paragraph(party.getCityStateZip()).setFontSize(FONT_SIZE));
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
