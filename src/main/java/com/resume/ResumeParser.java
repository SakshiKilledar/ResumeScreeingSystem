package com.resume;

public class ResumeParser {

    public static String parseResume(
            String filePath) {

        return PDFExtractor.extractText(filePath);
    }
}