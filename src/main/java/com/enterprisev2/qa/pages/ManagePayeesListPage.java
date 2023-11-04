package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.util.TableUtility;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ManagePayeesListPage extends TestBase {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/table")
    public WebElement tablelocator;

    public ManagePayeesListPage() {
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this because it refer to this class
    }

    public String verifyManagePayeePageTitle() {
        return driver.getTitle();
    }

    public <rowData> String tabledata() {
        List<String> rowData = Collections.singletonList(TableUtility.getTableRow(tablelocator, 1));
        System.out.println("Row data: " + rowData);

        // Get column data from column 2
        List<String> columnData = Collections.singletonList(TableUtility.getTableColumn((By) tablelocator, 1).toString());
        System.out.println("Column data: " + columnData);
        Map<String, String> keyValuePairs = new HashMap<>();
        keyValuePairs.put(rowData.toString(), columnData.toString());

        return keyValuePairs.toString();
    }
}


