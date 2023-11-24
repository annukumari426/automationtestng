package com.enterprisev2.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import static com.enterprisev2.qa.base.TestBase.driver;

public class AddEscrowDescriptionPage {
    @FindBy(xpath = "//div[@role= \"group\"]")
    public List<WebElement> escrowdescriptionfields;

    @FindBy(name = "bank")
    public WebElement selectbank;

    @FindBy(name = "hardEscrowNumber")
    public WebElement selecthardescrow;

    @FindBy(name = "name")
    public WebElement escrowname;

    @FindBy(name = "startDate")
    public WebElement startdate;

    @FindBy(name = "expectedVolume")
    public WebElement expectedvolume;

    @FindBy(name = "validity")
    public WebElement validity;

    @FindBy(name = "email")
    public WebElement escrowemail;

    @FindBy(xpath = "//div[@class=\"chakra-input__right-element css-ur97uj\"]")
    public WebElement emailfieldmessage;

    @FindBy(name = "purpose")
    public WebElement purpose;

    @FindBy(xpath = "//p[text()=\"Next\"]")
    public WebElement nextbutton;


    public AddEscrowDescriptionPage() {
        PageFactory.initElements(driver, this);  //you can use LoginPage Page instead of this because it refer to this class
    }

    public boolean setbankenabled() {
        return selectbank.isEnabled();
    }

    public boolean setbankdisplayed() {
        return selectbank.isDisplayed();
    }

    public boolean sethardescrowdisplayed() {
        return selecthardescrow.isDisplayed();
    }

    public boolean sethardescrowenabled() {
        return selecthardescrow.isEnabled();
    }

    public List<WebElement> getdescriptionpagefields() {
        return escrowdescriptionfields;
    }
    public  void clickproceedbutton(){
        driver.findElement(By.xpath("//*[text()=\"Proceed\"]")).click();
    }

    public void enterescrowalldetails(String ename, String evolume, String evalidity, String eemail, String epurpose) throws InterruptedException {
        if (setbankenabled() && setbankdisplayed()) {
            Select selectbankdropdown = new Select(selectbank);
            selectbankdropdown.selectByVisibleText("dbs");
        } else
            System.out.println("Select Bank drop-down not displayed");
        Thread.sleep(1000);
        if (sethardescrowenabled() && sethardescrowdisplayed()) {
            Select selecthardescrowdropdown = new Select(selecthardescrow);
            selecthardescrowdropdown.selectByIndex(1);
        } else {
            System.out.println("Select Hardescrow drop-down not displayed");
        }


        escrowname.sendKeys(ename);
        expectedvolume.sendKeys(evolume);
        validity.sendKeys(evalidity);
        escrowemail.sendKeys(eemail);
        purpose.sendKeys(epurpose);

    }

    public void selectCurrentDay() {
        // Get the current day
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // Locate all day elements in the date picker
        startdate.click();
        List<WebElement> dayElements = driver.findElements(By.xpath("//button[@class=\"chakra-button css-1osfyqp\"]"));

        // Iterate through day elements and click on the current day
        for (WebElement dayElement : dayElements) {
            if (Integer.parseInt(dayElement.getText()) == currentDay) {
                dayElement.click();
                break;
            }
        }
    }


    public void enterescrowmandatorydetails(String ename, String evolume, String evalidity, String epurpose) {
        if (setbankdisplayed()) {
            Select selectbankdropdown = new Select(selectbank);
            selectbankdropdown.selectByVisibleText("dbs");
        } else
            System.out.println("Select Bank drop-down not displayed");
        if (sethardescrowdisplayed()) {
            Select selecthardescrowdropdown = new Select(selecthardescrow);
            selecthardescrowdropdown.selectByIndex(1);
        }
        escrowname.sendKeys(ename);
        expectedvolume.sendKeys(evolume);
        validity.sendKeys(evalidity);
        purpose.sendKeys(epurpose);
    }

    public AddLinkPayeePage clicknextbutton() {
        if (nextbutton.isEnabled()) {
            nextbutton.click();

        }
        return new AddLinkPayeePage();
    }


}






