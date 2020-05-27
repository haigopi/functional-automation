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
        Thread.sleep(1*1000);
        test.log(Status.INFO, "Shipments cluster found");
        driver.findElement(By.id("mainArc-d5f6e57b-d157-4ec5-bbc4-9fd35cc68775")).click();
        Thread.sleep(1*1000);
        test.log(Status.INFO, "Service cluster found");
        driver.findElement(By.id("mainArc-f18c2bb1-ad7d-4583-8b64-7ef98ba647cc")).click();
        Thread.sleep(2*1000);
        driver.findElement(By.xpath("//*[text()='Total Records: ']"));
        //driver.findElement(By.xpath("//*[text()='28']"));

        test.createNode("Total Records found means table loaded");

    }




    @Test
    public void testHelpButtonIntenationalClick() throws Exception {
        test = extent.createTest("Help Button International Click");
        login.doLogin(test);
        test.log(Status.INFO, "Looking for help button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Help Button Clicked");
        test.log(Status.INFO, "Shipments link Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(1*1000);
        test.log(Status.INFO, "International link Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(2*1000);
        test.log(Status.INFO, "Country of Origin link Clicked on the Sunburst");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Country of Origin link Clicked on the Sunburst");
        WebElement helpButtoncountry = driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f"));
        helpButtoncountry.click();

        Thread.sleep(2*1000);
        driver.findElement(By.xpath("//*[text()='Total Records: ']"));
        test.createNode("Total Records found means table loaded");

    }

    @Test
    public void testShipmentsDocumentsClick() throws Exception {
        test = extent.createTest("Shipments Documents Click");
        login.doLogin(test);
        test.log(Status.INFO, "Looking for help button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Help Button Clicked");


        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.id("mainArc-044c1070-d406-443b-a9e5-2fdbdf4daaae")).click();
        Thread.sleep(1*1000);

        driver.findElement(By.xpath("//*[text()='Total Records: ']"));

    }

    @Test
    public void testResetButton() throws Exception {
        test = extent.createTest("Reset Button Test");
        login.doLogin(test);

        test.log(Status.INFO, "Testing the Functionality of the Reset button");

      //  driver.get("https://a4data-qe.netlify.app/dashboard");
        driver.findElement(By.xpath("//input[@name='']")).click();
        driver.findElement(By.xpath("//input[@name='']")).clear();



        driver.findElement(By.xpath("//input[@name='']")).sendKeys("list all international");
        test.log(Status.INFO, "Entered Query No.1");
        Thread.sleep(1*1000);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon > path")).click();
        test.log(Status.INFO, "Reset Button Clicked");
        Thread.sleep(1*1000);
        driver.findElement(By.xpath("//input[@name='']")).sendKeys("list all customers by city");
        test.log(Status.INFO, "Entered Query No.2");
        Thread.sleep(1*1000);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon > path")).click();
        test.log(Status.INFO, "Reset Button Clicked");

    }



    @Test
    public void testVerifySubjectGuides() throws Exception {
        logicAndClickHelpButton();
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        //driver.get("https://a4data-qe.netlify.app/dashboard/");
        driver.findElement(By.id("mainArc-890e16a2-6415-4661-982d-33acafbb1fed")).click();
        driver.findElement(By.id("mainArc-656a2ba3-4af2-471a-a5ef-6b3decb8dfeb")).click();
        driver.findElement(By.id("mainArc-df1ff2c9-14ac-4aa1-8572-93a4cd914093")).click();
        driver.findElement(By.id("mainArc-2ba8d1f2-779e-4574-b83e-046a283eff931")).click();
    }

    public void logicAndClickHelpButton() throws Exception {
        test = extent.createTest("Help Button International Click");
        login.doLogin(test);
    }


}



