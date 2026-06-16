package com.resume;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CandidateDAO {

    public static void saveCandidate(
            String name,
            String email,
            double score,
            String analysis) {

        try {

            Connection con =
                    DatabaseManager.getConnection();

            String sql =
                    "INSERT INTO candidates(name,email,score,analysis) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, score);
            ps.setString(4, analysis);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}