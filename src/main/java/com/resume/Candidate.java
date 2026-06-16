package com.resume;

public class Candidate {
 


    private String name;
    private String email;
    private String resumePath;
    private double score;
    private String analysis;

    public Candidate(String name,
                     String email,
                     String resumePath,
                     double score,
                     String analysis) {

        this.name = name;
        this.email = email;
        this.resumePath = resumePath;
        this.score = score;
        this.analysis = analysis;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getResumePath() {
        return resumePath;
    }

    public double getScore() {
        return score;
    }

    public String getAnalysis() {
        return analysis;
    }
}






