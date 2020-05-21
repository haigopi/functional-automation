package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageAutomation extends TestConfig {

    @Test
    public void testHelpButtonClick() throws Exception {

        test = extent.createTest("Help Button Click");
        login.doLogin(test);

        test.log(Status.INFO, "Looking for help button");

        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));

        helpButton.click();

        test.log(Status.INFO, "Help Button Clicked");

        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.id("mainArc-d5f6e57b-d157-4ec5-bbc4-9fd35cc68775")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.id("mainArc-f18c2bb1-ad7d-4583-8b64-7ef98ba647cc")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.xpath("//*[text()='Total Records: ']"));
        //driver.findElement(By.xpath("//*[text()='28']"));

        test.createNode("Total Records found means table loaded");

    }
}
