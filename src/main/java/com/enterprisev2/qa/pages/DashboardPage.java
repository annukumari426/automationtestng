package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/h2")
    public WebElement dashboardtext;

   @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div[2]/div/div/div[2]/button/span")
   public WebElement userlist;

   @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div[2]/div/div/div[3]/button/span")
   public  WebElement allmerchants;

   @FindBy(xpath = "//*[@id=\"accordion-button-:re:\"]/span")
   public WebElement alluserkyc;

   @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[3]/button/span")
   public WebElement managepayee;

   @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[3]/div/div/ul/li[1]")
   public  WebElement managepayeelist;

   @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[3]/div/div/ul/li[2]")
   public  WebElement addpayee;


    public  DashboardPage(){
        PageFactory.initElements(driver, this);  //you can use Login Page instead of this because it refer to this class
    }
    public  String verifyDashboardPageTitle(){
        return  driver.getTitle();
    }
    public String dashboardTextpresent(){
        return dashboardtext.getText();

    }
    public AllMerchantsListPage clickallmerchants(){
        allmerchants.click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/ul/li[1]")).click();
        return new AllMerchantsListPage();

    }
    public AllUserListPage clickonalluserList(){
        userlist.click();
        return new AllUserListPage();

    }
    public KycSendLinkPage clickonalluserkyc(){
        alluserkyc.click();
        return new KycSendLinkPage();
    }
    public void clickmanagepayee() {
        managepayee.click();

    }
    public ManagePayeesListPage clickonmanagepayeelist(){
        clickmanagepayee();
        managepayeelist.click();
        return new ManagePayeesListPage();
    }
    public  AddPayeePage clickonaddpayeelink(){
        clickmanagepayee();
        addpayee.click();
        return  new AddPayeePage();

    }

}

