package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class HelpButtonTest extends TestConfig {

    /**
     * @Test public void helpButtonTestCase() throws Exception {
     * test = extent.createTest("helpButtonClickTestCase");
     * login.doLogin(test);
     * test.createNode("looking for help button and clicking on it");
     * driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.helpIcon.explore-query-svg.ml-2")).click();
     * Thread.sleep(2 * 1000);
     * test.createNode("Checking for User");
     * driver.findElement(By.cssSelector("g > circle")).click();
     * Thread.sleep(6 * 1000);
     * driver.findElement(By.id("mainArc-a17f0131-7e52-49e9-ac2e-251cbfec5f9d")).click();
     * Thread.sleep(6 * 1000);
     * driver.findElement(By.cssSelector("g > circle")).click();
     * Thread.sleep(6 * 1000);
     * driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")).click(); // error here (no such element: Unable to locate element: {"method":"css selector","selector":"#mainArc\-11a018d0\-8978\-48ff\-9c7b\-ea8606201da5"})
     * driver.findElement(By.cssSelector("g > circle")).click();
     * Thread.sleep(6 * 1000);
     * WebElement mapObject = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2 > path"));
     * ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mapObject);
     * Thread.sleep(2 * 1000);
     * <p>
     * WebElement user = driver.findElement(By.xpath("//*[text()='User']"));
     * <p>
     * WebElement parent = user.findElement(By.xpath("./.."));
     * parent.click();
     * test.createNode("User found");
     * Thread.sleep(2 * 1000);
     * <p>
     * }
     **/

    @Test(groups = {"smokeTest"})
    public void helpButtonTestCase() throws Exception {
        test = extent.createTest("helpButtonClickTestCase");
        login.doLogin(test);
        test.createNode("looking for help button and clicking on it");

        WebElement helpbtn = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpbtn.click();
        Thread.sleep(6 * 1000);
        test.createNode("HelpButton clicked");

        test.createNode("clicking on user");
        WebElement user = driver.findElement(By.id("mainArc-a17f0131-7e52-49e9-ac2e-251cbfec5f9d"));
        user.click();
        test.createNode("users clicked");
        Thread.sleep(6 * 1000);

        test.createNode("clicking on userTest");
        WebElement userTest = driver.findElement(By.id("mainArc-91f13178-2fe2-4f1d-8e38-91e2b18185a9"));
        userTest.click();
        Thread.sleep(6 * 1000);

        test.createNode("clicking on gCircle");
        WebElement gCircle =//driver.findElement(By.cssSelector("g > circle"));
                driver.findElement(By.cssSelector("g > circle"));
        gCircle.click();
        Thread.sleep(6 * 1000);

        test.createNode("clicking on userCluster");
        WebElement userCluster = driver.findElement(By.id("mainArc-461e1fbb-d3a8-40b1-87ab-ca12d2aae080"));
        userCluster.click();
        Thread.sleep(6 * 1000);

        test.createNode("clicking on gCircle");
        WebElement gCircle1 = driver.findElement(By.cssSelector("g > circle"));
        gCircle1.click();
        Thread.sleep(6 * 1000);


    }

    @Test
    public void testHelpButtonShipmentsClick() throws Exception {
        test = extent.createTest("Help Button Shipments Click");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Looking for help button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Help Button Clicked");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Shipments cluster found");
        driver.findElement(By.id("mainArc-d5f6e57b-d157-4ec5-bbc4-9fd35cc68775")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Service cluster found");
        driver.findElement(By.id("mainArc-f18c2bb1-ad7d-4583-8b64-7ef98ba647cc")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.xpath("//*[text()=' Total Records']"));

        test.createNode("Total Records found means table loaded");

    }
}
