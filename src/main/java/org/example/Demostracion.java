package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class Demostracion {
    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

        PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN,18);
        contentStream.setLeading(16.0f);

        contentStream.newLineAtOffset(25, firstPage.getTrimBox().getHeight()-25);

        String text1 = "Hola Quinxiu";
        String text2 = "he puesto la contraseña";
        String text3 = "y una imagen: ";

        //texto
        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText(text3);

        contentStream.endText();
        //imagen
        PDImageXObject image1 = PDImageXObject.createFromFile("C:\\Users\\dchirinos\\Documents\\PDFs\\posicionPDFbox.png",document);
        contentStream.drawImage(image1, 25,25, 320,212);


        contentStream.close();


        // longitud de la contraseña
        final int KeyLength = 128;
        // Establecer los permisos del pdf
        AccessPermission accessPermission = new AccessPermission();
        // no dejar escribir
        accessPermission.setCanPrint(false);
        // no permite modificar
        accessPermission.setCanModify(false);
        // poner contraseñas dependiendo del usuario y la funcion de la contraseña
        StandardProtectionPolicy sp = new StandardProtectionPolicy("1124","Dennis",accessPermission);
        //establecer un limite para las contraseñas
        sp.setEncryptionKeyLength(KeyLength);
        // darle acceso al pdf
        sp.setPermissions(accessPermission);
        // establecerlo al pdf
        document.protect(sp);

        document.save("C:\\Users\\dchirinos\\Documents\\PDFs\\PDFCompletado.pdf");
        System.out.println("PDF creado");
        document.close();
    }
}
