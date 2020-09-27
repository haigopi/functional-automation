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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QueriesAutomation extends TestConfig {

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

    @Test(groups = {"smokeTest"})
    public void testDocumentsQueries() {
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

    /**
     * testFreightChareQueries is used to run some queries in search bubble
     *
     * @author Haritha
     */
    @Test
    public void testFreightChargeQueries() throws Exception {
        //Setup

        test = extent.createTest("Verify Freight Charges Queries");
        try {
            driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
            login.doLogin(test);
            test.log(Status.INFO, "Clicking on Search Bar");
            //query 1
            queryChecker.runSearchBubbleQuery(driver, "list all charges", test);
            test.createNode("list all Freight Charges verified successfully");
            //query 2
            queryChecker.runSearchBubbleQuery(driver, "list all charges where carrier id is fedex", test);
            test.createNode("list all charges where carrier id is fedex verified successfully");
            //query 3
            queryChecker.runSearchBubbleQuery(driver, "list all charges where charge type is Disk and freight charges amount > 100", test);
            test.createNode("list all charges where charge type is Disk and freight charges amount > 100 verified successfully");
            //query 4
            queryChecker.runSearchBubbleQuery(driver, "list all charges where carrier id is ups frieght", test);
            test.createNode("list all charges where carrier id is ups frieght verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.createNode("Verified Freight Charge Queries Successfully!");
    }

    @Test (groups = {"smokeTest"})
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
}
