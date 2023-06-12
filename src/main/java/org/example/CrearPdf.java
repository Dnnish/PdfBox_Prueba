package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class CrearPdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

        document.save("C:\\Users\\dchirinos\\Documents\\PDFs\\mypdf.pdf");
        System.out.println("PDF creado");
        document.close();
    }
}