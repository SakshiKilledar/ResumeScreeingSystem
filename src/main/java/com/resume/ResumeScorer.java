package com.resume;

import java.util.ArrayList;
import java.util.List;

public class ResumeScorer {

    private static final String[] REQUIRED_SKILLS = {
            "Java",
            "Spring Boot",
            "MySQL",
            "HTML",
            "CSS",
            "JavaScript"
    };

    public static double calculateScore(String resumeText) {

        int matched = 0;

        for (String skill : REQUIRED_SKILLS) {

            if (resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                matched++;
            }
        }

        return ((double) matched /
                REQUIRED_SKILLS.length) * 100;
    }

    public static List<String> getMatchedSkills(
            String resumeText) {

        List<String> matched =
                new ArrayList<>();

        for (String skill : REQUIRED_SKILLS) {

            if (resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                matched.add(skill);
            }
        }

        return matched;
    }

    public static List<String> getMissingSkills(
            String resumeText) {

        List<String> missing =
                new ArrayList<>();

        for (String skill : REQUIRED_SKILLS) {

            if (!resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                missing.add(skill);
            }
        }

        return missing;
    }
}