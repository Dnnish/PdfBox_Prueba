package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class añadirImagenes {
    public static void main(String[] args)throws IOException {
        //crear un documento de tipo de pdfbox
        PDDocument document = new PDDocument();
        // crear una pagina
        PDPage firstPage = new PDPage();
        // añadir la pagina en el documento
        document.addPage(firstPage);

        PDImageXObject image1 = PDImageXObject.createFromFile("C:\\Users\\dchirinos\\Documents\\PDFs\\posicionPDFbox.png",document);
        PDPageContentStream contentStream  = new PDPageContentStream(document, firstPage);
        contentStream.drawImage(image1, 25,25, 320,212);
        contentStream.close();

        //guardarlo en el pdf
        document.save("C:\\Users\\dchirinos\\Documents\\PDFs\\mypdf.pdf");
        System.out.println("PDF creado");
        document.close();
    }
}
