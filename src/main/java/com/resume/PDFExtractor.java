package com.resume;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFExtractor {

    public static String extractText(String filePath) {

        try {
            File file = new File(filePath);

            PDDocument document = Loader.loadPDF(file);

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text =
                    stripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}







