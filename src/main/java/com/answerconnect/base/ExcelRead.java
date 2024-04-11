package com.answerconnect.base;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelRead {
    private static final Logger logger = LoggerFactory.getLogger(ExcelRead.class);
    private static final String FILE_NAME = "AndroidSheet.xlsx";
    private static final Map<String, String> dataMap = new HashMap<>();

    static {
        loadExcelData();
    }

    private static void loadExcelData() {
        FileInputStream inputStream = null;
        Workbook workbook = null;
        try {
            inputStream = new FileInputStream(FILE_NAME);
            workbook = WorkbookFactory.create(inputStream);
            int sheetCount = workbook.getNumberOfSheets();
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
                for (int i = 0; i <= rowCount; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell keyCell = row.getCell(0);
                        Cell valueCell = row.getCell(1);
                        if (keyCell != null && valueCell != null) {
                            String key = keyCell.getStringCellValue();
                            String value;
                            if (valueCell.getCellType() == CellType.NUMERIC) {
                                DataFormatter formatter = new DataFormatter();
                                value = formatter.formatCellValue(valueCell);
                            } else {
                                value = valueCell.getStringCellValue();
                            }
                            dataMap.put(key, value);
                        }
                    }
                }
            }
        } catch (IOException | EncryptedDocumentException e) {
            logger.error("Error reading Excel file: {}", e.getMessage(), e);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("Error closing resources: {}", e.getMessage(), e);
            }
        }
    }

    public static String getData(String key) {
        String value = dataMap.get(key);
        if (value == null) {
            throw new RuntimeException("Key " + key + " is not found in any sheet");
        }
        return value;
    }
}
