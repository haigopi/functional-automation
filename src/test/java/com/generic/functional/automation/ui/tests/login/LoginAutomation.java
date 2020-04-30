package com.generic.functional.automation.ui.tests.login;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;


public class LoginAutomation {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
        baseUrl = "google.com";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
        driver.get("https://a4data-dev.netlify.app");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("superadmin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Design_20");
        //driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span")).click();
        WebElement span = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span"));
        WebElement btn = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button"));

        // 1. Button style
//        String style = btn.getAttribute("style");


//        if(style.contains("box-shadow: rgba(255, 105, 135, 0.3)")) {
//            // Fail it because the style is not valid.
//            System.out.println("==> "+style);
//            System.err.println("Style is not what we desired.");
//        }

        span.click();


        // 2. How do I know I actually Logged In?
        driver.findElement(By.xpath("//*[text()='Data Studio']"));
        //driver.findElement(By.xpath("//input[@name='']")).click();
        //driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/button/span")).click();


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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





