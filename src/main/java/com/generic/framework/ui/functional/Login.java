package com.generic.framework.ui.functional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Login {

    ExtentReports extent;

    public Login(ExtentReports extent) {
        this.extent = extent;
    }

    public void doLogin(WebDriver driver, ExtentTest test) {
        test.log(Status.INFO, "LOGIN STARTED");
        driver.get("https://a4data-qe.netlify.app");

        test.createNode("Looking for username");
        driver.findElement(By.id("email")).click();
        test.createNode("Clicked inside username");
        driver.findElement(By.id("email")).clear();
        test.createNode("Cleared the text if any ");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("superadmin");
        test.createNode("Username Typed");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("password")).clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("password")).sendKeys("Design_20");
        test.createNode("Password Typed");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span")).click();
        WebElement span = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span"));
        WebElement btn = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button"));

        span.click();
        test.createNode("Button Clicked");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // 2. How do I know I actually Logged In?
        driver.findElement(By.xpath("//*[text()='Logout']"));
        test.log(Status.INFO, "LOGIN SUCCESS");
        test.createNode("Logout Found");
    }

}
