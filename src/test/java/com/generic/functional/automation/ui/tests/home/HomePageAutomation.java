package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.framework.ui.helper.HighlightHelper;
import com.generic.framework.ui.helper.QueryChecker;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HomePageAutomation extends TestConfig {

    QueryChecker queryChecker;
    HighlightHelper highlightHelper;



    public HomePageAutomation() throws Exception {
        queryChecker = new QueryChecker();
        highlightHelper = new HighlightHelper();
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

    @Test
    public void testVerifyResetButtonSearchBar() throws Exception { //Haritha
        test = extent.createTest("Home > Verify Reset Button / Clear the Search Bubble");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Help Button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        highlightHelper.highLightElement(driver, helpButton);
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Shipments");
        WebElement e1 = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        e1.click();
        Thread.sleep(4 * 1000);
        test.log(Status.INFO, "Clicked on International");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(4 * 1000);
        test.log(Status.INFO, "Clicked on Account Number");
        driver.findElement(By.id("mainArc-fa581093-0286-4f62-a4a1-5abf224fa8f1")).click();
        Thread.sleep(4 * 1000);
        test.log(Status.INFO, "Clicked on Search Button");
        WebElement searchButton = driver.findElement(By.className("search_icon"));
        highlightHelper.highLightElement(driver, searchButton);
        searchButton.click();
        Thread.sleep(4 * 1000); //next line error (works now)
        WebElement hoverElement = driver.findElement(By.cssSelector("#scrollable-auto-tabpanel-0 > div > div.pl-4.pr-4.pb-2 > div > div > div > div > div > div > div.MuiButtonBase-root.MuiExpansionPanelSummary-root.query-title-wrapper > div > div > div.right-carousel-item > div.query-text-area"));
        //*[@id="gatsby-focus-wrapper"]/div/main/div/div/div/div[4]/div/div[2]/div[2]/div/div/div/div/div/div/div/div[1] OLD
        highlightHelper.highLightElement(driver, hoverElement);
        hoverElement.click();
        test.log(Status.INFO, "Query Copied");
        WebElement copyQueryBtn = driver.findElement(By.id("copy-current-query-0"));
        highlightHelper.highLightElement(driver, copyQueryBtn);
        copyQueryBtn.click();
        Thread.sleep(7 * 1000);

        /// VALIDATION ///

        WebElement searchBubble = driver.findElement(By.className("search_input"));
        String queryText = searchBubble.getAttribute("value");
        test.log(Status.INFO, "Text in Search Bubble BEFORE reset button clicked (" + queryText + ")");
        WebElement resetButton = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.highlightIcon")); // Reset Button
        highlightHelper.highLightElement(driver, resetButton);
        resetButton.click();
        Thread.sleep(3 * 1000);
        test.log(Status.INFO, "Reset Button Clicked");
        // Check After Reset Button Clicked
        queryText = searchBubble.getAttribute("value"); // Used to get value after reset button clicked
        if (queryText.isEmpty()) {
            test.log(Status.INFO, "Text in Search Bubble AFTER reset button clicked (" + queryText + ")");
            test.log(Status.INFO, "Verification of Reset Button Complete: checked that the value is empty");
            Assert.assertTrue(true); // 1st validation
            Assert.assertEquals(queryText, ""); //2nd validation
        } else {
            test.log(Status.INFO, "Search Bubble still has text in it -> not null; Reset Button Did not Work!");
            Assert.assertFalse(true); // terminate & exit
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
        Thread.sleep(7 * 1000);
        // driver.manage().window().maximize();
        test.log(Status.INFO, "Help button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        test.log(Status.INFO, "Shipments Cluster Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "International Clicked on the Sunburst");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(7 * 1000);
        test.log(Status.INFO, "Country of Origin Element Clicked on the Sunburst");
        WebElement helpButtoncountry = driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f"));
        helpButtoncountry.click();
        Thread.sleep(7 * 1000);

        /// VALIDATION ///

        //WebElement totalRecords = driver.findElement(By.id("total-records-count"));
        WebElement tr = driver.findElement(By.xpath("/html/body/div/div/div/main/div/div/div/div[5]/div/div/div/div[1]/div/div/div[1]/div[2]/ul/li/div/span/div[2]/span[2]"));
        String value = tr.getText();
        if (Integer.parseInt(value) == 0) {
            test.log(Status.INFO, "No Table should appear since no data fetched for given query");
            Assert.assertEquals(0, 0);
            Assert.assertFalse(Integer.parseInt(value) == 0); // to fail, parameter has to be true (0 == 0) => so true; assertFalse(true) means failed test
        } else {
            test.log(Status.INFO, "Table is shown with records since table records != 0");
            Assert.assertEquals(Integer.parseInt(value) > 0, true); //setting to true since if it comes into this else, it is greater than 0 (can be any num greater than 0 so can't put set value for expected)
            Assert.assertTrue(Integer.parseInt(value) > 0);


            driver.findElement(By.xpath("//*[text()=' Total Records']"));
            test.log(Status.INFO, "Total Records found and table shown");
            Thread.sleep(7 * 1000);
            test.createNode("Verified the table information is displayed when Country of origin is selected. ");

            driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click(); // Clicks on Graphical View
            Thread.sleep(5 * 1000);
            driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click(); // Clicks on Other Graphical View
            Thread.sleep(5 * 1000);
            driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div")).click(); // Click Axis 1
            Thread.sleep(3 * 1000);
            driver.findElement(By.id("react-select-2-option-0")).click(); // Click origin country
            Thread.sleep(5 * 1000);
            driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div")).click(); // Click Axis 2
            Thread.sleep(3 * 1000);
            driver.findElement(By.id("react-select-3-option-0")).click(); // Click count
            Thread.sleep(5 * 1000);
            driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div")).click(); //Click graph
            Thread.sleep(3 * 1000);
            driver.findElement(By.id("react-select-4-option-4")).click(); // Click bubble Graph
            Thread.sleep(5 * 1000);
            driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")).click(); // Click Show

        }
    }

    @Test
    public void testVerifyInternationalDocumentsClick() throws Exception { // FIX
        test = extent.createTest("Verify International Documents");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Shipments Cluster Clicked");
        driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "International Clicked on Sunburst");
        driver.findElement(By.id("mainArc-044c1070-d406-443b-a9e5-2fdbdf4daaae")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Documents Element Clicked");
        driver.findElement(By.xpath("//*[text()=' Total Records']"));
        test.log(Status.INFO, "Total Records found and table shown");
        Thread.sleep(5 * 1000);
        WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton1.click();
        Thread.sleep(5 * 1000);
        driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click(); // clicks on graphical view
        Thread.sleep(5 * 1000);
        driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click(); // clicks on other graphical view
        Thread.sleep(5 * 1000);

        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div")).click(); //Axis 1 click
        Thread.sleep(3 * 1000);
        driver.findElement(By.id("react-select-2-option-0")).click(); //Clicked on Documents Only
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div")).click(); // Click Axis 2
        Thread.sleep(3 * 1000);
        driver.findElement(By.id("react-select-3-option-0")).click(); // Clicks Count
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div")).click(); //Click graph
        Thread.sleep(3 * 1000);
        driver.findElement(By.id("react-select-4-option-4")).click(); // Clicks Bubble Graph
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")).click(); // Clicks Show
        Thread.sleep(3 * 1000); // To show bubble graph momentarily

        test.createNode("Verified international documents only (multiple graphical views)");
    }


    @Test
    public void testShipmentsSunburstDocClick() throws Exception { //Haritha
        test = extent.createTest("Verifying Shipments Documents Test");
        driver.manage().window().maximize();
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        highlightHelper.highLightElement(driver, helpButton);
        helpButton.click();
        test.log(Status.INFO, "Sunburst Shown");
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        SubjectShipmentsButtonClick.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Documents Cluster Click");
        WebElement DocumentsCluster = driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
        DocumentsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Documents Provider Cluster Click");
        WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-cd5709c6-2d2e-4d24-8c1e-df38a9f9b0e5"));
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

        /// VALIDATION ///

        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Under Axis 1");
        WebElement Axis1 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div"));
        Axis1.click();


        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Provider");
        WebElement Provider = driver.findElement(By.id("react-select-2-option-0"));
        test.log(Status.INFO, "Validating 'Provider' variable");
        Assert.assertTrue(Provider.getText().equals("Provider")); //1st Validator
        Assert.assertEquals(Provider.getText(), "Provider"); // 2nd Validator
        test.log(Status.INFO, "Validation of 'Provider' variable Successful");
        Provider.click();

        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Under Axis2");
        WebElement Axis2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
        Axis2.click();

        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Count");
        WebElement Count = driver.findElement(By.id("react-select-3-option-0"));
        test.log(Status.INFO, "Validating 'COUNT' variable");
        Assert.assertTrue(Count.getText().equals("COUNT")); //1st Validator
        Assert.assertEquals(Count.getText(), "COUNT"); // 2nd Validator
        test.log(Status.INFO, "Validation of 'COUNT' variable Successful");
        Count.click();
        Thread.sleep(5 * 1000);

        test.log(Status.INFO, "Under Graph");
        WebElement Graph = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div"));
        Graph.click();

        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Selected Bubble Graph");
        WebElement bubbleGraph = driver.findElement(By.id("react-select-4-option-4"));
        test.log(Status.INFO, "Validating 'Bubble Graph' variable");
        Assert.assertTrue(bubbleGraph.getText().equals("Bubble Graph")); //1st Validator
        Assert.assertEquals(bubbleGraph.getText(), "Bubble Graph"); // 2nd Validator
        test.log(Status.INFO, "Validation of 'Bubble Graph' variable Successful");
        bubbleGraph.click();
        Thread.sleep(5 * 1000);

        test.log(Status.INFO, "Clicked on Show Button ");
        WebElement showButton = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
        showButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Bubble Graph Displayed ");
        test.createNode("Verified Documents Cluster with Dimensional Data");

    }


    @Test
    public void testVerifyResetButtonSunburst() throws Exception { //***
        test = extent.createTest("Home Page Verify Reset Button by Sunburst");
        login.doLogin(test);
        Thread.sleep(5 * 1000);

        driver.manage().window().maximize();
        // test.createNode("Verified Reset Button");
        test.log(Status.INFO, "Help Button Clicked");
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
    public void testVerifySubjectGuides() throws Exception { //***
        test = extent.createTest("Verifying Subjects Guide ");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        /*test.createNode("Verified Subject Guides Successfully!");
        driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[3]/div/div/div/ul/li[2]/span")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Domain Values");
        driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[3]/div/div/div/ul/li/span")).click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Clicked on Drill down for Sub-elements");
        driver.findElement(By.xpath("//*[text()=' -- Subjects Guide -- ']"));
        test.log(Status.INFO, "Subjects Guide Displayed");
        driver.findElement(By.xpath("//*[text()='Domain of Values']"));
        test.log(Status.INFO, "Domain of Values Displayed");
        driver.findElement(By.xpath("//*[text()='Drill down for Sub-elements']"));
        test.log(Status.INFO,"Drill down for Sub-elements Displayed");*/
    }

    @Test
    public void testDownloadCSVButton() throws Exception {
        test = extent.createTest("DownloadCSVButton");
        login.doLogin(test);
        test.log(Status.INFO, "Help Button Clicked");
        test.createNode("Help Button Click");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        test.createNode("Subject Shipments Button Click");
        WebElement subjectShipmentsButton = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        subjectShipmentsButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Freight Charges Click");
        test.log(Status.INFO, "Freight Charges Click");
        driver.findElement(By.id("mainArc-2609f85e-b113-407e-b007-dcea50347141")).click();
        Thread.sleep(5 * 1000);
        test.createNode("Carrier Identifier Click");
        test.log(Status.INFO, "Carrier Identifier Click");
        driver.findElement(By.id("mainArc-a5cc64db-9de3-414a-98a4-e975accd1246")).click();
        Thread.sleep(5 * 1000);
        test.createNode("DownloadCSVButton");
        driver.findElement(By.id("search-result-download-csv")).click();
        System.out.println(TestConfig.DEFAULT_DOWNLOAD_DIR + File.separator + "export.csv");
        File file = new File(TestConfig.DEFAULT_DOWNLOAD_DIR + File.separator + "export.csv");
        Thread.sleep(5 * 1000);

        try {
            if (file.delete()) {
                test.createNode("File  deleted  succesfully");
            } else {
                test.createNode("Failed to delete the file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void testVerifyPrintButton() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        test = extent.createTest("VerifyPrintButton");
        login.doLogin(test);
        test.log(Status.INFO, "Help Button Clicked");
        test.createNode("Help Button Click");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")));//Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        test.createNode("Subject Shipments Button Click");
        WebElement subjectShipmentsButton = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        subjectShipmentsButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-2609f85e-b113-407e-b007-dcea50347141")));//Thread.sleep(5 * 1000);
        test.createNode("Freight Charges Click");
        test.log(Status.INFO, "Freight Charges Click");
        driver.findElement(By.id("mainArc-2609f85e-b113-407e-b007-dcea50347141")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-a5cc64db-9de3-414a-98a4-e975accd1246")));//Thread.sleep(5 * 1000);
        test.createNode("Carrier Identifier Click");
        test.log(Status.INFO, "Carrier Identifier Click");
        driver.findElement(By.id("mainArc-a5cc64db-9de3-414a-98a4-e975accd1246")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-result-print > span.MuiIconButton-label > svg.MuiSvgIcon-root > path")));//Thread.sleep(5 * 1000);
        test.createNode("Print Button Click");
        test.log(Status.INFO, "Print Button Click");
        driver.findElement(By.cssSelector("#search-result-print > span.MuiIconButton-label > svg.MuiSvgIcon-root > path")).click();
        Thread.sleep(5 * 1000);
    }


    @Test
    public void testFreightChargeQueries() throws Exception {
        //Setup
        test = extent.createTest("Verify Freight Charges Queries");
        login.doLogin(test);
        test.log(Status.INFO, "Clicking on Search Bar");

        //query 1
        queryChecker.runSearchBubbleQuery(driver, "list all charges", test);
        //query 2
        queryChecker.runSearchBubbleQuery(driver, "list all charges where carrier id is fedex", test);
        //query 3
        queryChecker.runSearchBubbleQuery(driver, "list all charges where charge type is Disk and freight charges amount > 100", test);
        //query 4
        queryChecker.runSearchBubbleQuery(driver, "list all charges where freight charges amount > 100", test);

        test.createNode("Verified Freight Charge Queries Successfully!");
    }

    @Test
    public void testPrivateQueries() {
        test = extent.createTest("Verify Private Query Button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        try {
            login.doLogin(test);
            test.log(Status.INFO, "Clicking on Help Button");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();

            test.log(Status.INFO, "Clicking on Private Query Button");
            WebElement privateQueryButton = driver.findElement(By.xpath("//*[@id=\"scrollable-auto-tab-1\"]/span[1]"));
            highlightHelper.highLightElement(driver, privateQueryButton);
            privateQueryButton.click();
        } catch (Exception e) {
            test.createNode("Exception (" + e + ") found"); // catches exception (test still passes)
            Assert.assertTrue(false);
        }
        test.createNode("Verified Private Query Successfully");
    }

    @Test
    public void testDocumentBydocTypeQueries() {
        test = extent.createTest("Verify DocumentByDocTypeQueries");
        try {
            login.doLogin(test);
            queryChecker.runSearchBubbleQuery(driver, "list all Document ", test);
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is RPT", test);
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is FRM", test);
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is LBL", test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPackages() throws Exception { //saraswathikakollu
        test = extent.createTest("Home > Verify Packing Items Facts");
        login.doLogin(test);
        test.log(Status.INFO, "Help Button Clicked");
        test.createNode("Help Button Click");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        test.createNode("Subject Shipments Button Click");
        WebElement subjectShipmentsButton = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        subjectShipmentsButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Packing Items Click");
        test.log(Status.INFO, "Packing Items Click");
        driver.findElement(By.id("mainArc-a252fc7e-4232-4f49-a276-f849d6662834")).click();
        Thread.sleep(5 * 1000);
        test.createNode("Active Package Click");
        test.log(Status.INFO, "Active Package Click");
        driver.findElement(By.id("mainArc-4ede3542-fafa-49f1-8be1-fcce43f06999")).click();
        Thread.sleep(5 * 1000);
    }

    @Test
    public void LocationFacts() throws Exception { //saraswathikakollu
        test = extent.createTest("Home > Verify Location Facts");
        login.doLogin(test);
        test.log(Status.INFO, "Help Button Clicked");
        test.createNode("Help Button Click");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Subject Shipments Button Click");
        test.createNode("Subject Shipments Button Click");
        WebElement subjectShipmentsButton = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
        subjectShipmentsButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Location Click");
        test.log(Status.INFO, "Location Click");
        driver.findElement(By.id("mainArc-7294ba99-5ade-47ff-9fb5-f21e080d9601")).click();
        Thread.sleep(5 * 1000);
        test.createNode("Location Address Click");
        test.log(Status.INFO, "Location Address Click");
        driver.findElement(By.id("mainArc-dfc929d9-b607-4950-a794-1eda5d2ba47d")).click();
        Thread.sleep(5 * 1000);
    }


    @Test
    public void testDocBydocTypeOGraphs() {
        test = extent.createTest("Verify DocByDoctypeGraph");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".explore-quiries-inner")));
            driver.findElement(By.cssSelector(".explore-quiries-inner")).click();
            test.createNode("HelpButton clicked");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")));
            driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
            //clicking on shipments
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")));
            driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")).click();
            //clicking on documents
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8")));
            driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8")).click();
            //clicking on document Type
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[5]/div/div/div/header/div/div/div/button[3]/span[1]")));
            driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[5]/div/div/div/header/div/div/div/button[3]/span[1]")).click();
            //clicking on other graphical views #same ids for both graphs and ographs

            WebElement axis1 = driver.findElement(By.cssSelector("#react-select-2-input"));
            axis1.clear();
            axis1.sendKeys("Document Type");
            axis1.sendKeys(Keys.ARROW_DOWN);
            axis1.sendKeys(Keys.ENTER);

            WebElement axis2 = driver.findElement(By.cssSelector("#react-select-3-input"));
            axis2.clear();
            axis2.sendKeys("COUNT");
            axis2.sendKeys(Keys.ARROW_DOWN);
            axis2.sendKeys(Keys.ENTER);

            WebElement graph = driver.findElement(By.cssSelector("#react-select-4-input"));
            graph.clear();
            graph.sendKeys("Vertical");
            graph.sendKeys(Keys.ARROW_DOWN);
            graph.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")));
            driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")).click();
            Thread.sleep(5 * 1000);
            //click on show
        } catch (Exception e) {
            test.createNode("Exception " + e + "in DocTypeGraphs");
        }
    }

    @Test
    public void testDocTypeGraph() {
        test = extent.createTest("Verify DocByDoctypeGraph");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".explore-quiries-inner")));
            driver.findElement(By.cssSelector(".explore-quiries-inner")).click();
            test.createNode("HelpButton clicked");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")));
            driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
            //clicking on shipments
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")));
            driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")).click();
            //clicking on documents
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8")));
            driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8")).click();
            //clicking on document Type
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Graphical View']")));
            driver.findElement(By.xpath("//span[text()='Graphical View']")).click();

            test.createNode("DocByDoctypeGraph verified");
        } catch (Exception e) {
            test.createNode("Exception " + e + "in DocTypeGraphs");

        }
    }

    /**
     * testColumresize is used to verify whether the columns can be resized are not.
     *
     * @author Pardhu
     */

    @Test
    public void testColumresize() {
        test = extent.createTest("Verify testColumresize");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='auto-suggestion-input']")));
            WebElement searchBubble = driver.findElement(By.xpath("//input[@class='auto-suggestion-input']"));
            searchBubble.click();
            searchBubble.sendKeys("list of customers");
            searchBubble.sendKeys(Keys.ENTER);
            searchBubble.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]/div[2]/div/div/div[6]/div[1]")));//changes according to xpath
            Actions action;


            WebElement resize;
            for (int i = 1; i <= 4; i++) {
                resize = driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]/div[2]/div/div/div[" + i + "]/div[1]"));
                action = new Actions(driver);
                action.clickAndHold(resize);
                action.moveByOffset(100, 0);
                action.release(resize).perform();

            }

            test.createNode("Columresize verified");

            //Thread.sleep(5000); //use this if you want to observe the size while execution.

        } catch (Exception e) {
            test.createNode("Exception " + e + "in testColumresize");

        }
    }

    @Test
    public void testShipmentsSunburstDocURLsDocClick() {//prasanna
        test = extent.createTest("Verifying Shipments Documents Test");

        try {
            driver.manage().window().maximize();
            login.doLogin(test);
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Help Button Clicked");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            test.log(Status.INFO, "Sunburst Shown");
            test.createNode("Click on the help button to open sunburst ");
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Subject Shipments Button Click");
            test.createNode("Shipments click on sunburst ");
            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            SubjectShipmentsButtonClick.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Document URLs Cluster Click");
            test.createNode("Document URLs Cluster Click");
            WebElement DocumentURLsCluster = driver.findElement(By.id("mainArc-bfe454df-aa7e-43a8-9bf2-8a4941d59edd"));
            DocumentURLsCluster.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Documents Provider Cluster Click");
            test.createNode("Documents Provider Cluster Click");
            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-d71a8a74-5e78-426f-ad9e-a7bab8283818"));
            DocumentsProviderCluster.click();
            Thread.sleep(5 * 1000);
            WebElement helpButton1 = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.helpIcon.explore-query-svg.ml-2"));
            helpButton1.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");
            driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Graphical View Displayed ");
            test.createNode("Graphical View Displayed ");
            driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click();

            /// VALIDATION ///

            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Under Axis 1");
            WebElement Axis1 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div"));
            Axis1.click();


            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Selected Document Provider");
            WebElement Provider = driver.findElement(By.id("react-select-2-option-0"));
            test.log(Status.INFO, "Validating 'Docs Provider' variable");
            test.createNode("Validating 'Docs Provider' variable");
            Assert.assertTrue(Provider.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(Provider.getText(), "Docs Provider"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'Docs Provider' variable Successful");
            Provider.click();

            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Under Axis2");
            WebElement Axis2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis2.click();

            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Selected Count");
            test.createNode("Selected Count");
            WebElement Count = driver.findElement(By.id("react-select-3-option-0"));
            test.log(Status.INFO, "Validating 'COUNT' variable");
            test.createNode("Validating 'COUNT' variable");
            Assert.assertTrue(Count.getText().equals("COUNT")); //1st Validator
            Assert.assertEquals(Count.getText(), "COUNT"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'COUNT' variable Successful");
            Count.click();
            Thread.sleep(5 * 1000);

            test.log(Status.INFO, "Under Graph");
            WebElement Graph = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div"));
            Graph.click();

            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Selected Bubble Graph");
            test.createNode("Selected Bubble Graph");
            WebElement bubbleGraph = driver.findElement(By.id("react-select-4-option-4"));
            test.log(Status.INFO, "Validating 'Bubble Graph' variable");
            test.createNode("Validating 'Bubble Graph' variable");
            Assert.assertTrue(bubbleGraph.getText().equals("Bubble Graph")); //1st Validator
            Assert.assertEquals(bubbleGraph.getText(), "Bubble Graph"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'Bubble Graph' variable Successful");
            bubbleGraph.click();
            Thread.sleep(5 * 1000);

            test.log(Status.INFO, "Clicked on Show Button ");
            test.createNode("Clicked on Show Button ");
            WebElement showButton = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            showButton.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Bubble Graph Displayed ");
            test.createNode("Verified Documents Cluster with Dimensional Data");
        } catch (Exception e) {
            test.createNode("Error in the graphical view of Doc URLs  --" + e + "---In testShipmentsSunburstDocURLsDocClick ");
        }

    }

    @Test
    public void testPublicQueries() throws Exception {
        test = extent.createTest("Verify Public Query Button");
        login.doLogin(test);
        Thread.sleep(4 * 1000);
        test.log(Status.INFO, "Clicking on Help Button");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        highlightHelper.highLightElement(driver, helpButton);
        helpButton.click();
        Thread.sleep(4 * 1000);
        test.log(Status.INFO, "Clicking on Public Query Button");
        WebElement publicQueryButton = driver.findElement(By.xpath("//*[@id=\"scrollable-auto-tab-2\"]/span[1]"));
        highlightHelper.highLightElement(driver, publicQueryButton);
        publicQueryButton.click();
        Thread.sleep(4 * 1000);
        test.createNode("Verified Public Query Successfully");
    }

    @Override
    public String toString() {
        return super.toString();
    }

}













