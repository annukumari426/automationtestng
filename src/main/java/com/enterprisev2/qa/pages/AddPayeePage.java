package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AddPayeePage extends TestBase {

    @FindBy(name = "accountHolder")
    public WebElement payeename;

    @FindBy(name = "email")
    public  WebElement payeeemail;

    @FindBy(name = "mobile")
    public WebElement payeemobile;

    @FindBy(name = "accountNumber")
    public WebElement payeeaccountnumber;

    @FindBy(name = "ifsc")
    public  WebElement payeeifsc;

    @FindBy(name = "bankName")
    public  WebElement payeebank;

    @FindBy(name="bankAddress")
    public WebElement payeebankaddress;

    @FindBy(name = "documentFile")
    public WebElement payeechanelcheque;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/button/p")
    public  WebElement savebutton;

    @FindBy(xpath = "//div[@role= \"group\"]")
    public List<WebElement> payeefields;


    public  AddPayeePage(){
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this because it refer to this class
    }
    public void validate_elements(){
        String basic_details_text = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/form/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(basic_details_text,"Basic Details");
        String bank_details_text = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/form/div/div[2]/div[1]/p")).getText();
        Assert.assertEquals(bank_details_text , "Bank Details");

    }
    public  String addpayeetext(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/p[1]")).getText();
    }
    public List<WebElement> getpayeefields(){
        return payeefields;
    }
    public void enterpayeebasicdetails(String name,String email, String mobile){
        payeename.sendKeys(name);
        payeeemail.sendKeys(email);
        payeemobile.sendKeys(mobile);
    }
    public void enterpayeebankdetails(String accountnumber, String ifsc , String bankname, String branch){
        payeeaccountnumber.sendKeys(accountnumber);
        payeeifsc.sendKeys(ifsc);
        payeebank.sendKeys(bankname);
        payeebankaddress.sendKeys(branch);
    }

    public void uploadcancelcheque(){
        payeechanelcheque.sendKeys("D:\\Downloads\\dora.png");

    }
    public ManagePayeesListPage clicksavebutton() throws InterruptedException {
        Thread.sleep(1000);
        savebutton.click();
        return new ManagePayeesListPage();
    }

}
