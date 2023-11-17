package com.example.springbootdownloadexcel.utils;

import com.example.springbootdownloadexcel.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Data
@AllArgsConstructor
public class ExcelUtils {

    public static    String HEADER[] = {
            "id","name","surname","age","phone"
    };

    public  static  String SHEET_NAME = "Student Excel";

    public  static ByteArrayInputStream dataToExcel(List<Student> studentList) throws IOException {

        Workbook workbook =  new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        Sheet sheet = workbook.createSheet(SHEET_NAME);
        Row row = sheet.createRow(0);
        for(int i = 0 ; i< HEADER.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(HEADER[i]);
        }
         int rowIndex = 1;
        for(Student stu :studentList){
            Row row1 = sheet.createRow(rowIndex);
            rowIndex++;
            row1.createCell(0).setCellValue(stu.getId());
            row1.createCell(1).setCellValue(stu.getName());
            row1.createCell(2).setCellValue(stu.getSurname());
            row1.createCell(3).setCellValue(stu.getAge());
            row1.createCell(4).setCellValue(stu.getPhone());
        }

             workbook.write(byteArrayOutputStream);
             return  new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
         }
         catch (IOException e){
             throw  new RuntimeException();
         }
         finally {
             workbook.close();
             byteArrayOutputStream.close();
         }

    }

}
