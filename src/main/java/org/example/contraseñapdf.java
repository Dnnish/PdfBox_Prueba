package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class contraseñapdf {
    public static void main(String[] args)throws IOException{
        //crear un documento de tipo de pdfbox
        PDDocument document = new PDDocument();
        // crear una pagina
        PDPage firstPage = new PDPage();
        // añadir la pagina en el documento
        document.addPage(firstPage);

        PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN,18);
        contentStream.setLeading(16.0f);

        contentStream.newLineAtOffset(25, firstPage.getTrimBox().getHeight()-25);

        String text1 = "this is firts line";
        String text2= "segunda linea";
        String text3 = "tercera linea";

        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText(text3);

        contentStream.endText();
        contentStream.close();

        // Cambiarle la informacion del pdf
        PDDocumentInformation docInfo = document.getDocumentInformation();

        docInfo.setAuthor("Dennis");
        docInfo.setTitle("lol");
        docInfo.setCreator("Apache PDFBox");
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
        //guardarlo en el pdf
        document.save("C:\\Users\\dchirinos\\Documents\\PDFs\\mypdf.pdf");
        System.out.println("PDF creado");
        document.close();
    }
}
