package com.resume;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private static final String URL =
            "jdbc:mysql://localhost:3306/resume_screening";

    private static final String USER = "root";

    private static final String PASSWORD = "root123";

    public static Connection getConnection()
            throws Exception {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD);
    }
}