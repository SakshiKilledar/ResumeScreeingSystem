package com.resume;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ResumeScreeningGUI extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField fileField;

    private JTextArea resultArea;

    private String selectedFile = "";

    public ResumeScreeningGUI() {

        setTitle("AI Resume Screening System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("AI Resume Screening System");
        title.setBounds(220, 10, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel nameLabel = new JLabel("Candidate Name:");
        nameLabel.setBounds(30, 60, 120, 25);

        nameField = new JTextField();
        nameField.setBounds(160, 60, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 100, 120, 25);

        emailField = new JTextField();
        emailField.setBounds(160, 100, 200, 25);

        JLabel fileLabel = new JLabel("Resume:");
        fileLabel.setBounds(30, 140, 120, 25);

        fileField = new JTextField();
        fileField.setBounds(160, 140, 300, 25);
        fileField.setEditable(false);

        JButton browseButton = new JButton("Browse PDF");
        browseButton.setBounds(480, 140, 120, 25);

        browseButton.addActionListener(e -> chooseFile());

        JButton analyzeButton = new JButton("Analyze Resume");
        analyzeButton.setBounds(250, 190, 180, 35);

        

        JButton reportButton =
        new JButton("Generate Report");

        reportButton.setBounds(
        450,
        190,
        160,
        35);

        reportButton.addActionListener(e -> {

            ExcelReportGenerator.generateReport();

            JOptionPane.showMessageDialog(
            this,
            "Excel Report Generated Successfully!");
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(resultArea);

        scrollPane.setBounds(30, 250, 620, 180);

        panel.add(title);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(fileLabel);
        panel.add(fileField);
        panel.add(browseButton);
        panel.add(analyzeButton);
        panel.add(reportButton);
        panel.add(scrollPane);

        add(panel);
    }

    private void chooseFile() {

        JFileChooser chooser =
                new JFileChooser();

        int result =
                chooser.showOpenDialog(this);

        if (result ==
                JFileChooser.APPROVE_OPTION) {

            File file =
                    chooser.getSelectedFile();

            selectedFile =
                    file.getAbsolutePath();

            fileField.setText(selectedFile);
        }
    }

    private void analyzeResume() {

        try {

            if (selectedFile.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a PDF Resume");

                return;
            }

            String resumeText =
                    ResumeParser.parseResume(
                            selectedFile);

            double score =
                    ResumeScorer.calculateScore(
                            resumeText);

            String analysis;

if (score >= 80) {
    analysis = "Excellent Candidate";
}
else if (score >= 60) {
    analysis = "Good Candidate";
}
else {
    analysis = "Needs Improvement";
}

CandidateDAO.saveCandidate(
        nameField.getText(),
        emailField.getText(),
        score,
        analysis
);



            StringBuilder output =
                    new StringBuilder();

            output.append(
                    "Candidate Name: ")
                    .append(nameField.getText())
                    .append("\n\n");

            output.append(
                    "Email: ")
                    .append(emailField.getText())
                    .append("\n\n");

            output.append(
                    "Score: ")
                    .append(score)
                    .append("%\n\n");

            output.append(
                    "Matched Skills:\n");

            for (String skill :
                    ResumeScorer.getMatchedSkills(
                            resumeText)) {

                output.append("✔ ")
                        .append(skill)
                        .append("\n");
            }

            output.append(
                    "\nMissing Skills:\n");

            for (String skill :
                    ResumeScorer.getMissingSkills(
                            resumeText)) {

                output.append("✘ ")
                        .append(skill)
                        .append("\n");
            }

            output.append(
                    "\nAI Analysis:\n");

            if (score >= 80) {

                output.append(
                        "Excellent candidate. Highly suitable.");
            }
            else if (score >= 60) {

                output.append(
                        "Good candidate. Minor improvements required.");
            }
            else {

                output.append(
                        "Needs additional skills and training.");
            }

            resultArea.setText(
                    output.toString());

        }
        catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new ResumeScreeningGUI()
                    .setVisible(true);

        });
    }
}