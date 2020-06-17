package com.generic.functional.automation.ui.tests.login;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InvalidCredentialsTest extends TestConfig {
    @Test
    public void invalidUserNameAndPasswordTest() throws Exception {
        test = extent.createTest("InvalidCredentialsTest");
        test.createNode("Typing User Name");
        WebElement userName = driver.findElement(By.id("email"));
        userName.click();
        userName.clear();
        Thread.sleep(5*1000);
        userName.sendKeys("geeta");
        Thread.sleep(5*1000);
        test.createNode("Typing Password");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("Design_20");
        WebElement span = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span"));
        span.click();
        Thread.sleep(10*1000);
        boolean b = driver.getPageSource().contains("Username or password doesn't exists.");
        String s = "Username or password doesn't exists.";
        if (!b) {
            s = "";
        }

        Assert.assertEquals(s, "Username or password doesn't exists.");


    }
}
