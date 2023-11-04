package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.*;
import com.enterprisev2.qa.util.ExcelUtil;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AddPayeePageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ManagePayeesListPage managePayeesListPage;
    AddPayeePage addPayeePage;

    TestUtil testUtil = new TestUtil();
    ExcelUtil excelUtil = new ExcelUtil();
    String sheetName = "PayeeData";
    public AddPayeePageTest(){
        super();
    }
    @BeforeClass
    public void setUp() throws InterruptedException {
        initalization();
        testUtil= new TestUtil(); // to user switch frame in future
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
        addPayeePage  = dashboardPage.clickonaddpayeelink();
    }
    @Test(priority = 1)
    public void validatesection(){
        addPayeePage.validate_elements();
    }
    @Test(priority = 2)
    public  void getelement() {
        List<WebElement> elements = addPayeePage.getpayeefields();
        System.out.println("number of elements: " + elements.size());

        List<String> elementsmatched = Arrays.asList("Account Holder's Name*","Email*","Mobile Number*","Account Number*","IFSC Code*","Bank Name*","Bank Branch","Cancelled Cheque");
        boolean payee_elemets =  elements.stream().map(WebElement::getText).
                anyMatch(elementsmatched::contains);
        System.out.println(payee_elemets);
        if(payee_elemets) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }


        }
    @Test(priority = 3)
    public String enterbasicdetails(){
        int mobile_number = testUtil.generateRandomNumber(10);
        String user = TestUtil.generateRandomName().toString();
        addPayeePage.enterpayeebasicdetails(user,"user1@gmail.com", String.valueOf(mobile_number));
        return user;
    }
    @Test(priority =4)
    public void enterbankdetails(){
        int account_number = testUtil.generateRandomNumber(7);
        addPayeePage.enterpayeebankdetails(String.valueOf(account_number),"ICIC0005433", "ICICI", "Delhi");
    }
    @Test(priority = 5)
    public void uploadcheque(){
        addPayeePage.uploadcancelcheque();
    }

    @DataProvider
    public Object[][] getTestpayeedata(){
        Object data[][] = ExcelUtil.getTestData(sheetName);
        return data;

    }
    @Test(priority = 6)
    public void clicksavebutton() throws InterruptedException {
        addPayeePage.clicksavebutton();
        Thread.sleep(2000);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
