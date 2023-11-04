package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KycSendLinkPage extends TestBase {

    @FindBy(xpath = "//p[text() = 'Send KYC Link']")
    WebElement sendkyclinkbutton;

    @FindBy(name = "fullName")
    WebElement fullName;

    @FindBy(name="email")
    WebElement emailaddress;

    @FindBy(xpath = "//button[text() = 'Send Link']")
    WebElement sendlinkbutton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[6]")
    WebElement kyclink;

    public  KycSendLinkPage(){
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this keyword because it refer to this class
    }
    public String validateKycpageTitle(){
        return  driver.getTitle();
    }
    public void fillkyclinkform(String name , String email){
        sendkyclinkbutton.click();
        fullName.sendKeys(name);
        emailaddress.sendKeys(email);
        sendlinkbutton.click();

    }
    public KycBasicDetailsPage copyandopenlink(){
        String link = kyclink.getText();
        String urllink = String.valueOf("https://enterprise-qa.ncome.in/kyc/"+ link);
        driver.get("https://enterprise-qa.ncome.in/kyc/"+link);
        return new KycBasicDetailsPage();
    }
    public void pagerefresh(){
        driver.navigate().refresh();
    }








}
