package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class CargarPdfEnNuevo {

    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\Users\\dchirinos\\Documents\\proyectos de spring boot\\Itextprueba\\Hello World");
        PDDocument document = PDDocument.load(oldFile);
        document.addPage(new PDPage());

        document.save("C:\\Users\\dchirinos\\Documents\\PDFs\\mypdf.pdf");
        System.out.println("pdf creado");
        document.close();
    }
}
