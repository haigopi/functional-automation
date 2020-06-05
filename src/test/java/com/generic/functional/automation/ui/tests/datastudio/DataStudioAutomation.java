package com.generic.functional.automation.ui.tests.datastudio;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DataStudioAutomation extends TestConfig {
    @BeforeMethod
    public void DataStudio() throws Exception {
        test = extent.createTest("Data Studio ");
        driver.manage().window().maximize();
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

    }

    @Test(priority = 0)
    public void DataStudioButtonClick() throws Exception {
        test = extent.createTest("Data Studio Button Click");
        login.doLogin(test);
        Thread.sleep(5 * 1000);
        test.createNode("Data Studio Button Clicked");
        WebElement DataStudioButton = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/header/div/div/div[3]/div[2]/div/div[2]/span"));
        DataStudioButton.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 1)
    public void DataStudioSmartViewAndInternalView() throws Exception {
        test = extent.createTest("Data Studio Smart & InternalView ", "Smart View And Internal View");
        test.createNode("International Cluster Click to Show Internal View");
        WebElement InternationalCluster = driver.findElement(By.cssSelector("#table-International > text"));
        InternationalCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Smart View Click For Expand Smart View");
        WebElement SmartViewClickForExpand = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root"));
        SmartViewClickForExpand.click();
        Thread.sleep(5 * 1000);
        test.createNode("Smart View Click For Collapse Smart View");
        WebElement SmartViewClickCollapse = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root > path"));
        SmartViewClickCollapse.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 2)
    public void DataStudioFreightChargesClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Freight Charges Cluster ", "Foreign Key & Primary Key In Internal View");
        test.createNode("Freight Charges Cluster Click");
        WebElement FreightChargesCluster = driver.findElement(By.cssSelector("#table-Freight\\ Charges"));
        FreightChargesCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key   Freight Charges Identifier Element Click");
        WebElement PrimaryKeyFreightChargesIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyFreightChargesIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Shipping Number Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 3)
    public void DataStudioInternationalClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio International Cluster ", "Foreign Key & Primary Key In Internal View");
        test.createNode("International Cluster Click");
        WebElement InternationalCluster = driver.findElement(By.cssSelector("#table-International > text"));
        InternationalCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Handling Element Click");
        WebElement ForeignKeyHandling = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        ForeignKeyHandling.click();
        Thread.sleep(5 * 1000);
        test.log(Status.INFO, "Foreign key Shipping  Element Click");
        WebElement ForeignKeyShipping = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[13]/span"));
        ForeignKeyShipping.click();
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 4)
    public void DataStudioDocumentsClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Documents Cluster ", "Foreign Key & Primary Key In Internal View");
        test.createNode("Documents Cluster Click");
        WebElement DocumentsCluster = driver.findElement(By.cssSelector("#table-Documents > text"));
        DocumentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key Documents Identifier Element Click");
        WebElement PrimaryKeyDocumentsIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyDocumentsIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[5]/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 5)
    public void DataStudioDocumentsURLsClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio DocumentsURLs Cluster", "Foreign Key & Primary Key In Internal View");
        test.createNode(" DocumentsURLs Cluster Click");
        WebElement DocumentsURLsCluster = driver.findElement(By.cssSelector("#table-Document\\ URLs > text"));
        DocumentsURLsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key DocumentsURLs IdentifierElement  Click");
        WebElement PrimaryKeyDocumentsURLsIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyDocumentsURLsIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Handling unit Element  Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[5]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 6)
    public void DataStudioPackingItemsClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Packing Items Cluster", "Foreign Key & Primary Key In Internal View");
        test.createNode("PackingItems Cluster Click");
        WebElement PackingItemsCluster = driver.findElement(By.cssSelector("#table-Packing\\ Items > text"));
        PackingItemsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key PackingItem Identifier Element Click");
        WebElement PrimaryKeyPackingItemIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyPackingItemIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key HandlingUnit Element Click");
        WebElement ForeignKeyHandlingUnit = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyHandlingUnit.click();
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 7)
    public void DataStudioPackagesClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Packages Cluster", "Foreign Key & Primary Key In Internal View");
        test.createNode("Packages Cluster Click");
        WebElement PackagesCluster = driver.findElement(By.cssSelector("#table-Packages"));
        PackagesCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key HandlingUnit Element Click");
        WebElement PrimaryKeyHandlingUnit = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyHandlingUnit.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[2]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key  ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);

    }

    @Test(priority = 8)
    public void DataStudioLocationClusterPrimaryKeyAndForeignKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Location Cluster", "Primary Key & ForeignKey In Internal View");
        test.createNode("Location Cluster Click");
        WebElement LocationCluster = driver.findElement(By.cssSelector("#table-Location"));
        LocationCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary Key Plant Identifier Element Click");
        WebElement PrimaryKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        PrimaryKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
    }

    @Test(priority = 9)
    public void DataStudioShipmentsClusterForeignKeyAndPrimaryKeyInInternalView() throws Exception {
        test = extent.createTest("Data Studio Shipments Cluster", "Foreign Key & Primary Key In Internal View");
        test.createNode("Shipments Cluster Click");
        WebElement ShipmentsCluster = driver.findElement(By.cssSelector("#table-Shipments"));
        ShipmentsCluster.click();
        Thread.sleep(5 * 1000);
        test.createNode("Primary key ShippingNumber Element Click");
        WebElement ForeignKeyShippingNumber = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button/span"));
        ForeignKeyShippingNumber.click();
        Thread.sleep(5 * 1000);
        test.createNode("Foreign key Plant Identifier Element Click");
        WebElement ForeignKeyPlantIdentifier = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/button[3]/span"));
        ForeignKeyPlantIdentifier.click();
        Thread.sleep(5 * 1000);
    }
}

