package com.resume;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExcelReportGenerator {

    public static void generateReport() {

        try {

            Workbook workbook =
                    new XSSFWorkbook();

            Sheet sheet =
                    workbook.createSheet(
                            "Candidates");

            Row header =
                    sheet.createRow(0);

            header.createCell(0)
                    .setCellValue("Name");

            header.createCell(1)
                    .setCellValue("Email");

            header.createCell(2)
                    .setCellValue("Score");

            header.createCell(3)
                    .setCellValue("Analysis");

            Connection con =
                    DatabaseManager.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM candidates");

            int rowNum = 1;

            while(rs.next()) {

                Row row =
                        sheet.createRow(rowNum++);

                row.createCell(0)
                        .setCellValue(
                                rs.getString("name"));

                row.createCell(1)
                        .setCellValue(
                                rs.getString("email"));

                row.createCell(2)
                        .setCellValue(
                                rs.getDouble("score"));

                row.createCell(3)
                        .setCellValue(
                                rs.getString("analysis"));
            }

            FileOutputStream out =
                    new FileOutputStream(
                            "reports/CandidateReport.xlsx");

            workbook.write(out);

            out.close();
            workbook.close();

            System.out.println(
                    "Report Generated");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}