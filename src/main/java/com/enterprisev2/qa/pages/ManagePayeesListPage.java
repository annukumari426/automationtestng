package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.util.TableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;


public class ManagePayeesListPage extends TestBase {
    By locator = (By.xpath("//table[@class= \"chakra-table css-5605sr\"]"));
    public ManagePayeesListPage() {
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this because it refer to this class
    }

    public String verifyManagePayeePageTitle() {
        return driver.getTitle();
    }
    public List<String> get_table_headers(){
        List<String> headers = TableUtility.getTableHeaders(locator);
        return headers;

        // Print table headers

    }

    public List<String> tabledata() throws InterruptedException {
//        Thread.sleep(2000);
//        List<String> rowData = Collections.singletonList(TableUtility.getTableRow(tablelocator, 2));
//        System.out.println("Row data: " + rowData);
//
//        // Get column data from column 2
//        List<String> columnData = Collections.singletonList(TableUtility.getTableColumn((By) tablelocator, 1).toString());
//        System.out.println("Column data: " + columnData);
//        Map<String, String> keyValuePairs = new HashMap<>();
//        keyValuePairs.put(rowData.toString(), columnData.toString());
//
//        return keyValuePairs.toString();
        By locator = (By.xpath("//table[@class= \"chakra-table css-5605sr\"]"));
        int rowNumber = 1; // 0-based index
        List<String> rowData = TableUtility.getRowData(locator, rowNumber);

        // Print row data
        System.out.println("Row data for row " + (rowNumber + 1) + ": " + rowData);
        return rowData;
    }
    public List<String> column_data(){
        By locator = (By.xpath("//table[@class= \"chakra-table css-5605sr\"]"));
        int row = 1; // 0-based index
        int column = 0; // 0-based index
        String cellValue = TableUtility.getTableCellValue(locator, row, column);

        // Print cell value
        System.out.println("Cell value at row " + (row) + ", column " + (column) + ": " + cellValue);
        return Collections.singletonList(cellValue);
    }
}


