
package utilities;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

    private static final Path EXCEL_PATH = Paths.get(
        "src", "test", "java", "testData", "TestData.xlsx"
    );

    private static final String SHEET_NAME = "TestData";

    public static synchronized void writeData(
            String key, String value) {

        try {
            if (!Files.exists(EXCEL_PATH)) {
                throw new IllegalStateException(
                    "Excel file not found: " + EXCEL_PATH.toAbsolutePath()
                );
            }

            try (InputStream input =
                     Files.newInputStream(EXCEL_PATH);
                 Workbook workbook =
                     WorkbookFactory.create(input)) {

                Sheet sheet = workbook.getSheet(SHEET_NAME);

                if (sheet == null) {
                    throw new IllegalStateException(
                        "Sheet not found: " + SHEET_NAME
                    );
                }

                int rowIndex = -1;

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);

                    if (row != null && row.getCell(0) != null) {
                        String existingKey =
                            new DataFormatter().formatCellValue(
                                row.getCell(0)
                            ).trim();

                        if (existingKey.equalsIgnoreCase(key)) {
                            rowIndex = i;
                            break;
                        }
                    }
                }

                if (rowIndex == -1) {
                    rowIndex = sheet.getLastRowNum() + 1;
                }

                Row row = sheet.getRow(rowIndex);

                if (row == null) {
                    row = sheet.createRow(rowIndex);
                }

                Cell keyCell = row.getCell(0);

                if (keyCell == null) {
                    keyCell = row.createCell(0);
                }

                keyCell.setCellValue(key);

                Cell valueCell = row.getCell(1);

                if (valueCell == null) {
                    valueCell = row.createCell(1);
                }

                valueCell.setCellValue(value);

                // Close input before reopening the file for writing.
                // The workbook must be written before it is closed.
                try (OutputStream output =
                         Files.newOutputStream(EXCEL_PATH)) {
                    workbook.write(output);
                }
            }

            System.out.println(
                "Excel updated: " + key + " = " + value
            );

        } catch (Exception e) {
            throw new RuntimeException(
                "Failed to write Excel data for key: " + key, e
            );
        }
    }

    public static synchronized String readData(String key) {

        try (InputStream input =
                 Files.newInputStream(EXCEL_PATH);
             Workbook workbook =
                 WorkbookFactory.create(input)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);

            if (sheet == null) {
                throw new IllegalStateException(
                    "Sheet not found: " + SHEET_NAME
                );
            }

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null || row.getCell(0) == null) {
                    continue;
                }

                String existingKey =
                    formatter.formatCellValue(row.getCell(0)).trim();

                if (existingKey.equalsIgnoreCase(key)) {
                    Cell valueCell = row.getCell(1);

                    return valueCell == null
                        ? ""
                        : formatter.formatCellValue(valueCell).trim();
                }
            }

            throw new IllegalStateException(
                "Key not found in Excel: " + key
            );

        } catch (Exception e) {
            throw new RuntimeException(
                "Failed to read Excel data for key: " + key, e
            );
        }
    }
}
