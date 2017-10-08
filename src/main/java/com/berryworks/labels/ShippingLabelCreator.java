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

public class ShippingLabelCreator {
    public static final String PDF_FILENAME = "temp.pdf";
    public static final float FONT_SIZE = 8.0f;

    public File createLabel(ShippingLabelContent slc) throws IOException {
        final File file = new File(PDF_FILENAME);
        final PdfWriter pdfWriter = new PdfWriter(file);
        final PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        final Document document = new Document(pdfDocument);
        Table table = new Table(2);
        table.addCell("From");
        //
        // Zone B - Ship To (readable)
        //
        table.addCell(createShipToText(slc));
        //
        // Zone C - Ship To: postal code as barcode
        //
        table.addCell(createShipToPostalBarcode(pdfDocument, slc.getShipTo()));
        //
        // Zone D - Carrier
        //
        final Cell carrierCell = new Cell();
        carrierCell.add("Carrier");
        table.addCell(carrierCell);
        //
        // Zone E - PO
        //
        final Cell poCell = new Cell(1, 2);
        poCell.add("PO");
        table.addCell(poCell);
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

    private Cell createShipToPostalBarcode(PdfDocument pdfDocument, PartyIdentification shipTo) {
        final Cell shipToPostalCodeCell = new Cell();
        shipToPostalCodeCell.add("Ship To Postal Code:");

        final Barcode128 barCode = new Barcode128(pdfDocument);
        final String postalCode = shipTo.getPostalCode_N403();
        barCode.setCode(postalCode);
        barCode.setAltText(displayPostalCode(postalCode));
        final Image image = new Image(barCode.createFormXObject(null, null, pdfDocument));
        image.setHorizontalAlignment(HorizontalAlignment.CENTER);
        shipToPostalCodeCell.add(image);

        return shipToPostalCodeCell;
    }

    private Cell createShipToText(ShippingLabelContent slc) {
        final Cell shipToClearText = new Cell();
        shipToClearText.add("TO:");
        final PartyIdentification shipTo = slc.getShipTo();
        shipToClearText.add(new Paragraph(shipTo.getName_N102()).setFontSize(FONT_SIZE));
        shipToClearText.add(new Paragraph(shipTo.getCityStateZip()).setFontSize(FONT_SIZE));
        return shipToClearText;
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

    private String displayPostalCode(String postalCode) {
        if (postalCode == null || postalCode.length() == 0) return null;
        if (postalCode.length() == 9) {
            return postalCode.substring(0, 5) + "-" + postalCode.substring(5);
        } else {
            return postalCode;
        }
    }

    private String displaySSCC(String sscc) {
        if (sscc == null || sscc.length() != 20) return sscc;
        //  (00) 1 2345678 901234567 8
        //   +   + +       +         +
        //   0   2 3       10        19   index of sub-field
        //
        StringBuilder sb = new StringBuilder("(");
        sb.append(sscc.substring(0, 2)).append(") ");
        sb.append(sscc.substring(2, 3)).append(" ");
        sb.append(sscc.substring(3, 10)).append(" ");
        sb.append(sscc.substring(10, 19)).append(" ");
        sb.append(sscc.substring(19, 20));
        return sb.toString();
    }
}
