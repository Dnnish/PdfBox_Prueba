package org.example;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class separcionPDF {
    public static void main(String[] args) throws IOException {

        File oldFile = new File("C:\\Users\\dchirinos\\Documents\\PDFs\\manual.pdf");
        PDDocument document = PDDocument.load(oldFile);

        Splitter splitter = new Splitter();

        List<PDDocument> splitPages = splitter.split(document);

        int num=1;
        for(PDDocument mydoc: splitPages)
        {
            mydoc.save("C:\\Users\\dchirinos\\Documents\\PDFs\\extract\\split_0"+num+".pdf");
            num++;
            mydoc.close();
        }
        System.out.println("Separacion hecha");
    }
}
