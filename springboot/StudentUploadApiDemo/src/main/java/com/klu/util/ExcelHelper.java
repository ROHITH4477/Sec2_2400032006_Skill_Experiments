package com.klu.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.klu.model.Student;

public class ExcelHelper {
  // ==============================
    // 1. Excel → List<Student>
    // ==============================
    public static List<Student> convertExcelToList(InputStream is) {
      //creating empty list to store Student records
        List<Student> list = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue; // Skip header

                Student s = new Student();
                s.setName(row.getCell(0).getStringCellValue());
                s.setEmail(row.getCell(1).getStringCellValue());
                s.setCourse(row.getCell(2).getStringCellValue());
                s.setBranch(row.getCell(3).getStringCellValue());
                s.setFees(row.getCell(4).getNumericCellValue());

                list.add(s);
            }

        } catch (Exception e) {
            throw new RuntimeException("Fail to parse Excel file");
        }

        return list;
    }
    
    // ==============================
    // 2. List<Student> → Excel
    // ==============================
    public static ByteArrayInputStream studentsToExcel(List<Student> students) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Students");

            // Header Row
            Row headerRow = sheet.createRow(0);

            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Course");
            headerRow.createCell(4).setCellValue("Branch");
            headerRow.createCell(5).setCellValue("Fees");

            int rowIdx = 1;

            for (Student s : students) {

                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(s.getId());
                row.createCell(1).setCellValue(s.getName());
                row.createCell(2).setCellValue(s.getEmail());
                row.createCell(3).setCellValue(s.getCourse());
                row.createCell(4).setCellValue(s.getBranch());
                row.createCell(5).setCellValue(s.getFees());
            }

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Failed to export data to Excel file");
        }
    }
}