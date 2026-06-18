package com.resume;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RankingWindow extends JFrame {

    JTable table;

    public RankingWindow() {

        setTitle("Candidate Ranking");

        setSize(700, 400);

        setLocationRelativeTo(null);

        String[] columns = {
                "Name",
                "Email",
                "Score",
                "Analysis"
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0);

        table = new JTable(model);

        try {

            Connection con =
                    DatabaseManager.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM candidates ORDER BY score DESC");

            while (rs.next()) {

                model.addRow(
                        new Object[]{

                                rs.getString("name"),

                                rs.getString("email"),

                                rs.getDouble("score"),

                                rs.getString("analysis")
                        });
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        add(new JScrollPane(table));
    }
}