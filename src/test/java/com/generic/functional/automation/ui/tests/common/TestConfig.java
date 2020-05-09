package com.generic.functional.automation.ui.tests.common;

import com.generic.framework.ui.functional.Login;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestConfig {

    protected WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    protected Login login = new Login();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        /*
            Identify the Operating System and assign the chrome driver
         */
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.out.println("OS name -> " + System.getProperty("os.name"));
            System.setProperty("webdriver.chrome.driver", "chromedriver_win32.exe");
        } else {
            System.out.println("Other Operating Systems");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

        driver = new ChromeDriver();
        baseUrl = "https://a4data-qe.netlify.app";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
