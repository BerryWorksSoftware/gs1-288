package com.berryworks.labels;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShippingLabelCreator {

    public static final String PDF_FILENAME = "temp.pdf";

    public File createLabel(String xml) throws IOException, DocumentException {

        // 1. Create document
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // 2. Create PdfWriter
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PDF_FILENAME));

        // 3. Open document
        document.open();

        // 4. Add content
        Barcode barcode;
        Image code128Image;
        PdfContentByte cb;

        barcode = new Barcode128();
        barcode.setCode("011012345678902");
        barcode.setAltText("1st 128 (01) 10 1234567890 2");
        barcode.setCodeType(Barcode.CODE128);
        cb = writer.getDirectContent();
        code128Image = barcode.createImageWithBarcode(cb, null, null);
        document.add(code128Image);

        barcode = new Barcode128();
        barcode.setCode("011012345678902");
        barcode.setAltText("2nd 128 (01) 10 1234567890 2");
        barcode.setCodeType(Barcode.CODE128);
        cb = writer.getDirectContent();
        code128Image = barcode.createImageWithBarcode(cb, null, null);
        document.add(code128Image);

        barcode = new Barcode128();
        barcode.setCode("011012345678913");
        barcode.setAltText("3rd 128 (01) 10 1234567891 3");
        barcode.setCodeType(Barcode.CODE128);
        cb = writer.getDirectContent();
        code128Image = barcode.createImageWithBarcode(cb, null, null);
        document.add(code128Image);

        barcode = new BarcodeInter25();
        barcode.setCode("10012345678902");
        barcode.setAltText("4th i25 10 1234567890 2");
        barcode.setCodeType(Barcode.CODE128);
        cb = writer.getDirectContent();
        code128Image = barcode.createImageWithBarcode(cb, null, null);
        document.add(code128Image);


        // 5. Close document
        document.close();

        File result = new File("temp.pdf");
        return result;
    }
}
