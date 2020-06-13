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
        Thread.sleep(5 * 1000);
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
    public void testVerifyResetButtonSearchBar() throws Exception { //Haritha
        test = extent.createTest("Home > Verify Reset Button / Clear the Search Bubble");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Clicked on Help Button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Clicked on Shipments");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO,"Clicked on International");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO,"Clicked on Account Number");
        driver.findElement(By.id("mainArc-fa581093-0286-4f62-a4a1-5abf224fa8f1")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Search Button");
        driver.findElement(By.className("search_icon")).click();
        Thread.sleep(7 * 1000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div/div/div[4]/div/div[2]/div[2]/div/div/div/div/div/div/div/div[1]"));
        element.click();
        test.log(Status.INFO, "Query Copied");
        WebElement element1 = driver.findElement(By.id("copy-query-0"));
        element1.click();
        Thread.sleep(7 * 1000);

        /// VALIDATION ///

        WebElement searchBubble = driver.findElement(By.className("search_input"));
        String queryText = searchBubble.getAttribute("value");

        System.out.println("Query Text (text inside search-bubble before reset button clicked): " + queryText);
        System.out.println();
        System.out.println("After Reset Button Clicked");
        test.log(Status.INFO, "Text in Search Bubble BEFORE reset button clicked (" + queryText + ")");

        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon")).click();  // Reset Button
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Reset Button Clicked");

        // Check After Reset Button Clicked
        queryText = searchBubble.getAttribute("value"); // Used to get value after reset button clicked
        if (queryText.isEmpty()) {
            System.out.println("Nothing in Search Bubble; Reset Button Worked!");
            System.out.println("This is what is in the search bubble (after reset button clicked): " + queryText);
            test.log(Status.INFO, "Text in Search Bubble AFTER reset button clicked (" + queryText + ")");
            System.out.println("Nothing as expected!");
            test.log(Status.INFO, "Verification of Reset Button Complete: checked that the value is empty");

        }
        else {
            System.out.println("Search Bubble still has text in it -> not null; Reset Button Did not Work!");
        }

        test.createNode("Verified Reset Button by Query History Search");
        //HTML CODE TO ACCESS
        // <input class="search_input" type="text" name="" placeholder="Search..." value="">

    }


    @Test
    public void testVerifyInternationalCountryOfOrigin() throws Exception {
        test = extent.createTest("Verify International Facts Country Of Origin");
        driver.manage().window().maximize();
        login.doLogin(test);
        Thread.sleep(7*1000);
       // driver.manage().window().maximize();
        test.log(Status.INFO, "Help button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(7*1000);
        test.log(Status.INFO, "Sunburst Shown");
        test.log(Status.INFO, "Shipments Cluster Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(7*1000);
        test.log(Status.INFO, "International Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(7*1000);
        test.log(Status.INFO, "Country of Origin Element Clicked on the Sunburst");
        WebElement helpButtoncountry = driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f"));
        helpButtoncountry.click();
        Thread.sleep(7*1000);
        driver.findElement(By.xpath("//*[text()=' Total Records']"));
        test.log(Status.INFO,"Total Records found and table shown");
        Thread.sleep(7*1000);
        test.createNode("Verified Reset Button with Search Bar");


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
        Thread.sleep(5*1000);
        WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton1.click();
        Thread.sleep(5*1000);
        driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.cssSelector("svg.css-19bqh2r")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.id("react-select-5-option-0")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.id("react-select-6-option-0")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.id("react-select-7-option-4")).click();
        Thread.sleep(5*1000);
        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")).click();

    }



    @Test
    public void testShipmentsSunburstDocClick() throws Exception { //Haritha
        test = extent.createTest("Verifying Shipments Documents Test");
        driver.manage().window().maximize();
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        test.log(Status.INFO, "Sunburst Shown");
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        WebElement SubjectShipmentsButtonClick=driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        SubjectShipmentsButtonClick.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Documents Cluster Click");
        WebElement DocumentsCluster =driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
        DocumentsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Documents Provider Cluster Click");
        WebElement DocumentsProviderCluster =driver.findElement(By.id("mainArc-cd5709c6-2d2e-4d24-8c1e-df38a9f9b0e5"));
        DocumentsProviderCluster.click();
        Thread.sleep(5 * 1000);
        WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton1.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Tabular View displayed");
        driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Graphical View Displayed ");
        driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Under Axis 1");
        WebElement Axis1=driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div"));
        Axis1.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Provider");
        WebElement Provider=driver.findElement(By.id("react-select-2-option-0"));
        Provider.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Under Axis2");
        WebElement Axis2=driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
        Axis2.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Count");
        WebElement Count=driver.findElement(By.id("react-select-3-option-0"));
        Count.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Under Graph");
        WebElement Graph=driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div"));
        Graph.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Bubble Graph");
        WebElement bubbleGraph=driver.findElement(By.id("react-select-4-option-4"));
        bubbleGraph.click();
        Thread.sleep(5 * 1000);

        test.log(Status.INFO, "Clicked on Show Button ");
        WebElement showButton=driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
        showButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Bubble Graph Displayed ");
        test.createNode("Verified Documents Cluster with Dimensional Data");

    }




    @Test
    public void testVerifyResetButtonSunburst() throws Exception {
        test = extent.createTest("Home Page Verify Reset Button by Sunburst");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        driver.manage().window().maximize();
       // test.createNode("Verified Reset Button");
        test.log(Status.INFO,"Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        test.createNode("Verified Reset Button");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Shipments Cluster");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on International");
        driver.findElement(By.id("mainArc-7000c84e-b726-405b-ae57-3103e755a869")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.id("mainArc-a4b796c9-8bbb-4f37-b959-26b2e1dd758e")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.id("mainArc-dcf61afd-31e9-4faa-9e8f-8743a267ac26")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Sub element to get the Query");
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon")).click();
        Thread.sleep(7 * 1000);
        driver.findElement(By.xpath("//input[@name='']")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Clicked on Reset Button");
        driver.findElement(By.xpath("//input[@name='']")).clear();
        Thread.sleep(7 * 1000);

    }
    @Test
    public void testVerifySubjectGuides() throws Exception { //Haritha
        test = extent.createTest("Verifying Subjects Guide ");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Sunburst Shown");
        test.createNode("Verified Subject Guides Successfully!");
        driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[3]/div/div/div/ul/li[2]/span")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Clicked on Domain Values");
        driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[3]/div/div/div/ul/li/span")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO,"Clicked on Drill down for Sub-elements");
        driver.findElement(By.xpath("//*[text()=' -- Subjects Guide -- ']"));
        test.log(Status.INFO,"Subjects Guide Displayed");
        driver.findElement(By.xpath("//*[text()='Domain of Values']"));
        test.log(Status.INFO,"Domain of Values Displayed");
        driver.findElement(By.xpath("//*[text()='Drill down for Sub-elements']"));
        test.log(Status.INFO,"Drill down for Sub-elements Displayed");
    }






}



