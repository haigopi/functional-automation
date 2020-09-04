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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HomePageAutomation extends TestConfig {

    QueryChecker queryChecker;
    HighlightHelper highlightHelper;
    final int time_to_wait = 30;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        wait = new WebDriverWait(driver, 15);
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
        try {

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
            Thread.sleep(4 * 1000);
            test.log(Status.INFO, "Query Copied");
            WebElement copyQueryBtn = driver.findElement(By.id("copy-current-query-0"));
            highlightHelper.highLightElement(driver, copyQueryBtn);
            copyQueryBtn.click();
            Thread.sleep(7 * 1000);

            /// VALIDATION ///

            WebElement searchBubble = driver.findElement(By.className("search_input"));
            String queryText = searchBubble.getAttribute("value");
            test.log(Status.INFO, "Text in Search Bubble BEFORE reset button clicked (" + queryText + ")");
            WebElement resetButton = driver.findElement(By.id("search-text-reset")); // Reset Button
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
        }
        catch(Exception e)
            {

                e.printStackTrace();
            }
        test.createNode("Verified Reset Button by Query History Search");
        //HTML CODE TO ACCESS
        // <input class="search_input" type="text" name="" placeholder="Search..." value="">

    }


    @Test
    public void testVerifyInternationalCountryOfOrigin() throws Exception {
        test = extent.createTest("Verify International Facts Country Of Origin");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        login.doLogin(test);

        try {
            Thread.sleep(5 * 1000);
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
            catch(Exception e)
            {

                               e.printStackTrace();


            }

        }


    

    @Test
    public void testShipmentsSunburstDocClick() throws Exception { //Haritha
        test = extent.createTest("Verifying Shipments Documents Test");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        login.doLogin(test);
        try {

            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            test.createNode("Help Button Clicked");

            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            SubjectShipmentsButtonClick.click();
            test.createNode("Clicked on Shipments");
            test.log(Status.INFO, "Subject Shipments Button Click");

            WebElement DocumentsCluster = driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            DocumentsCluster.click();
            test.createNode("Documents Cluster Click");
            test.log(Status.INFO, "Documents Cluster Click");

            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-cd5709c6-2d2e-4d24-8c1e-df38a9f9b0e5"));
            DocumentsProviderCluster.click();
            test.createNode("Documents Provider Cluster Click");
            WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton1.click();
            Thread.sleep(5 * 1000);

            WebElement Tabview = driver.findElement(By.id("simple-tab-0"));
            Tabview.click();
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");
            // driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click(); clicking on Tabular view using xpath old one

            WebElement Graphicalview = driver.findElement(By.id("simple-tab-1"));
            Graphicalview.click();
            test.log(Status.INFO, "Graphical View Displayed ");
            test.createNode("Graphical View displayed");
          // driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click(); // clicking on Graphical view using xpath old one

            /// VALIDATION ///

            WebElement Axis1 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div"));
            Axis1.click(); //old one
            test.log(Status.INFO, "Under Axis 1");

            WebElement Provider = driver.findElement(By.id("react-select-2-option-0"));
            test.log(Status.INFO, "Selected Provider");
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
        catch (Exception e)
            {
                e.printStackTrace();
            }

    }


    @Test

    public void testVerifyResetButtonSunburst() throws Exception { //*** Haritha
        test = extent.createTest("Home Page Verify Reset Button by Sunburst");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        try {
            login.doLogin(test);
            test.log(Status.INFO, "Help Button Clicked");

            test.createNode("Clicked on Help button");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton.click();

            test.createNode("Sunburst Shown");
            WebElement Shipmentsbtn = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            Shipmentsbtn.click();
            test.createNode("Clicked on Shipments Cluster");
            test.log(Status.INFO, "Clicked on Shipments");

            WebElement Internationalbtn = driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65"));
            Internationalbtn.click();
            test.log(Status.INFO, "Clicked on International");
            test.createNode("Clicked on International Cluster");

            WebElement Subelement = driver.findElement(By.id("mainArc-7000c84e-b726-405b-ae57-3103e755a869"));
            Subelement.click();
            test.createNode("Clicked on Sub Elements");
            test.log(Status.INFO, "Clicked on Sub element to get the Query");

            WebElement Subelement1 = driver.findElement(By.id("mainArc-a4b796c9-8bbb-4f37-b959-26b2e1dd758e"));
            Subelement1.click();
            test.log(Status.INFO, "Clicked on Sub element to get the Query");

            WebElement Subelement2 = driver.findElement(By.id("mainArc-dcf61afd-31e9-4faa-9e8f-8743a267ac26"));
            Subelement2.click();
            test.log(Status.INFO, "Clicked on Sub element to get the Query");

            driver.findElement(By.id("search-text-reset")).click();
            WebElement Resetbtn = driver.findElement(By.id("search-text-reset"));
            Resetbtn.click();

            test.log(Status.INFO, "Clicked on Reset Button");
            driver.findElement(By.xpath("//input[@name='']")).clear();

        } catch (Exception e) {
            // test.createNode("Exception (" + e.toString() + ") found").fail(e);
            e.printStackTrace();
        }
         test.createNode("Verified Reset Button");
    }



    @Test

    public void testVerifySubjectGuides() throws Exception { //***
        test = extent.createTest("Verifying Subjects Guide ");
        login.doLogin(test);
        try
        {
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Help Button Clicked");
        WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
        helpButton.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Sunburst Shown");
        test.createNode("Verified Subject Guides Successfully!");
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
        test.log(Status.INFO,"Drill down for Sub-elements Displayed");
        }
        catch (Exception e) {
            // test.createNode("Exception (" + e.toString() + ") found").fail(e);
            e.printStackTrace();
        }
    }

    @Test
    public void testDownloadCSVButton() throws Exception { // Geeta
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


    

 

  

    /**
     * testPrivateQueries is used to automate private queries button (verify its existence)
     *
     * @author Sai
     */

    @Test
    public void testPrivateQueries() {
        test = extent.createTest("Verify Private Query Button");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        try {
            login.doLogin(test);
            test.createNode("Clicking on Help Button");
            //test.log(Status.INFO, "Clicking on Help Button");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();

            test.createNode("Clicking on Private Query Button");
            //test.log(Status.INFO, "Clicking on Private Query Button");
            WebElement privateQueryButton = driver.findElement(By.id("scrollable-auto-tab-1"));
          //  WebElement privateQueryButton = driver.findElement(By.xpath("//*[@id=\"scrollable-auto-tab-1\"]/span[1]")); old one used xpath
            highlightHelper.highLightElement(driver, privateQueryButton);
            privateQueryButton.click();
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            Assert.assertTrue(false);
        }
        test.createNode("Verified Private Query Successfully");
    }

    @Test
    public void testDocumentBydocTypeQueries() {//pardhu
        test = extent.createTest("Verify DocumentByDocTypeQueries");
        try {
            login.doLogin(test);
            queryChecker.runSearchBubbleQuery(driver, "list all Document ", test);
            test.createNode("list all Documents verified successfully");
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is RPT", test);
            test.createNode("list all Documents where Document Type is RPT verified successfully");
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is FRM", test);
            test.createNode("list all Documents where Document Type is FRM verified successfully");
            queryChecker.runSearchBubbleQuery(driver, "list all Document where Document Type is LBL", test);
            test.createNode("list all Documents where Document Type is LBL verified successfully");
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
       // WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);

            WebElement helpbtn=driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpbtn));
            helpbtn.click();
            test.createNode("HelpButton clicked");

            WebElement shipment=driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(shipment));
            shipment.click();
            test.createNode("clicked on shipments");
            //clicking on shipments

            WebElement document=driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            wait.until(ExpectedConditions.visibilityOf(document));
            document.click();
            test.createNode("clicked on documents");
            //clicking on documents

            WebElement documenttype=driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8"));
            wait.until(ExpectedConditions.visibilityOf(documenttype));
            documenttype.click();
            test.createNode("clicked on document type");
            //clicking on document Type

            WebElement Ograph=driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[5]/div/div/div/header/div/div/div/button[3]/span[1]"));
            wait.until(ExpectedConditions.visibilityOf(Ograph));
            Ograph.click();
            test.createNode("clicked on other graphical Views");
            //clicking on other graphical views #same ids for both graphs and ographs

            WebElement axis1 = driver.findElement(By.cssSelector("#react-select-2-input"));
            axis1.clear();
            axis1.sendKeys("Document Type");
            axis1.sendKeys(Keys.ARROW_DOWN);
            axis1.sendKeys(Keys.ENTER);
            test.createNode("input given to axis1 successfully");

            WebElement axis2 = driver.findElement(By.cssSelector("#react-select-3-input"));
            axis2.clear();
            axis2.sendKeys("COUNT");
            axis2.sendKeys(Keys.ARROW_DOWN);
            axis2.sendKeys(Keys.ENTER);
            test.createNode("input given to axis2 successfully");


            WebElement graph = driver.findElement(By.cssSelector("#react-select-4-input"));
            graph.clear();
            graph.sendKeys("Vertical");
            graph.sendKeys(Keys.ARROW_DOWN);
            graph.sendKeys(Keys.ENTER);
            test.createNode("input given to graphs as vertical graph");

            WebElement show=driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            wait.until(ExpectedConditions.visibilityOf(show));
            show.click();
            test.createNode("clicked on show");
            test.createNode("OtherGraphs verified successfully");
            //Thread.sleep(5 * 1000);
            //click on show
        } catch (Exception e) {
            test.createNode("Exception " + e + "in DocTypeGraphs");
        }
    }

    @Test
    public void testDocTypeGraph() {
        test = extent.createTest("Verify DocByDoctypeGraph");
       // WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            WebElement helpbtn=driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpbtn));
            helpbtn.click();
            test.createNode("HelpButton clicked");

            WebElement shipment=driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(shipment));
            shipment.click();
            test.createNode("clicked on shipments");
            //clicking on shipments

            WebElement document=driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            wait.until(ExpectedConditions.visibilityOf(document));
            document.click();
            test.createNode("clicked on documents");
            //clicking on documents

            WebElement documenttype=driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8"));
            wait.until(ExpectedConditions.visibilityOf(documenttype));
            documenttype.click();
            test.createNode("clicked on document type");
            //clicking on document Type

            WebElement graphicalView=driver.findElement(By.xpath("//span[text()='Graphical View']"));
            wait.until(ExpectedConditions.visibilityOf(graphicalView));
            graphicalView.click();
            test.createNode("clicked on graphical View");

            test.createNode("DocByDoctypeGraph verified successfully");
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
      //  WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            WebElement searchBubble = driver.findElement(By.xpath("//input[@class='auto-suggestion-input']"));
            wait.until(ExpectedConditions.visibilityOf(searchBubble));
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

            test.createNode("Columresize verified successfully");

            //Thread.sleep(5000); //use this if you want to observe the size while execution.

        } catch (Exception e) {
            test.createNode("Exception " + e + "in testColumresize");

        }
    }

    @Test
    public void testShipmentsDocURLsDocProGraph() {//prasanna
        test = extent.createTest("Verifying Shipments Documents Test");
        WebDriverWait wait = new WebDriverWait(driver,15);
        //driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);


        try {
            driver.manage().window().maximize();
            login.doLogin(test);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf( helpButton));
            //highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            test.log(Status.INFO, "Sunburst Shown");
            test.createNode("Click on the help button to open sunburst ");

            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(SubjectShipmentsButtonClick));
            SubjectShipmentsButtonClick.click();
            test.log(Status.INFO, "Subject Shipments Button Click");
            test.createNode("Shipments click on sunburst ");

            WebElement DocumentURLsCluster = driver.findElement(By.id("mainArc-bfe454df-aa7e-43a8-9bf2-8a4941d59edd"));
            wait.until(ExpectedConditions.visibilityOf(DocumentURLsCluster));
            DocumentURLsCluster.click();
            test.log(Status.INFO, "Document URLs Cluster Click");
            test.createNode("Document URLs Cluster Click");
            Thread.sleep(5*1000);
            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-d71a8a74-5e78-426f-ad9e-a7bab8283818"));
            wait.until(ExpectedConditions.visibilityOf(DocumentsProviderCluster));
            DocumentsProviderCluster.click();
            test.log(Status.INFO, "Documents Provider Cluster Click");
            test.createNode("Documents Provider Cluster Click");
            //Thread.sleep(5*1000);
            WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpButton1));
            highlightHelper.highLightElement(driver, helpButton1);
            helpButton1.click();
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");
            //Thread.sleep(5*1000);
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");

            //WebElement GraphicalView = driver.findElement(By.xpath("//span[text()='Graphical View']"));
            WebElement GraphicalView = driver.findElement(By.xpath("//button[@id='simple-tab-1']/span"));
            wait.until(ExpectedConditions.visibilityOf(GraphicalView));
            GraphicalView.click();
            test.createNode("Graphical view displayed");
            //Thread.sleep(5 * 1000);

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            Assert.assertTrue(false);
            test.createNode("Error in the graphical view of Doc URLs  --" + e + "---In testShipmentsSunburstDocURLsDocClick ");
        }
    }








    @Test
    public void testForValidationOfAllOtherGraphsInDocProv() {//prasanna
        test = extent.createTest("Verifying the all Other GraphicalViews in Doc URLS Doc Providers Test");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
        Actions action =new Actions(driver);


        try {
            driver.manage().window().maximize();
            login.doLogin(test);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton.click();
            test.log(Status.INFO, "Sunburst Shown");
            test.createNode("Click on the help button to open sunburst ");

            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            SubjectShipmentsButtonClick.click();
            test.log(Status.INFO, "Subject Shipments Button Click");
            test.createNode("Shipments click on sunburst ");

            WebElement DocumentURLsCluster = driver.findElement(By.id("mainArc-bfe454df-aa7e-43a8-9bf2-8a4941d59edd"));
            DocumentURLsCluster.click();
            test.log(Status.INFO, "Document URLs Cluster Click");
            test.createNode("Document URLs Cluster Click");
            Thread.sleep(5 * 1000);
            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-d71a8a74-5e78-426f-ad9e-a7bab8283818"));
            DocumentsProviderCluster.click();
            test.log(Status.INFO, "Documents Provider Cluster Click");
            test.createNode("Documents Provider Cluster Click");
            //Thread.sleep(5 * 1000);
            WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton1);
            helpButton1.click();
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");
            //Thread.sleep(5*1000);
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");




            //WebElement OtherG = driver.findElement(By.id("panel1d-header"));
            WebElement OtherG = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/header/div/div/div/button[3]/span[1]"));
            OtherG.click();
            test.createNode("Other Graphical view button click");

            WebElement Axis1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/form/div[1]/div[2]/div/div/div[1]"));
            Axis1.click();
            test.createNode(" click on the Axis 1");

            WebElement DocPro = driver.findElement(By.id("react-select-2-option-0"));
            test.createNode(" Select the Doc Provider in Axis 1");
            //Validation for Drop-Down of Axis 1
            Assert.assertTrue(DocPro.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(DocPro.getText(), "Docs Provider"); // 2nd Validator
            DocPro.click();


            WebElement Axis2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis2.click();
            test.createNode("click on the axis2");

            WebElement count = driver.findElement(By.id("react-select-3-option-0"));
            // Validation for Axis 2 Drop-Down
            test.createNode("Select count in Axis 2");
            Assert.assertTrue(count.getText().equals("COUNT"));
            Assert.assertEquals(count.getText(),"COUNT");
            count.click();

            WebElement Graph1 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph1.click();
            test.createNode(" Graph button selected");
            //Thread.sleep(2*1000);


            WebElement graphSelector1  = driver.findElement(By.id("react-select-4-option-0"));
            Assert.assertTrue(graphSelector1.getText().equals("Vertical Bar Graph")); //1st Validator
            Assert.assertEquals(graphSelector1.getText(), "Vertical Bar Graph");// 2nd Validator
            graphSelector1.click();
            test.createNode(" Vertical bar Graph selected ");
            //Thread.sleep(5*1000);

            WebElement ShowButton = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            ShowButton.click();
            test.createNode("Show button clicked ");
            //Thread.sleep(5*1000);

            //validation for Vertical bar graph displayed or not
            WebElement barG = driver.findElement(By.id("barGraph"));
            highlightHelper.highLightElement(driver, barG);
            Assert.assertTrue(barG.getAttribute("id").equals("barGraph"));//1st Validator
            test.createNode(" display the " + barG.getAttribute("id"));


            WebElement minimise1 = driver.findElement(By.id("panel1d-header"));
            minimise1.click();
            test.createNode("re open the other graph to edit next graph ");



            WebElement Axis12 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/form/div[1]/div[2]/div/div/div[1]"));
            Axis12.click();
            test.createNode(" click on the Axis 1");

            WebElement DocPro1 = driver.findElement(By.id("react-select-2-option-0"));
            test.createNode(" Select the Doc Provider in Axis 1");
            //Validation for Drop-Down of Axis 1
            Assert.assertTrue(DocPro1.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(DocPro1.getText(), "Docs Provider"); // 2nd Validator
            DocPro1.click();


            WebElement Axis21 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis21.click();
            test.createNode("click on the axis2");

            WebElement count1 = driver.findElement(By.id("react-select-3-option-0"));
            // Validation for Axis 2 Drop-Down
            test.createNode("Select count in Axis 2");
            Assert.assertTrue(count1.getText().equals("COUNT"));
            Assert.assertEquals(count1.getText(),"COUNT");
            count1.click();


            WebElement Graph2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph2.click();
            test.createNode(" Graph button selected");


            WebElement graphSelector2   = driver.findElement(By.id("react-select-4-option-1"));
            Assert.assertTrue(graphSelector2.getText().equals("Horizontal Bar Graph")); //1st Validator
            Assert.assertEquals(graphSelector2.getText(), "Horizontal Bar Graph");// 2nd Validator
            graphSelector2.click();
            test.createNode(" Selected Horizontal graph " );

            WebElement ShowButton2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            ShowButton2.click();
            test.createNode("Show button clicked ");

            //validation of Horizontal bar Graph
            WebElement HG = driver.findElement(By.id("horizontalBarGraph"));
            highlightHelper.highLightElement(driver, HG);
            Assert.assertTrue(HG.getAttribute("id").equals("horizontalBarGraph"));//1st Validator
            test.createNode(" Displayed graph is  :-" + HG.getAttribute("id"));
            //Thread.sleep(2*1000); //if you wanna check the graph


            WebElement minimise2 = driver.findElement(By.id("panel1d-header"));
            minimise2.click();
            test.createNode("re open the other graph to edit next graph ");

            WebElement Axis13 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/form/div[1]/div[2]/div/div/div[1]"));
            Axis13.click();
            test.createNode(" click on the Axis 1");

            WebElement DocPro2 = driver.findElement(By.id("react-select-2-option-0"));
            test.createNode(" Select the Doc Provider in Axis 1");
            //Validation for Drop-Down of Axis 1
            Assert.assertTrue(DocPro2.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(DocPro2.getText(), "Docs Provider"); // 2nd Validator
            DocPro2.click();


            WebElement Axis22 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis22.click();
            test.createNode("click on the axis2");

            WebElement count2 = driver.findElement(By.id("react-select-3-option-0"));
            // Validation for Axis 2 Drop-Down
            test.createNode("Select count in Axis 2");
            Assert.assertTrue(count2.getText().equals("COUNT"));
            Assert.assertEquals(count2.getText(),"COUNT");
            count2.click();



            WebElement Graph3 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph3.click();
            test.createNode(" Graph button selected");


            WebElement graphSelector3   = driver.findElement(By.id("react-select-4-option-2"));
            Assert.assertTrue(graphSelector3.getText().equals("Pie Graph")); //1st Validator
            Assert.assertEquals(graphSelector3.getText(), "Pie Graph");// 2nd Validator
            graphSelector3.click();
            test.createNode(" Pie graph selected");

            WebElement ShowButton3 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            ShowButton3.click();
            test.createNode("Show button clicked ");

            //validation of Pie Graph
            WebElement PG = driver.findElement(By.id("pieGraph"));
            highlightHelper.highLightElement(driver, PG);
            Assert.assertTrue(PG.getAttribute("id").equals("pieGraph"));//1st Validator
            test.createNode(" Displayed graph is  :-" + PG.getAttribute("id"));
            //Thread.sleep(2*1000); //Remove this"//" before Thread.sleep ,if you wanna check the graph


            WebElement minimise3 = driver.findElement(By.id("panel1d-header"));
            minimise3.click();
            test.createNode("re open the other graph to edit next graph ");

            WebElement Axis14 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/form/div[1]/div[2]/div/div/div[1]"));
            Axis14.click();
            test.createNode(" click on the Axis 1");

            WebElement DocPro3 = driver.findElement(By.id("react-select-2-option-0"));
            test.createNode(" Select the Doc Provider in Axis 1");
            //Validation for Drop-Down of Axis 1
            Assert.assertTrue(DocPro3.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(DocPro3.getText(), "Docs Provider"); // 2nd Validator
            DocPro3.click();


            WebElement Axis23 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis23.click();
            test.createNode("click on the axis2");

            WebElement count3 = driver.findElement(By.id("react-select-3-option-0"));
            // Validation for Axis 2 Drop-Down
            test.createNode("Select count in Axis 2");
            Assert.assertTrue(count3.getText().equals("COUNT"));
            Assert.assertEquals(count3.getText(),"COUNT");
            count3.click();



            WebElement Graph4 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph4.click();
            test.createNode(" Graph button selected");


            WebElement graphSelector4   = driver.findElement(By.id("react-select-4-option-3"));
            Assert.assertTrue(graphSelector4.getText().equals("Donut Graph")); //1st Validator
            Assert.assertEquals(graphSelector4.getText(), "Donut Graph");// 2nd Validator
            graphSelector4.click();
            test.createNode(" Donut graph selected ");

            WebElement ShowButton4 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            ShowButton4.click();
            test.createNode("Show button clicked ");

            //validation of Donut Graph
            WebElement DG = driver.findElement(By.id("donutGraph"));
            highlightHelper.highLightElement(driver, DG);
            Assert.assertTrue(DG.getAttribute("id").equals("donutGraph"));//1st Validator
            test.createNode(" Displayed graph is  :-" + DG.getAttribute("id"));
            //Thread.sleep(2*1000); //if you wanna check the graph


            WebElement minimise4 = driver.findElement(By.id("panel1d-header"));
            minimise4.click();
            test.createNode("re open the other graph to edit next graph ");

            WebElement Axis15 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/form/div[1]/div[2]/div/div/div[1]"));
            Axis15.click();
            test.createNode(" click on the Axis 1");

            WebElement DocPro4 = driver.findElement(By.id("react-select-2-option-0"));
            test.createNode(" Select the Doc Provider in Axis 1");
            //Validation for Drop-Down of Axis 1
            Assert.assertTrue(DocPro4.getText().equals("Docs Provider")); //1st Validator
            Assert.assertEquals(DocPro4.getText(), "Docs Provider"); // 2nd Validator
            DocPro4.click();


            WebElement Axis24 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div"));
            Axis24.click();
            test.createNode("click on the axis2");

            WebElement count4 = driver.findElement(By.id("react-select-3-option-0"));
            // Validation for Axis 2 Drop-Down
            test.createNode("Select count in Axis 2");
            Assert.assertTrue(count4.getText().equals("COUNT"));
            Assert.assertEquals(count4.getText(),"COUNT");
            count4.click();


            WebElement Graph5 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph5.click();
            test.createNode(" Graph button selected");
            //Thread.sleep(2*1000);


            WebElement BG  = driver.findElement(By.id("react-select-4-option-4"));
            Assert.assertTrue(BG.getText().equals("Bubble Graph")); //1st Validator
            Assert.assertEquals(BG.getText(), "Bubble Graph");// 2nd Validator
            BG.click();
            test.createNode(" Selected graph name is bubble is ");

            WebElement ShowButton5 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
            ShowButton5.click();
            test.createNode("Show button clicked ");



            //validation of Bubble Graph including each bubble in Bubble Graph
            WebElement bubbleG = driver.findElement(By.id("bubbleGraph"));
            highlightHelper.highLightElement(driver, bubbleG);
            Assert.assertTrue(bubbleG.getAttribute("id").equals("bubbleGraph"));//1st Validator
            test.createNode(" Displayed graph is  :-" + bubbleG.getAttribute("id"));
            //Thread.sleep(2*1000); //if you wanna check the graph


            WebElement internal = driver.findElement(By.id("internal-"));
            highlightHelper.highLightElement(driver, internal);
            //WebElement internal = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[4]/div/div[1]/svg/g/g[1]/circle"));
            System.out.println("Rad of the button is:- "+ internal.getAttribute("r"));
            test.createNode("select on thr internal bubble and bubble radious " + internal.getAttribute("r"));

            WebElement ups = driver.findElement(By.id("ups-"));
            highlightHelper.highLightElement(driver, ups);
            System.out.println("Rad of the button is:- "+ ups.getAttribute("r"));
            test.createNode("select  the ups bubble and bubble radious " + ups.getAttribute("r"));

            WebElement FedEx = driver.findElement(By.id("fedex-"));
            highlightHelper.highLightElement(driver, FedEx);
            System.out.println("Rad of the button is:- "+ FedEx.getAttribute("r"));
            test.createNode("select  the FedEx bubble and bubble radious " + FedEx.getAttribute("r"));

            WebElement dhl = driver.findElement(By.id("dhl"));
            highlightHelper.highLightElement(driver, dhl);
            System.out.println("Rad of the button is:- "+ dhl.getAttribute("r"));
            test.createNode("select the dhl bubble and bubble radious " + dhl.getAttribute("r"));




        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            Assert.assertTrue(false);
            test.createNode("Error in the all other graphical view validation test  --" + e + "---In  testForValidationOfAllOtherGraphsInDocProv ");
        }
    }



    /**
         * testPublicQueries is used to automate public queries button (verify its existence)
         *
         * @author Haritha
         */

    @Test
    public void testPublicQueries() throws Exception {
        test = extent.createTest("Verify Public Query Button");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
        try {
            login.doLogin(test);
            //Thread.sleep(4 * 1000);
            test.createNode("Clicking on Help Button");
            //test.log(Status.INFO, "Clicking on Help Button");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();

            //Thread.sleep(4 * 1000);
            test.createNode("Clicking on Public Query Button");
            //test.log(Status.INFO, "Clicking on Public Query Button");
            WebElement publicQueryButton = driver.findElement(By.id("scrollable-auto-tab-2"));
            highlightHelper.highLightElement(driver, publicQueryButton);
            publicQueryButton.click();
            //Thread.sleep(4 * 1000);
        } catch (Exception e) {
            test.createNode("Caught [ " + e + " ] exception in testPublicQueries");
        }
        test.createNode("Verified Public Query Successfully");
    }

    @Test
    public void testDocumentsQueries() throws Exception {
        test = extent.createTest("Verify Documents Queries");
        try {
            login.doLogin(test);

        queryChecker.runSearchBubbleQuery(driver, "list all documents", test);
        queryChecker.runSearchBubbleQuery(driver, "list all documents where provider is FedEx", test);
        queryChecker.runSearchBubbleQuery(driver, "list all documents where delivery number ends with 003", test);
        queryChecker.runSearchBubbleQuery(driver, "list all documents where document type is LBL ", test);

        test.createNode("Verified Documents Queries Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDragDropCol(){
        test = extent.createTest("Verify testColumremoving");
        try {
            login.doLogin(test);
            WebElement searchBubble = driver.findElement(By.xpath("//input[@class='auto-suggestion-input']"));
            wait.until(ExpectedConditions.visibilityOf(searchBubble));
            searchBubble.click();
            searchBubble.sendKeys("list of customers");
            searchBubble.sendKeys(Keys.ENTER);
            searchBubble.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[3]/div")));//changes according to xpath
            Actions action=new Actions(driver);
            WebElement ROWID_1Col=driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[3]/div"));
            WebElement sam=driver.findElement(By.id("simple-tab-0"));
            //while(ROWID_1Col.isDisplayed())
            //{
                action.clickAndHold(ROWID_1Col).moveByOffset(-100,-100).release().build().perform();
                //action.dragAndDrop(ROWID_1Col,sam);
                //action.dragAndDropBy(ROWID_1Col,0,0).build().perform();
                //action.release();
                //action.perform();
            //}
            if(ROWID_1Col.isDisplayed()){
                System.err.println("Failed its not removed");
            }
            test.createNode("Columremoving verified successfully");

            //Thread.sleep(5000); //use this if you want to observe the size while execution.

        } catch (Exception e) {
            e.printStackTrace();
            test.createNode("Exception " + e + "in testColumresize").fail(e);
        }

    }
}









