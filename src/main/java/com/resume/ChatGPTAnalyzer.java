package com.resume;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatGPTAnalyzer {

    private static final String API_KEY = "YOUR_OPENAI_API_KEY";

    public static String analyzeResume(
            String resumeText) {

        try {

            String prompt =
                    "Analyze this resume and provide:"
                    + "\n1. Candidate Summary"
                    + "\n2. Strengths"
                    + "\n3. Weaknesses"
                    + "\n4. Job Suitability\n\n"
                    + resumeText;

            String body = """
            {
              "model":"gpt-4.1-mini",
              "input":"%s"
            }
            """.formatted(
                    prompt.replace("\"", "\\\""));

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://api.openai.com/v1/responses"))
                            .header(
                                    "Authorization",
                                    "Bearer " + API_KEY)
                            .header(
                                    "Content-Type",
                                    "application/json")
                            .POST(
                                    HttpRequest.BodyPublishers
                                            .ofString(body))
                            .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient()
                            .send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {

            return "ChatGPT Analysis Failed : "
                    + e.getMessage();
        }
    }
}