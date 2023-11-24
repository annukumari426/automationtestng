package com.enterprisev2.qa.pages;

import com.enterprisev2.qa.util.TableUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

import java.util.List;

import static com.enterprisev2.qa.base.TestBase.driver;

public class AddLinkPayeePage {
    @FindBy(xpath = "//input[@class= \" css-10wwmqn\"]")
    public WebElement payee_dropdown;

    @FindBy(name = "shareUnit")
    public  WebElement shareunit;

    @FindBy(name = "share")
    public WebElement share;

    @FindBy(xpath = "//*[@class= \"chakra-text css-1dk4rq7\"]")
    public WebElement maxlimittext;

    @FindBy(xpath = "//button[text()= \"Add\"]")
    public  WebElement addbutton;

    @FindBy(xpath= "//button/p[text()= \"Save\"]")
    public  WebElement savebutton;

    @FindBy(name= "autoTransfer")
    public  WebElement autoTransfertoggle;

    @FindBy(xpath = "//table[@class = \"chakra-table css-5605sr\"]")
    public WebElement payeetableLocator;

    @FindBy(xpath = "//*[@role = \"group\"]")
    public List<WebElement> escrow_payeefields;


    public AddLinkPayeePage() {
        PageFactory.initElements(driver, this);  //you can use LoginPage Page instead of this because it refer to this class
    }

    public List<WebElement> payeefields(){
        return escrow_payeefields;
    }

//    public void verifypayeefieldvalue(){
//        payee_dropdown.click();
////        WebElement payee_drop_down_values = driver.findElement(By.id("react-select-2-listbox"));
//        Select payees_dropdown = new Select(payee_dropdown);
//        List<WebElement> payee_options = payees_dropdown.getOptions();
//        System.out.println(payee_options);


    public void add_payee() throws InterruptedException {
//        Select payees_dropdown = new Select(payee_dropdown);
//        payees_dropdown.selectByIndex(2);
//        payee_dropdown.click();
//        Thread.sleep(1000);
        payee_dropdown.sendKeys("User");
        Thread.sleep(2000);
//        driver.findElement(By.name("payeeId")).click();
//        WebElement payee_values = driver.findElement(By.xpath("//div[@class=\"css-1q7tlhp\"]"));
//        payee_values.click();


        Thread.sleep(1000);
        Select unit_drop = new Select(shareunit);
        unit_drop.selectByValue("inr");
        share.sendKeys("1000");
        addbutton.click();
    }



    public AddEscrowDocumentPage  clicksavebutton() throws InterruptedException {
        Thread.sleep(2000);
        savebutton.click();
        return new AddEscrowDocumentPage();
    }



}
