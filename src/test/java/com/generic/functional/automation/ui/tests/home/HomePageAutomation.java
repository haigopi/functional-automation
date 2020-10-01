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
    /**
     * testVerifyResetbuttonSearchBar - On clicking Reset button Query in the Search tab should get Cleared.
     */
    @Test (groups = {"smokeTest"})
    public void testVerifyResetButtonSearchBar() throws Exception { //Haritha
        test = extent.createTest("Home > Verify Reset Button / Clear the Search Bubble");
        try {
            login.doLogin(test);
            Thread.sleep(5 * 1000);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            test.log(Status.INFO, "Clicked on Help Button");
            test.createNode("Clicked on Help button");
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            Thread.sleep(5 * 1000);

            WebElement e1 = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            test.log(Status.INFO, "Clicked on Shipments");
            test.createNode("Clicked on Shipments");
            e1.click();
            Thread.sleep(4 * 1000);

            WebElement international = driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65"));
            international.click();
            test.log(Status.INFO, "Clicked on International");
            test.createNode("Clicked on International");
            Thread.sleep(4 * 1000);

            WebElement e12 = driver.findElement(By.id("mainArc-fa581093-0286-4f62-a4a1-5abf224fa8f1"));
            e12.click();
            test.log(Status.INFO, "Clicked on Account Number");
            test.createNode("clicked on Account number");
            Thread.sleep(4 * 1000);

            WebElement searchButton = driver.findElement(By.className("search_icon"));
            highlightHelper.highLightElement(driver, searchButton);
            searchButton.click();
            test.log(Status.INFO, "Clicked on Search Button");
            test.createNode("Clicked on Search button");
            Thread.sleep(4 * 1000); //next line error (works now)


            WebElement hoverElement = driver.findElement(By.id("copyexecute-current-query-0"));
            hoverElement.click();
            highlightHelper.highLightElement(driver, hoverElement);
            hoverElement.click();
            Thread.sleep(4 * 1000);
            test.log(Status.INFO, "Query Copied");

            WebElement copyQueryBtn = driver.findElement(By.id("copy-current-query-0"));
            highlightHelper.highLightElement(driver, copyQueryBtn);
            copyQueryBtn.click();
            test.createNode("Clicked on Copy Query button");
            Thread.sleep(4 * 1000);

            /// VALIDATION ///

            WebElement searchBubble = driver.findElement(By.className("search_input"));
            String queryText = searchBubble.getAttribute("value");
            test.log(Status.INFO, "Text in Search Bubble BEFORE reset button clicked (" + queryText + ")");

            WebElement resetButton = driver.findElement(By.id("search-text-reset")); // Reset Button
            highlightHelper.highLightElement(driver, resetButton);
            resetButton.click();
            Thread.sleep(3 * 1000);
            test.log(Status.INFO, "Reset Button Clicked");
            test.createNode("clicked on Reset button");

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
        } catch (Exception e) {
            // test.createNode("Exception (" + e.toString() + ") found").fail(e);
            e.printStackTrace();
        }
        test.createNode("Verified Reset Button by Query History Search");
        //HTML CODE TO ACCESS
        // <input class="search_input" type="text" name="" placeholder="Search..." value="">

    }
    /**
     * testVerifyInternationalCountryOfOrigin is used to Verifying table information when CountryOfOrigin is selected)
     *
     * @author Haritha
     */

    @Test (enabled = false, groups = {"smokeTest"})
    public void testVerifyInternationalCountryOfOrigin() throws Exception {
        test = extent.createTest("Verify International Facts Country Of Origin");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        try {
            login.doLogin(test);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton.click();
            test.log(Status.INFO, "Help button Clicked");
            test.createNode("Help Button clicked");
            Thread.sleep(5 * 1000);

            test.log(Status.INFO, "Sunburst Shown");
            WebElement International = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            International.click();
            test.log(Status.INFO, "International Cluster Clicked on the Sunburst");
            test.createNode("International cluster clicked");
            Thread.sleep(5 * 1000);

            WebElement Countryoforigin = driver.findElement(By.id("mainArc-71ef3c15-be01-454d-bd1e-c59d13904a65"));
            Countryoforigin.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Country of Origin Element Clicked on the Sunburst");
            test.createNode("Country of Origin clicked");

            WebElement helpButtoncountry = driver.findElement(By.id("mainArc-466ed1b9-526b-45c7-a02c-e6d419ef606f"));
            helpButtoncountry.click();
            Thread.sleep(5 * 1000);

            WebElement TabularView = driver.findElement(By.id("simple-tab-0"));
            TabularView.click();
            Thread.sleep(4*1000);

            /// VALIDATION ///
            WebElement tr = driver.findElement(By.id("total-records-count"));
            String value = tr.getText();
            System.out.println("total record->"+value);
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
                Thread.sleep(2 * 1000);
                test.createNode("Verified the table information is displayed when Country of origin is selected. ");

                WebElement Graphicalview = driver.findElement(By.id("simple-tab-1"));
                Graphicalview.click(); // Clicks on Graphical View
                test.createNode("Grahical view clicked");
                Thread.sleep(2 * 1000);

                WebElement Ograph = driver.findElement(By.id("simple-tab-2"));
                Ograph.click(); // Clicks on Other Graphical View old one
                test.createNode("Other Graphical view clicked");
                Thread.sleep(2 * 1000);

                WebElement Axis1 = driver.findElement(By.className("other-graph-axis-1-value"));
                Axis1.click(); // Click Axis 1
                Thread.sleep(3 * 1000);
                test.createNode("clciked on Axis1");
                driver.findElement(By.id("react-select-2-option-0")).click(); // Click origin country
                Thread.sleep(2 * 1000);

                WebElement Axis2 = driver.findElement(By.className("other-graph-axis-2-value"));
                Axis2.click(); // Click Axis 2
                test.createNode("clciked on Axis2");
                Thread.sleep(3 * 1000);
                WebElement count = driver.findElement(By.id("react-select-3-option-0"));
                count.click(); // Click count
                Thread.sleep(5 * 1000);

                WebElement Graph = driver.findElement(By.className("other-graph-type"));
                Graph.click(); //Click graph
                test.createNode("clicked on graph");
                Thread.sleep(3 * 1000);

                WebElement bubblegraph = driver.findElement(By.id("react-select-4-option-4"));
                bubblegraph.click(); // Click bubble Graph
                Thread.sleep(4 * 1000);

                WebElement Show = driver.findElement(By.className("MuiButton-label")); // Click Show
                test.createNode("clicked ON Show button ");
                Show.click();
            }


        } catch(
                Exception e)

        {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            // e.printStackTrace();
        }

    }
    /**
     * testVerifyShipmentsSunburstDocClick is used to Verify the table information when Documents cluster is selected)
     *
     * @author Haritha
     **/
    @Test (groups = {"smokeTest"})
    public void testShipmentsSunburstDocClick() throws Exception { //Haritha
        test = extent.createTest("Verifying Shipments Documents Test");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        try {
            login.doLogin(test);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            test.createNode("Help Button Clicked");
            Thread.sleep(3*1000);

            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            SubjectShipmentsButtonClick.click();
            test.createNode("Clicked on Shipments");
            test.log(Status.INFO, "Subject Shipments Button Click");
            Thread.sleep(3*1000);

            WebElement DocumentsCluster = driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            DocumentsCluster.click();
            test.createNode("Documents Cluster Click");
            test.log(Status.INFO, "Documents Cluster Click");
            Thread.sleep(3*1000);

            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-cd5709c6-2d2e-4d24-8c1e-df38a9f9b0e5"));
            DocumentsProviderCluster.click();
            test.createNode("Documents Provider Cluster Click");
            Thread.sleep(3*1000);

            WebElement helpButton1 = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton1.click();
            Thread.sleep(3 * 1000);

            WebElement Tabview = driver.findElement(By.id("simple-tab-0"));
            Tabview.click();
            test.log(Status.INFO, "Tabular View displayed");
            test.createNode("Tabular View displayed");
            Thread.sleep(3*1000);

            WebElement Graphicalview = driver.findElement(By.id("simple-tab-1"));
            Graphicalview.click();
            test.log(Status.INFO, "Graphical View Displayed ");
            test.createNode("Graphical View displayed");
            Thread.sleep(3*1000);

            WebElement Ograph = driver.findElement(By.id("simple-tab-2"));
            Ograph.click();
            test.log(Status.INFO, "Other Graphical View Displayed ");
            test.createNode("Other Graphical View displayed");

            WebElement Axis1 = driver.findElement(By.className("other-graph-axis-1-value"));
            Axis1.click(); //old one
            test.log(Status.INFO, "Under Axis 1");
            Thread.sleep(4*1000);

            WebElement Provider = driver.findElement(By.id("react-select-2-option-0"));
            test.log(Status.INFO, "Selected Provider");
            test.log(Status.INFO, "Validating 'Provider' variable");
            Assert.assertTrue(Provider.getText().equals("Provider")); //1st Validator
            Assert.assertEquals(Provider.getText(), "Provider"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'Provider' variable Successful");
            Provider.click();
            Thread.sleep(5 * 1000);

            WebElement Axis2 = driver.findElement(By.className("other-graph-axis-2-value"));
            Axis2.click();
            test.log(Status.INFO, "Under Axis2");
            Thread.sleep(5 * 1000);

            WebElement Count = driver.findElement(By.id("react-select-3-option-0"));
            test.log(Status.INFO, "Validating 'COUNT' variable");
            test.log(Status.INFO, "Selected Count");
            Assert.assertTrue(Count.getText().equals("COUNT")); //1st Validator
            Assert.assertEquals(Count.getText(), "COUNT"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'COUNT' variable Successful");
            Count.click();
            Thread.sleep(5 * 1000);

            WebElement Graph = driver.findElement(By.className("other-graph-type"));
            Graph.click();
            test.log(Status.INFO, "Under Graph");
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Selected Bubble Graph");

            WebElement bubbleGraph = driver.findElement(By.id("react-select-4-option-4"));
            test.log(Status.INFO, "Validating 'Bubble Graph' variable");
            Assert.assertTrue(bubbleGraph.getText().equals("Bubble Graph")); //1st Validator
            Assert.assertEquals(bubbleGraph.getText(), "Bubble Graph"); // 2nd Validator
            test.log(Status.INFO, "Validation of 'Bubble Graph' variable Successful");
            bubbleGraph.click();
            Thread.sleep(5 * 1000);

            WebElement Showbutton = driver.findElement(By.className("MuiButton-label"));
            Showbutton.click();
            test.log(Status.INFO, "Clicked on Show Button ");
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Bubble Graph Displayed ");
            test.createNode("Verified Documents Cluster with Dimensional Data");
        }
        catch (Exception e)
        {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);

        }

    }
    /**
     * testVerifyResetButtonSunburst is used to Verify the Reset Button by selecting a query from sunburst)
     *
     * @author Haritha
     */
    @Test (groups = {"smokeTest"})
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
            Thread.sleep(3*1000);
            test.log(Status.INFO, "Clicked on International");
            test.createNode("Clicked on International Cluster");

            WebElement Subelement = driver.findElement(By.id("mainArc-7000c84e-b726-405b-ae57-3103e755a869"));
            Subelement.click();
            Thread.sleep(3*1000);
            test.createNode("Clicked on Sub Elements");
            test.log(Status.INFO, "Clicked on Sub element to get the Query");
            Thread.sleep(3*1000);

            WebElement Subelement1 = driver.findElement(By.id("mainArc-a4b796c9-8bbb-4f37-b959-26b2e1dd758e"));
            Subelement1.click(); // Error!
            Thread.sleep(3*1000);
            test.log(Status.INFO, "Clicked on Sub element to get the Query");
            Thread.sleep(3*1000);

            WebElement Subelement2 = driver.findElement(By.id("mainArc-dcf61afd-31e9-4faa-9e8f-8743a267ac26"));
            Subelement2.click();
            Thread.sleep(3*1000);
            test.log(Status.INFO, "Clicked on Sub element to get the Query");
            Thread.sleep(3*1000);

            driver.findElement(By.id("search-text-reset")).click();
            WebElement Resetbtn = driver.findElement(By.id("search-text-reset"));
            Resetbtn.click();
            Thread.sleep(3*1000);
            highlightHelper.highLightElement(driver,Resetbtn);
            test.createNode("clicked on Reset Button");
            test.log(Status.INFO, "Clicked on Reset Button");


        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            // e.printStackTrace();
        }
        test.createNode("Verified Reset Button");
    }
    /**
     * testVerifySubjectGuides is used to Verify the SubjectGuides is displayed when HelpButton is clicked)
     *
     * @author Haritha
     */
    @Test (groups = {"smokeTest"})
    public void testVerifySubjectGuides() throws Exception { //***
        test = extent.createTest("Verifying Subjects Guide ");
        login.doLogin(test);
        try
        {
            Thread.sleep(5 * 1000);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            helpButton.click();
            test.log(Status.INFO, "Help Button Clicked");
            test.createNode("Help button clicked");
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Sunburst Shown");
            WebElement Dov = driver.findElement(By.className("domain_of_values"));
            Dov.click();
            Thread.sleep(5 * 1000);
            test.log(Status.INFO, "Clicked on Domain Values");
            test.createNode("clicked on Domain Values");
            WebElement Ds = driver.findElement(By.className("drill_down"));Ds.click();
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
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
        }
        test.createNode("Verified Subject Guides Successfully!");
    }

    @Test (groups = {"smokeTest"})
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

    @Test (groups = {"regressionTest"})
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
            highlightHelper.highLightElement(driver, privateQueryButton);
            privateQueryButton.click();
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
        }
        test.createNode("Verified Private Query Successfully");
    }


    @Test (groups = {"regressionTest"})
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

    @Test (groups = {"regressionTest"})
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

    /**
     * testPublicQueries is used to automate public queries button (verify its existence)
     *
     * @author Haritha
     */

    @Test (groups = {"regressionTest"})
    public void testPublicQueries() throws Exception {
        test = extent.createTest("Verify Public Query Button");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
        try {
            login.doLogin(test);
            //Thread.sleep(4 * 1000);
            test.createNode("Clicking on Help Button");
            test.log(Status.INFO, "Clicking on Help Button");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();

            //Thread.sleep(4 * 1000);
            test.createNode("Clicking on Public Query Button");
            test.log(Status.INFO, "Clicking on Public Query Button");
            WebElement publicQueryButton = driver.findElement(By.id("scrollable-auto-tab-2"));
            highlightHelper.highLightElement(driver, publicQueryButton);
            publicQueryButton.click();
            //Thread.sleep(4 * 1000);
        } catch (Exception e) {
            test.createNode("Caught [ " + e + " ] exception in testPublicQueries");
        }
        test.createNode("Verified Public Query Successfully");
    }

    /**
     * testVerifyExecuteNLPQueryButtonPrivateQueries is used to verify if Execute NLP Query Button(hover element) is working(executing) under private queries
     *
     * @author Teja
     */

    @Test (groups = {"regressionTest"})
    public void testVerifyExecuteNLPQueryButtonPrivateQueries(){
        test = extent.createTest("Verify Execute NLP Query Button under Private Queries");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        try {
            login.doLogin(test);
            test.createNode("Help Button CLicked");
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpButton));
            helpButton.click();

            test.createNode("Private Queries Button clicked");
            WebElement privateQueryButton = driver.findElement(By.id("scrollable-auto-tab-1"));
            wait.until(ExpectedConditions.visibilityOf(privateQueryButton));
            privateQueryButton.click();

            test.createNode("Execute NLP Query Button clicked under a query");
            WebElement nlpqueryButton = driver.findElement(By.id("execute-private-query-9"));
            highlightHelper.highLightElement(driver, nlpqueryButton);
            actions.moveToElement(nlpqueryButton).click().perform();

            test.createNode("Scroll to view tabular view and other results");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div/div/div[4]")));
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            test.createNode("Tabular view displayed");
            test.createNode("Verified Execute NLP Query Button Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
        }
    }

    @Test (enabled = false, groups = {"regressionTest"})
    public void TestAutoSuggest() throws Exception {
        test = extent.createTest("Verify AutoPopulate Search Bar");
        try {
            login.doLogin(test);
            //Find search bubble and send keys
            WebElement searchBubble = driver.findElement(By.xpath("//input[@value='']"));
            searchBubble.sendKeys("list all");

            WebElement selectedItem = driver.findElement(By.className("highlight"));
            String highlightedText = selectedItem.getText();
            System.out.println("Highlighted Text in Drop-Down: " + highlightedText);
            Thread.sleep(5*1000 );

            searchBubble.sendKeys(Keys.ENTER); //to select first row
            String searchBubbleText = searchBubble.getAttribute("value");
            System.out.println("Text in Search Bubble: " + searchBubbleText);
            //Compare the two to check if the "highlighted query" is executed
            System.out.println(searchBubbleText.equalsIgnoreCase(highlightedText));
            Thread.sleep(3*1000 );
            WebElement search = driver.findElement(By.className("search_icon"));
            search.click();
            Thread.sleep(7*1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}









