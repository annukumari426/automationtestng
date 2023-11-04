package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KycBasicDetailsPage extends TestBase {

    @FindBy(name = "ownerMobile")
    public WebElement mobilenumber;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/form/div/button")
     public WebElement continuebutton;

    @FindBy(name = "ownerFirstName")
    public  WebElement firstname;

    @FindBy(name = "ownerLastName")
    public  WebElement lastname;

    @FindBy(name = "ownerEmail")
    public  WebElement kycemail;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/form/div/button")
    public WebElement startapplicationbutton;

    public  KycBasicDetailsPage(){
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this keyword because it refer to this class
    }

    public void entermobile(String mobile){
        mobilenumber.sendKeys(mobile);
    }
    public void enterotp() throws InterruptedException {
        Thread.sleep(2000);
        for(int i=0; i<4;i++){
            WebElement otp = driver.findElement(By.xpath("//*[@type=\"tel\"][" + (i+1) +"]"));
            otp.sendKeys("1");
            Thread.sleep(2000);
        }

    }
    public void clickcontinue(){
        continuebutton.click();

    }
    public void enterkycnameandemail(String userfirstname, String userlastname , String kycuseremail){
        firstname.sendKeys(userfirstname);
        lastname.sendKeys(userlastname);
        kycemail.sendKeys(kycuseremail);
    }
    public void getenternameemail(){
        firstname.getText();
        lastname.getText();
        kycemail.getText();
    }
    public KycBusinessProfileDetailsPage clickstartapplicationbutton(){
        startapplicationbutton.click();
        return  new KycBusinessProfileDetailsPage();
    }

}
