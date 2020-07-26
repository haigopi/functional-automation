package com.generic.functional.automation.ui.tests.datastudio;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DataStudioAutomation extends TestConfig {

    @Test(priority = 1)
    public void DataStudioSmartView() throws Exception {
        test = extent.createTest("Data Studio Button Click Smart View");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        test.createNode("Smart View Is Displayed  ");
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 2)
    public void DataStudioSmartViewAndInternalView() throws Exception {
        test = extent.createTest("Data Studio Smart & InternalView ", "Smart View Expand & Expand And Internal View");
//       driver.get("https://a4data-qe.netlify.app/databaseManager/");
//       driver.navigate().refresh();
//       test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("International Cluster Click to Show  Working of Internal View");
        WebElement InternationalCluster = driver.findElement(By.cssSelector("#table-International > text"));
        InternationalCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Smart View Click For Expand Smart View");
        WebElement SmartViewClickForExpand = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root"));
        SmartViewClickForExpand.click();
        Thread.sleep(5 * 1000);
        test.createNode("Smart View Click For Expand Smart View");
        WebElement SmartViewClickCollapse = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root > path"));
        SmartViewClickCollapse.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 3)
    public void DataStudioFreightChargesClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Freight Charges Cluster Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//      driver.navigate().refresh();
//      test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);

        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Freight Charges Cluster Click");
        WebElement FreightChargesCluster = driver.findElement(By.cssSelector("#table-Freight\\ Charges"));
        FreightChargesCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key   Freight Charges Identifier Element Click");
        WebElement PrimaryKeyFreightChargesIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyFreightChargesIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Shipping Number Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyShippingNumber.click();
        test.createNode("Primary Key & Foreign Key Displayed For Freight Charges Cluster ");
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 4)
    public void DataStudioInternationalClusterForeignAndPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio International Cluster Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//        driver.navigate().refresh();
//        test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("International Cluster Click");
        WebElement InternationalCluster = driver.findElement(By.cssSelector("#table-International > text"));
        InternationalCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Handling Element Click");
        WebElement ForeignKeyHandling = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        ForeignKeyHandling.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Shipping  Element Click");
        WebElement ForeignKeyShipping = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[13]/span"));
        ForeignKeyShipping.click();
        test.createNode("Primary Key & Foreign Key Displayed For International Cluster");
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 5)
    public void DataStudioDocumentsClusterForeignAndPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio Documents Cluster Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//        driver.navigate().refresh();
//        test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Documents Cluster Click");
        WebElement DocumentsCluster = driver.findElement(By.cssSelector("#table-Documents > text"));
        DocumentsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key Documents Identifier Element Click");
        WebElement PrimaryKeyDocumentsIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyDocumentsIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[5]/span"));
        ForeignKeyShippingNumber.click();
        test.createNode("Primary Key & Foreign Key Displayed For DocumentsCluster");
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 6)
    public void DataStudioDocumentsURLsClusterForeignAndPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio DocumentsURLs Cluster Foreign Key & Primary Key In Internal View");
        //driver.get("https://a4data-qe.netlify.app/databaseManager/");
        //driver.navigate().refresh();
        //test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode(" Data Studio DocumentsURLs Cluster Click");
        WebElement DocumentsURLsCluster = driver.findElement(By.cssSelector("#table-Document\\ URLs > text"));
        DocumentsURLsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key DocumentsURLs IdentifierElement  Click");
        WebElement PrimaryKeyDocumentsURLsIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyDocumentsURLsIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Handling unit Element  Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[5]/span"));
        ForeignKeyPlantIdentifier.click();
        test.createNode("Primary Key & Foreign Key Displayed For DocumentsURLs Cluster ");
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 7)
    public void DataStudioPackingItemsClusterForeignAndPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio Packing Items Cluster Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//        driver.navigate().refresh();
//        test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("PackingItems Cluster Click");
        WebElement PackingItemsCluster = driver.findElement(By.cssSelector("#table-Packing\\ Items > text"));
        PackingItemsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key PackingItem Identifier Element Click");
        WebElement PrimaryKeyPackingItemIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyPackingItemIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key HandlingUnit Element Click");
        WebElement ForeignKeyHandlingUnit = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyHandlingUnit.click();
        test.createNode("Primary Key & Foreign Key Displayed For PackingItems Cluster ");
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 8)
    public void DataStudioPackagesClusterForeignKeyPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio Packages Cluster", "Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//        driver.navigate().refresh();
//        test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Packages Cluster Click");
        WebElement PackagesCluster = driver.findElement(By.cssSelector("#table-Packages"));
        PackagesCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key HandlingUnit Element Click");
        WebElement PrimaryKeyHandlingUnit = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyHandlingUnit.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key  ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyShippingNumber.click();
        test.createNode("Primary Key & Foreign Key Displayed For Packages Cluster ");
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 9)
    public void DataStudioLocationClusterPrimaryAndForeignKey() throws Exception {
        test = extent.createTest("Data Studio Location Cluster", "Primary Key & ForeignKey In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//        driver.navigate().refresh();
//        test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Location Cluster Click");
        WebElement LocationCluster = driver.findElement(By.cssSelector("#table-Location"));
        LocationCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary Key Plant Identifier Element Click");
        WebElement PrimaryKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyPlantIdentifier.click();
        test.createNode(" Primary Key Displayed For Location Cluster ");
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 10)
    public void DataStudioShipmentsClusterForeignAndPrimaryKey() throws Exception {
        test = extent.createTest("Data Studio Shipments Cluster Foreign Key & Primary Key In Internal View");
//        driver.get("https://a4data-qe.netlify.app/databaseManager/");
//       driver.navigate().refresh();
//       test.createNode("Refreshing :\"A4data Screen\"");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
        test.createNode("Subject Shipments Cluster Click ");
        WebElement SubjectShipmentsCluster = driver.findElement(By.cssSelector("#subject-Shipments > text"));
        SubjectShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Shipments Cluster Click");
        WebElement ShipmentsCluster = driver.findElement(By.cssSelector("#table-Shipments"));
        ShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Primary key ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyPlantIdentifier.click();
        test.createNode("Primary Key & Foreign Key Displayed For Shipments Cluster ");
        Thread.sleep(5 * 1000);
    }
}
