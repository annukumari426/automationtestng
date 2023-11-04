package com.enterprisev2.qa.base;

import com.enterprisev2.qa.util.TestUtil;
import com.enterprisev2.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static  WebDriver driver;
    public static Properties prop;
    public TestBase(){
//read properties
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/D:/Task/castler/EnterpriseV2Testng/src/main/java/com/enterprisev2"
                    + "/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initalization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "D:\\Task\\castler\\castlerdemo\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if ((browserName.equalsIgnoreCase("Edge"))) {
            driver = new EdgeDriver();
        }


        EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
        WebEventListener eventListner = new WebEventListener();
        e_driver.register(eventListner);
        driver= e_driver;

        driver.manage().window().maximize();;
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        }
    }




