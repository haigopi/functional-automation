package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HelpButtonTest extends TestConfig {

    @Test
    public void helpButtonTestCase() throws Exception {

        test = extent.createTest("helpButtonClickTestCase");
        login.doLogin(test);
        test.createNode("looking for help button and clicking on it");
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.helpIcon.explore-query-svg.ml-2")).click();
        Thread.sleep(2*1000);
        test.createNode("Checking for User");
        driver.findElement(By.cssSelector("g > circle")).click();
        Thread.sleep(6*1000);
        driver.findElement(By.id("mainArc-a17f0131-7e52-49e9-ac2e-251cbfec5f9d")).click();
        Thread.sleep(6*1000);
        driver.findElement(By.cssSelector("g > circle")).click();
        Thread.sleep(6*1000);
        driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")).click();
        driver.findElement(By.cssSelector("g > circle")).click();
        Thread.sleep(6*1000);
        WebElement mapObject = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2 > path"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mapObject);
        Thread.sleep(2*1000);

        WebElement user = driver.findElement(By.xpath("//*[text()='User']"));

        WebElement parent = user.findElement(By.xpath("./.."));
        parent.click();
        test.createNode("User found");
        Thread.sleep(2*1000);

    }
}
