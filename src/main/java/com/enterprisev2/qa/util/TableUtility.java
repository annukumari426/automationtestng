package com.enterprisev2.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.enterprisev2.qa.base.TestBase.driver;

public class TableUtility {

//    public static List<List<String>> extractTableValues(By tableLocator) {
//        List<List<String>> tableData = new ArrayList<>();
//
//        WebElement table = driver.findElement(tableLocator);
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//        for (WebElement row : rows) {
//            List<WebElement> columns = row.findElements(By.tagName("td"));
//            List<String> rowData = new ArrayList<>();
//
//            for (WebElement column : columns) {
//                rowData.add(column.getText());
//            }
//
//            tableData.add(rowData);
//        }

    //        return tableData;
//    }
    public static String getTableRow(WebElement tableLocator, int row) {
        WebElement table = driver.findElement(By.xpath(String.valueOf(tableLocator)));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (row >= 0 && row < rows.size()) {
            List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
            return extractColumnText(columns).toString();
        } else {
            return String.valueOf(new ArrayList<>()); // Return an empty list if the row number is invalid
        }
    }

    public static List<String> getTableColumn(By tableLocator, int columnNumber) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<String> columnValues = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columnNumber >= 0 && columnNumber < columns.size()) {
                columnValues.add(columns.get(columnNumber).getText());
            }
        }
        return columnValues;
    }

    private static List<String> extractColumnText(List<WebElement> columns) {
        List<String> columnTexts = new ArrayList<>();
        for (WebElement column : columns) {
            columnTexts.add(column.getText());
        }
        return columnTexts;
    }
}
//    List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//    if (row >= 0 && row < rows.size()) {
//        List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
//
//        if (column >= 0 && column < columns.size()) {
//            return columns.get(column).getText();
//        }
//        else {
//            return "Invalid column index";
//        }
//    } else {
//        return "Invalid row index";
//    }
//}



