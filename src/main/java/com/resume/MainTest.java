package com.resume;

import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        String filePath =
                "resumes/sample_resume.pdf";

        String resumeText =
                ResumeParser.parseResume(filePath);

        double score =
                ResumeScorer.calculateScore(
                        resumeText);

        List<String> matched =
                ResumeScorer.getMatchedSkills(
                        resumeText);

        List<String> missing =
                ResumeScorer.getMissingSkills(
                        resumeText);

        System.out.println(
                "===== Resume Analysis =====");

        System.out.println(
                "\nScore : " + score + "%");

        System.out.println(
                "\nMatched Skills:");

        matched.forEach(System.out::println);

        System.out.println(
                "\nMissing Skills:");

        missing.forEach(System.out::println);
    }
}
