package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageAutomation extends TestConfig {


     @Test
    public void testHelpButtonShipmentsClick() throws Exception {
        test = extent.createTest("Help Button Shipments Click");
        login.doLogin(test);
        test.log(Status.INFO, "Looking for help button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Help Button Clicked");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Shipments cluster found");
        driver.findElement(By.id("mainArc-d5f6e57b-d157-4ec5-bbc4-9fd35cc68775")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Service cluster found");
        driver.findElement(By.id("mainArc-f18c2bb1-ad7d-4583-8b64-7ef98ba647cc")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.xpath("//*[text()=' Total Records']"));
        //driver.findElement(By.xpath("//*[text()='28']"));

        test.createNode("Total Records found means table loaded");

    }




    @Test
    public void testVerifyInternationalCountryOfOrigin() throws Exception {
        test = extent.createTest("Verify International Facts Country Of Origin");
        login.doLogin(test);
        test.log(Status.INFO, "Help button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Sunburst Shown");
        test.log(Status.INFO, "Shipments Cluster Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "International Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Country of Origin Element Clicked on the Sunburst");
        WebElement helpButtoncountry = driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f"));
        helpButtoncountry.click();
        Thread.sleep(5*1000);
        driver.findElement(By.xpath("//*[text()=' Total Records']"));
        test.log(Status.INFO,"Total Records found and table shown");

    }

    @Test
    public void testVerifyInternationalDocumentsClick() throws Exception {
        test = extent.createTest("Verify International Documents");
        login.doLogin(test);
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Sunburst Shown");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Shipments Cluster Clicked");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "International Clicked on Sunburst");
        driver.findElement(By.id("mainArc-044c1070-d406-443b-a9e5-2fdbdf4daaae")).click();
        Thread.sleep(5*1000);
        test.log(Status.INFO, "Documents Element Clicked");
        driver.findElement(By.xpath("//*[text()=' Total Records']"));
        test.log(Status.INFO,"Total Records found and table shown");

    }

    @Test
    public void testShipmentsSunburstDocClick() throws Exception {
        test = extent.createTest("Shipments Documents Click");
        driver.manage().window().maximize();
        login.doLogin(test);
        test.createNode("Help Button Click");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Button Click");
        WebElement SubjectShipmentsButtonClick=driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        SubjectShipmentsButtonClick.click();
        Thread.sleep(5 * 1000);
        test.createNode("Documents Cluster Click");
        WebElement DocumentsCluster =driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
        DocumentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Documents Provider Cluster Click");
        WebElement DocumentsProviderCluster =driver.findElement(By.id("mainArc-cd5709c6-2d2e-4d24-8c1e-df38a9f9b0e5"));
        DocumentsProviderCluster.click();
        Thread.sleep(5 * 1000);
    }

    @Test
    public void testResetButton() throws Exception {
        test = extent.createTest("Verify Reset Button");
        login.doLogin(test);

        test.log(Status.INFO,"Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Shipments Cluster");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on International");
        driver.findElement(By.id("mainArc-7000c84e-b726-405b-ae57-3103e755a869")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.id("mainArc-a4b796c9-8bbb-4f37-b959-26b2e1dd758e")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.id("mainArc-dcf61afd-31e9-4faa-9e8f-8743a267ac26")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.xpath("//input[@name='']")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Reset Button");
        driver.findElement(By.xpath("//input[@name='']")).clear();
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//input[@name='']")).sendKeys("list all international");
        test.log(Status.INFO, "Entered a Query in search bubble");
        Thread.sleep(3*1000);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon > path")).click();
        test.log(Status.INFO, "Reset Button Clicked");
        Thread.sleep(2*1000);
     /*   driver.findElement(By.xpath("//input[@name='']")).sendKeys("list all customers by city");
        test.log(Status.INFO, "Entered Query No.2");
        Thread.sleep(5*1000);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon > path")).click();
        test.log(Status.INFO, "Reset Button Clicked");*/

    }
    @Test
    public void testVerifySubjectGuides() throws Exception {
        test = extent.createTest("Verify the Subject Guide Test");
        login.doLogin(test);
        test.log(Status.INFO,"Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-890e16a2-6415-4661-982d-33acafbb1fed")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-656a2ba3-4af2-471a-a5ef-6b3decb8dfeb")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-df1ff2c9-14ac-4aa1-8572-93a4cd914093")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.linkText("Customer")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-dde43c3d-c500-407e-9786-7fb0b1d39b85")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.linkText("Customer")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-cf0ac243-723d-468b-b40c-91195565e4e0")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.linkText("Customer")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-79796cc3-bd59-437c-9763-495a5f1fb6bc")).click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.id("mainArc-79796cc3-bd59-437c-9763-495a5f1fb6bc1")).click();
        Thread.sleep(5 * 1000);

    }

    public void logicAndClickHelpButton() throws Exception {
        test = extent.createTest("Help Button International Click");
        login.doLogin(test);
    }
    @Test
    public void testVerifyResetButton() throws Exception {
        test = extent.createTest("Test Case - Verify Reset Button");
        login.doLogin(test);
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Help Button Clicked");
        test.log(Status.INFO, "Sunburst Shown");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(3*1000);
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        test.log(Status.INFO, "Clicked on Shipments");
        Thread.sleep(3*1000);
        driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f")).click();
        test.log(Status.INFO, "Clicked on International");
//        WebElement btn2 = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.mr-2"));  //COpy link
//        System.out.println("Button2 "+btn2);
//        btn2.click();
        test.log(Status.INFO, "Clicked on Country of Origin");
        Thread.sleep(4*1000);
        //driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon")).click();
        WebElement resetBtn =  driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon"));
        test.log(Status.INFO, "Reset Button Clicked");
        System.out.println("ResetButton "+resetBtn);
        resetBtn.click();
    }



}



