package com.enterprisev2.qa.util;

import com.enterprisev2.qa.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static void takeScreenshotAtEndOfTest() {
    }

    public void switchtoFrame(){
        driver.switchTo().frame("mainframe");  // main framer is frame name

    }
    public  void pagerefresh(){
        driver.navigate().refresh();
    }
    public int generateRandomNumber(int numDigits) {
        if (numDigits <= 0) {
            System.out.println("Number of digits should be greater than 0.");
            return -1; // Return -1 to indicate an error
        }

        Random random = new Random();
        int min = (int) Math.pow(10, numDigits - 1);
        int max = (int) (Math.pow(10, numDigits) - 1);

        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

        private static final String[] FIRST_NAMES = {
                "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Irene", "Jack"
        };

        private static final String[] LAST_NAMES = {
                "Adams", "Brown", "Clark", "Davis", "Evans", "Fisher", "Garcia", "Hill", "Ivanov", "Johnson"
        };

        public static String generateRandomName() {
            Random random = new Random();
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            return firstName + " " + lastName;
        }
    }

