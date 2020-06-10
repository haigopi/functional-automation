package com.generic.framework.ui.functional;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void doLogin(ExtentTest test) throws Exception {
    test.createNode("Launching the URL=\"https://a4data-qe.netlify.app\"");
    driver.manage().window().maximize();
    test.log(Status.INFO, "LOGIN STARTED");
    driver.get("https://a4data-qe.netlify.app");
    test.log(Status.INFO, "Looking for username");
    driver.findElement(By.id("email")).click();
    test.log(Status.INFO, "Clicked inside username");
    driver.findElement(By.id("email")).clear();
    test.log(Status.INFO, "Cleared the text if any ");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("email")).sendKeys("superadmin");
    Thread.sleep(2 * 1000);
    test.createNode("LoginPage Username= \"superadmin\"  Typed");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.id("password")).clear();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.id("password")).sendKeys("Design_20");
    test.createNode("LoginPage Password =\"Design_20\" Typed ");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span")).click();
    WebElement span = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span"));
    WebElement btn = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button"));
    span.click();
    test.log(Status.INFO, "Username & Password Entered");
    test.log(Status.INFO, "clicking on login button");
    test.createNode("Login Button Clicked");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    //2. How do I know I actually Logged In?
    driver.findElement(By.xpath("//*[text()='Logout']"));
    test.log(Status.INFO, "clicking on login button");
    test.log(Status.INFO, "LOGIN SUCCESS");
    test.createNode("Logout ");

}

}

