package com.generic.functional.automation.ui.tests.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.functional.automation.ui.tests.common.TestConfig;


public class LoginLogoutAutomation extends TestConfig {

    @Test
    public void btnShadowTest() throws Exception {
        test = extent.createTest("Login Page Button Shadow",
                "Verifying Login Shadow Button");

        test.createNode("Looking for button");
        WebElement btn = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button"));

        // 1. Button style
        String style = btn.getAttribute("style");
        test.createNode("Style retrieved");
        if (style.contains("box-shadow: rgba(255, 105, 135, 0.3)")) {
            // Fail it because the style is not valid.
            System.out.println("==> " + style);
            System.err.println("Style is not what we desired.");
        }
        test.createNode("Style Cross Checked.");
    }

    @Test (groups = {"smokeTest"})
    public void testLogin() throws Exception {
        test = extent.createTest("Login Button Click",
                "Verifying Login Functionalities");
        test.createNode("Click Login Test");
        login.doLogin(test);
    }

    @Test
    public void testLoginElementsAndLogout() throws Exception {
        test = extent.createTest("Logout Button Click",
                "Verifying Logout Functionalities");
        test.createNode("Looking for DataStudio Button");
        driver.findElement(By.xpath("//*[text()='Data Studio']"));
        test.createNode("Looking for Articulator Button");
        driver.findElement(By.xpath("//*[text()='Articulator']"));
        test.createNode("Looking for Cluster Studio Button");
        driver.findElement(By.xpath("//*[text()='Cluster Studio']"));
        test.createNode("Looking for Entitles Button");
        driver.findElement(By.xpath("//*[text()='Entitles']"));
        test.createNode("Looking for Logout Button & clicking on it");
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        // 2. How do I know I actually Logged In?
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.createNode("Looking for SignIn Button");
        driver.findElement(By.xpath("//*[text()='Sign in']"));
        test.createNode("SignIn Found");
    }

}





