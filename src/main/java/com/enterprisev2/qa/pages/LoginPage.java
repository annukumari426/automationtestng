package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestBase {
//Page Factory = Object Repositry(OR)
    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath ="//button[contains(text(),'Sign in')]")
    public WebElement loginBtn;

    @FindBy(name = "otp")
    public  WebElement OTP;

    @FindBy(xpath = "//img[@class = \"chakra-image css-1j3tadx\"]")
    public WebElement  weblogo;

//    Initalize the page object
    public  LoginPage(){
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this keyword because it refer to this class
    }
    public  String validateLoginTitle(){
        return  driver.getTitle();

    }
    public boolean validateimage(){

        return weblogo.isDisplayed();
    }
    public DashboardPage loginvalid(String un,String pwd,String otp) throws InterruptedException {
        email.sendKeys(un);
        password.sendKeys(pwd);
        try {
            clickLoginButton();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TypeOTP(otp);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        againclickButton();
        return new DashboardPage();

    }
    public void TypeOTP(String otp) throws InterruptedException {
        Thread.sleep(2000);
        OTP.sendKeys(otp);
    }
    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        loginBtn.click();
    }
    public void againclickButton(){
        loginBtn.click();
    }


}
