package com.enterprisev2.qa.testcases;

import com.enterprisev2.qa.pages.AddEscrowDescriptionPage;
import com.enterprisev2.qa.pages.AddLinkPayeePage;
import com.enterprisev2.qa.pages.DashboardPage;
import com.enterprisev2.qa.pages.LoginPage;
import com.enterprisev2.qa.util.ExcelUtil;
import com.enterprisev2.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.enterprisev2.qa.base.TestBase.*;

public class AddEscrowDescriptionPageTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddEscrowDescriptionPage addEscrowDescriptionPage;
    TestUtil testUtil = new TestUtil();
    public AddEscrowDescriptionPageTest(){
        super();
    }
    @BeforeClass
    public void setUp() throws InterruptedException {
        initalization();
        testUtil= new TestUtil(); // to user switch frame in future
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginvalid(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("otp"));
        addEscrowDescriptionPage = dashboardPage.clickaddescrowdropdownvalue();

    }
    @Test(priority = 1)
    public  void clickproceedbutton(){
        driver.findElement(By.xpath("//*[text()=\"Proceed\"]")).click();
    }
    @Test(priority = 2)
    public void enterdetails() throws InterruptedException {

        String esname = testUtil.generateRandomName().toString();
        int esvolume = testUtil.generateRandomNumber(6);
        int evalidity = testUtil.generateRandomNumber(3);
//        // Choose the desired date (e.g., "2023-10-15")
//        WebElement startdatefield = driver.findElement(By.name("startDate"));
//        String targetDate = "19/11/2023";
//
//        // Use JavascriptExecutor to set the value
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=arguments[1]",startdatefield, targetDate);

        addEscrowDescriptionPage.enterescrowalldetails(esname,String.valueOf(esvolume), String.valueOf(evalidity),"user@gmail.com","Test escrow creation");

    }
    @Test(priority = 3)
    public void get_tooltip_text(){
      String tooltip = driver.findElement(By.xpath("//*[@class = \"chakra-icon css-177yplm\"]")).getText();


      System.out.println("Tooltip text is : " + tooltip);
    }
    @Test(priority = 4)
    public void enterdate() throws InterruptedException {
        addEscrowDescriptionPage.selectCurrentDay();
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void  clicknextbutton() throws InterruptedException {
        addEscrowDescriptionPage.clicknextbutton();
        Thread.sleep(2000);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

