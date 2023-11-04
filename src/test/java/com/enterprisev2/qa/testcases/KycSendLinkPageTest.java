package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.DashboardPage;
import com.enterprisev2.qa.pages.KycBasicDetailsPage;
import com.enterprisev2.qa.pages.KycSendLinkPage;
import com.enterprisev2.qa.pages.LoginPage;
import com.enterprisev2.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Base64;

public class KycSendLinkPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    KycSendLinkPage kycSendLinkPage;


    public KycSendLinkPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initalization();
        testUtil= new TestUtil(); // to user switch frame in future
        kycSendLinkPage = new  KycSendLinkPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
        kycSendLinkPage = dashboardPage.clickonalluserkyc();
    }

    @Test(priority = 1)
    public void enternameandemail(){
        kycSendLinkPage.fillkyclinkform("user 1" , "user1@gmail.com");
        Assert.assertTrue(true);
        testUtil.pagerefresh();


    }
    @Test(priority = 2)
    public KycBasicDetailsPage copyandopenlink1(){
        kycSendLinkPage.copyandopenlink();
        return new KycBasicDetailsPage();


    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
