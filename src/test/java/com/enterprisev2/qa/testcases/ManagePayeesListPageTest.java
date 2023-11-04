package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.*;
//import com.enterprisev2.qa.pages.ManagePayeesList;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.enterprisev2.qa.base.TestBase.*;

public class ManagePayeesListPageTest extends TestBase {

    LoginPage loginPage;
    TestUtil testUtil;
    DashboardPage dashboardPage;
    AddPayeePage addPayeePage;
    ManagePayeesListPage managePayeesListPage;
    AddPayeePageTest addPayeePageTest;

    public ManagePayeesListPageTest(){
        super();
    }
    @BeforeClass
    public  void setUp() throws InterruptedException {
        initalization();
        testUtil = new TestUtil(); // to user switch frame in future
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
        managePayeesListPage = dashboardPage.clickonmanagepayeelist();


    }
//    @Test(priority = 1)
//    public void enterpayeedetails(){
//        int mobile_number = testUtil.generateRandomNumber(10);
//        String user = TestUtil.generateRandomName().toString();
//        addPayeePage.enterpayeebasicdetails(user,"user1@gmail.com", String.valueOf(mobile_number));
//        int account_number = testUtil.generateRandomNumber(7);
//        addPayeePage.enterpayeebankdetails(String.valueOf(account_number),"ICIC0005433", "ICICI", "Delhi");
//        addPayeePage.uploadcancelcheque();
//        managePayeesListPage = dashboardPage.clickonmanagepayeelist();
//    }

    @Test(priority = 2)
    public  void verifymanagepayeepagetitle() throws InterruptedException {
        managePayeesListPage.verifyManagePayeePageTitle();


    }
    @Test(priority = 3)
    public  void getTabledata(){
        String cell = managePayeesListPage.tabledata();
        Assert.assertEquals(cell , addPayeePageTest.enterbasicdetails(), "Payee Name Not Matched");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

