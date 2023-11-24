package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.pages.*;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.enterprisev2.qa.base.TestBase.*;

public class AddLinkPayeePageTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddEscrowDescriptionPage addEscrowDescriptionPage;
    AddLinkPayeePage addLinkPayeePage;

    TestUtil testUtil = new TestUtil();

    public AddLinkPayeePageTest() {
        super();
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        initalization();


    }
    @Test(priority = 1)
    public void fillform() throws InterruptedException {
        testUtil = new TestUtil(); // to user switch frame in future
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("otp"));
        addEscrowDescriptionPage = dashboardPage.clickaddescrowdropdownvalue();
        addEscrowDescriptionPage.clickproceedbutton();
        String esname = testUtil.generateRandomName().toString();
        int esvolume = testUtil.generateRandomNumber(6);
        int evalidity = testUtil.generateRandomNumber(3);
        addEscrowDescriptionPage.enterescrowalldetails(esname, String.valueOf(esvolume), String.valueOf(evalidity), "user@gmail.com", "Test escrow");
        addEscrowDescriptionPage.selectCurrentDay();
        addLinkPayeePage = addEscrowDescriptionPage.clicknextbutton();
    }

    @Test(priority = 2)
    public void get_payee_fields() {

    List<WebElement> elements = addLinkPayeePage.payeefields();
    System.out.println("number of elements: "+elements.size());
    System.out.println("Elements are" + elements );
}
    @Test(priority = 3)
    public  void setAddLinkPayee() throws InterruptedException {
//        addLinkPayeePage.verifypayeefieldvalue();
        addLinkPayeePage.add_payee();

    }
    @Test(priority = 4)
    public void submitlinkpayee() throws InterruptedException {
        addLinkPayeePage.clicksavebutton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
