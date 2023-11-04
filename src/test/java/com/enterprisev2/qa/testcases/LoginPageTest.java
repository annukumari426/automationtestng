package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.base.TestBase;
import com.enterprisev2.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
//    For calling base class constructor to initalize properties
    LoginPage loginPage;
    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public  void setUp() {
        initalization();
        loginPage = new LoginPage();
    }
    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginTitle();
        Assert.assertEquals(title ,"Castler");
    }
    @Test(priority = 2)
    public void portalImageLogoTest() throws InterruptedException {
        Thread.sleep(1000);
        Boolean flag = loginPage.validateimage();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();




    }
}
