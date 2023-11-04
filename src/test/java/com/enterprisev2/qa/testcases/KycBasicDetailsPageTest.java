package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.*;
import com.enterprisev2.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class KycBasicDetailsPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    KycSendLinkPage kycSendLinkPage;

    KycBasicDetailsPage kycBasicDetailsPage;
    KycBusinessProfileDetailsPage kycBusinessProfileDetailsPage;


    public KycBasicDetailsPageTest() {
        super();
    }
    @BeforeClass
    public void setUp() throws InterruptedException {
        initalization();
        testUtil= new TestUtil(); // to user switch frame in future
        kycSendLinkPage = new  KycSendLinkPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
        kycSendLinkPage = dashboardPage.clickonalluserkyc();
        kycBasicDetailsPage = kycSendLinkPage.copyandopenlink();

    }
    @Test(priority = 1)
    public void entermobilenumberandclickcontinuebutton() throws InterruptedException {
        kycBasicDetailsPage.entermobile("9090909090");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public  void clickcontinuebutton() {
        kycBasicDetailsPage.clickcontinue();
    }

    @Test(priority = 3)
    public  void enterOTP() throws InterruptedException {
        kycBasicDetailsPage.enterotp();
        Thread.sleep(2000);
        clickcontinuebutton();

    }

    @Test(priority = 4)
    public void enternameandemail() {
         kycBasicDetailsPage.enterkycnameandemail("user1", "user1", "user@gmail.com");
        kycBasicDetailsPage.getenternameemail();

    }

    @Test(priority = 5)
    public void clickstartapplicationbutton() {
        kycBusinessProfileDetailsPage = kycBasicDetailsPage.clickstartapplicationbutton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
