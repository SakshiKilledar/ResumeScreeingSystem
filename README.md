# AI Resume Screening System

## Project Overview

AI Resume Screening System is a Java-based desktop application that helps recruiters and placement coordinators analyze resumes, score candidates based on required skills, rank applicants, and generate reports.

The system extracts text from PDF resumes, matches keywords, calculates scores, stores candidate information in MySQL, and generates Excel reports.

---

## Features

### Resume Management
- Upload PDF Resume
- Extract Resume Text
- Analyze Candidate Skills

### Candidate Analysis
- Keyword Matching
- Resume Score Generation
- Candidate Classification
  - Excellent Candidate
  - Good Candidate
  - Needs Improvement

### Database Integration
- Store Candidate Information in MySQL
- Retrieve Candidate Records

### Reporting
- Generate Excel Report (.xlsx)
- View Candidate Rankings

### AI Integration
- ChatGPT/OpenAI API Integration (Optional)
- AI-Based Resume Analysis

---

## Technologies Used

### Frontend
- Java Swing

### Backend
- Java

### Database
- MySQL

### Libraries
- Apache PDFBox
- Apache POI
- MySQL Connector/J

### Build Tool
- Maven

---


ResumeScreeningSystem
│
├── reports
│ └── CandidateReport.xlsx
│
├── resume
│ └── sample_resume.pdf
│
├── src
│ └── main
│ └── java
│ └── com
│ └── resume
│ ├── Candidate.java
│ ├── CandidateDAO.java
│ ├── DatabaseManager.java
│ ├── PDFExtractor.java
│ ├── ResumeParser.java
│ ├── ResumeScorer.java
│ ├── ExcelReportGenerator.java
│ ├── ResumeScreeningGUI.java
│ ├── RankingWindow.java
│ └── ChatGPTAnalyzer.java
│
└── pom.xml


---

## Database Setup

Create Database:

```sql
CREATE DATABASE resume_screening;

USE resume_screening;

CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    score DOUBLE,
    analysis VARCHAR(255)
);




Candidate Name: Rahul Sharma

Email: rahul@gmail.com

Score: 80%

Matched Skills:
✔ Java
✔ SQL
✔ HTML

Missing Skills:
✘ Spring Boot

Overall Result:
Excellent Candidate

## Project Structure
