package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.*;
//import com.enterprisev2.qa.pages.ManagePayeesList;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

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
    public void get_table_headers(){

        List<String> payeelistheader =  managePayeesListPage.get_table_headers();
        System.out.println("Payee List Headers are" + payeelistheader);

        List<String> elementsmatched = Arrays.asList("PAYEE ID", "ACCOUNT HOLDER", "IFSC","ACCOUNT NUMBER","BANK" ,"ADDITION DATE");
        System.out.println("Payee List Headers need to be present" + elementsmatched);
        boolean payee_list_header_elements =  payeelistheader.equals(elementsmatched);
        System.out.println(payee_list_header_elements);
        if(payee_list_header_elements){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }


    }


    @Test(priority = 4)
    public  void getTabledata() throws InterruptedException {
        List<String> cell = managePayeesListPage.tabledata();
        for(String cells : cell){
            System.out.println("Row Value present as " + cells);

        }
        Assert.assertEquals(cell.get(1) ,"payee 17 nov new", "Payee Name Not Matched");

    }
    @Test(priority = 5)
    public void verifyPayeeIdformat() throws InterruptedException {
        Thread.sleep(2000);
        List payee_Id =  managePayeesListPage.column_data();
//        String regex = "PA";
        if(payee_Id.get(0).toString().startsWith("PY")){
            Assert.assertTrue(true);
            System.out.println("Payee ID start with PY");
        }
        else{
            System.out.println("PY is not prefix");
        }
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

