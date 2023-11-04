package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.DashboardPage;
import com.enterprisev2.qa.pages.KycSendLinkPage;
import com.enterprisev2.qa.pages.LoginPage;
import com.enterprisev2.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    KycSendLinkPage kycSendLinkPage;


    public DashboardPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initalization();
        testUtil= new TestUtil(); // to user switch frame in future
        kycSendLinkPage = new  KycSendLinkPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
    }
    @Test(priority = 1)
    public void verifyDashboardPageTest(){

        String dashboardpagetitle = dashboardPage.verifyDashboardPageTitle();
        Assert.assertEquals(dashboardpagetitle, "Castler" , "Home Page title not matched");
    }
    @Test(priority = 2)
    public void verifyDashboardTextTest(){
        String dashboardtext = dashboardPage.dashboardTextpresent();
        Assert.assertEquals(dashboardtext, "Dashboard" , "Dashboard Text not present");
    }
    @Test(priority = 3)
    public void verifyallUserKycLinkTest(){

        kycSendLinkPage = dashboardPage.clickonalluserkyc();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
