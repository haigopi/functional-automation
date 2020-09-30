package com.generic.functional.automation.ui.tests.datastudio;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataStudioAutomation extends TestConfig {

    final int time_to_wait = 60;

    @BeforeClass
    /**
     * BeforeClass is using to login the A4Data
     */
    public void DataStudioLogin() throws Exception {
        test = extent.createTest("Data Studio till login");
        login.doLogin(test);

    }
    /**
     *BeforeMethod is using to click on datastudio button and subject shipments reusing all test cases and we are refreshing the A4Data page after every test case
     * */

     @BeforeMethod
    public void DataStudioANDSubjectShipments() {
        test = extent.createTest("Data Studio Button Click and Subject Shipments for reuse");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 15);
            driver.get("https://a4data-qe.netlify.app/databaseManager/");
            driver.navigate().refresh();//refreshing the screen so no need of login every time
            test.createNode("Refreshing :\"A4data Screen\"");
            Thread.sleep(5 * 1000);

            test.createNode("Data Studio Button Clicked");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("databaseManager")));
            WebElement dataStudioButton = driver.findElement(By.id("databaseManager"));
            dataStudioButton.click();
            Assert.assertTrue(dataStudioButton.getText().equals("Data Studio"));//validation 1
            Assert.assertEquals(dataStudioButton.getText(), "Data Studio");//validation 2
            test.log(Status.INFO, "data studio button text =" + dataStudioButton.getText());//Data Studio
            Thread.sleep(7 * 1000);

            test.createNode("Smart View Is Displayed  ");

            test.createNode("Subject Shipments Cluster Click ");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject-Shipments")));
            WebElement subjectShipmentsCluster = driver.findElement(By.id("plusCircle-text-subject-Shipments"));
            subjectShipmentsCluster.click();
            Assert.assertTrue(subjectShipmentsCluster.getText().equals("Shipments"));//validation 1
            Assert.assertEquals(subjectShipmentsCluster.getText(), "Shipments");//validation 2
            test.log(Status.INFO, "Subject Shipments Cluster text = " + subjectShipmentsCluster.getText());//Shipments
            Thread.sleep(5 * 1000);


        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }
    }

    /**
     * DataStudioSmartViewAndInternalView is used to automate SmartView And InternalView buttons (verify its existence)
     *
     * @author priyanka
     */


    @Test(priority = 1, groups = {"smokeTest"}) //priyanka
    public void DataStudioSmartViewAndInternalView() {
        test = extent.createTest("Data Studio Smart & InternalView ", "Smart View Expand & Collapse & Internal View");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 15);

            test.createNode("International Cluster Click to Show  Working of Internal View");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-International")));
            WebElement internationalCluster = driver.findElement(By.id("plusCircle-text-table-International")); //Error!
            internationalCluster.click();
            //  test.log(Status.INFO,"International Cluster Click"+internationalCluster.getText());
            Thread.sleep(5 * 1000);

            test.createNode("Smart View Click For Expand Smart View");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header > svg.MuiSvgIcon-root ")));
            WebElement smartViewClickExpand = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root "));//id not there so used  css
            smartViewClickExpand.click();
            // test.log(Status.INFO,"Smart View Click text ="+smartViewClickExpand.getText());
            Thread.sleep(5 * 1000);

            test.createNode("Smart View Click For collapse Smart View");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header > svg.MuiSvgIcon-root > path ")));
            WebElement smartViewClickCollapse = driver.findElement(By.cssSelector("header > svg.MuiSvgIcon-root > path"));//id not there so used  css
            smartViewClickCollapse.click();
            //test.log(Status.INFO,"Smart View Click text ="+smartViewClickCollapse.getText());
            Thread.sleep(5 * 1000);

            test.createNode("internal view collapse");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.rootContainer main.content.after-login-container:nth-child(3) div.MuiContainer-root div.content.pb-10 div.MuiGrid-root.clPanels.MuiGrid-direction-xs-column.MuiGrid-grid-lg-12 > div.MuiGrid-root:nth-child(2)")));
            WebElement internalViewCollapse = driver.findElement(By.cssSelector("div.rootContainer main.content.after-login-container:nth-child(3) div.MuiContainer-root div.content.pb-10 div.MuiGrid-root.clPanels.MuiGrid-direction-xs-column.MuiGrid-grid-lg-12 > div.MuiGrid-root:nth-child(2)"));
            //id not there so used  css
            internalViewCollapse.click();
            // test.log(Status.INFO,"internal View Click text ="+internalViewCollapse.getText());
            Thread.sleep(5 * 1000);

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     * DataStudioFreightChargesClusterForeignKeyAndPrimaryKeyInInternalView()
     *
     * This test is used to automate DataStudio-Subject shipments-Freight Charges Cluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */


    @Test(priority = 2, groups = {"regressionTest"}) //priyanka
    public void DataStudioFreightChargesClusterForeignKeyAndPrimaryKeyInInternalView() {
        test = extent.createTest("Data Studio Freight Charges Cluster Foreign Key & Primary Key In Internal View");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 15);

            test.createNode("Freight Charges Cluster Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Freight Charges")));
            WebElement freightChargesCluster = driver.findElement(By.id("plusCircle-text-table-Freight Charges")); //Error!
            freightChargesCluster.click();
            Assert.assertTrue(freightChargesCluster.getText().equals("Freight Charges"));//validation 1
            Assert.assertEquals(freightChargesCluster.getText(), "Freight Charges");//validation 2
            test.log(Status.INFO, " Freight Charges Cluster text =" + freightChargesCluster.getText());//Freight Charges
            Thread.sleep(5 * 1000);

            // before it was there  in application but not now so commenting this lines
//            test.createNode("Primary Key   Freight Charges Identifier Element Click");
//            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Freight-Charges-Identifier")));
//            WebElement primaryKeyFreightChargesIdentifier = driver.findElement(By.id("primaryKey-Freight-Charges-Identifier"));
//            primaryKeyFreightChargesIdentifier.click();
//            Assert.assertTrue(primaryKeyFreightChargesIdentifier.getText().equals("Freight .."));//validation 1
//            Assert.assertEquals(primaryKeyFreightChargesIdentifier.getText(), "Freight ..");//validation 2
//            test.log(Status.INFO, "  primaryKey Freight Charges Cluster text =" + primaryKeyFreightChargesIdentifier.getText());//Freight ..
//            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Shipping Number Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Shipping-Number")));
            WebElement foreignKeyShippingNumber = driver.findElement(By.id("foreignKey-Shipping-Number"));
            foreignKeyShippingNumber.click();
            Assert.assertTrue(foreignKeyShippingNumber.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(foreignKeyShippingNumber.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, " Foreign key Freight Charges Cluster text =" + foreignKeyShippingNumber.getText());//Shipping..
            Thread.sleep(5 * 1000);

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }


    }

    /**
     * DataStudioInternationalClusterForeignAndPrimaryKey()
     *
     * This test is used to automate DataStudio-Subject shipments- International Cluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 3) //priyanka
    public void DataStudioInternationalClusterForeignAndPrimaryKey() {
        test = extent.createTest("Data Studio International Cluster Foreign Key & Primary Key In Internal View");
        //WebDriverWait wait = new WebDriverWait(driver, 30);
         driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            test.createNode("International Cluster Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-International")));
            WebElement internationalCluster = driver.findElement(By.id("plusCircle-text-table-International"));
            internationalCluster.click();
            Assert.assertTrue(internationalCluster.getText().equals("International"));//validation 1
            Assert.assertEquals(internationalCluster.getText(), "International");//validation 2
            test.log(Status.INFO, "International Cluster text =" + internationalCluster.getText());//International
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Handling Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Handling-Unit")));
            WebElement foreignKeyHandling = driver.findElement(By.id("foreignKey-Handling-Unit"));
            foreignKeyHandling.click();
            Assert.assertTrue(foreignKeyHandling.getText().equals("Handling.."));//validation 1
            Assert.assertEquals(foreignKeyHandling.getText(), "Handling..");//validation 2
            test.log(Status.INFO, "Foreign key Handling Element text =" + foreignKeyHandling.getText());//Handling..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Shipping  Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Shipping-Number")));
            WebElement foreignKeyShipping = driver.findElement(By.id("foreignKey-Shipping-Number"));
            foreignKeyShipping.click();
            Assert.assertTrue(foreignKeyShipping.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(foreignKeyShipping.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, "Foreign key Shipping  Element text =" + foreignKeyShipping.getText());//Shipping..
            Thread.sleep(5 * 1000);


            test.createNode("Primary Key & Foreign Key Displayed For International Cluster");
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     * DataStudioDocumentsClusterForeignAndPrimaryKey()
     *
     * This test is used to automate Data Studio-Subject shipments- Documents Cluster Foreign Key And Primary Key buttons(verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 4) //priyanka
    public void DataStudioDocumentsClusterForeignAndPrimaryKey() {
        test = extent.createTest("Data Studio Documents Cluster Foreign Key & Primary Key In Internal View");
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            test.createNode("Documents Cluster Click");
            //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Documents")));
            WebElement documentsCluster = driver.findElement(By.id("plusCircle-text-table-Documents"));
            documentsCluster.click();
            Assert.assertTrue(documentsCluster.getText().equals("Documents"));//validation 1
            Assert.assertEquals(documentsCluster.getText(), "Documents");//validation 2
            test.log(Status.INFO, "Documents Cluster text=" + documentsCluster.getText());//Documents
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key Documents Identifier Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Document-Identifier")));
            WebElement primaryKeyDocumentsIdentifier = driver.findElement(By.id("primaryKey-Document-Identifier"));
            primaryKeyDocumentsIdentifier.click();
            Assert.assertTrue(primaryKeyDocumentsIdentifier.getText().equals("Document.."));//validation 1
            Assert.assertEquals(primaryKeyDocumentsIdentifier.getText(), "Document..");//validation 2
            test.log(Status.INFO, "Primary Key Documents Identifier Element text =" + primaryKeyDocumentsIdentifier.getText());//Document..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Plant Identifier Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Plant-Identifier")));
            WebElement foreignKeyPlantIdentifier = driver.findElement(By.id("foreignKey-Plant-Identifier"));
            foreignKeyPlantIdentifier.click();
            Assert.assertTrue(foreignKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(foreignKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "Foreign key Plant Identifier Element text =" + foreignKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key ShippingNumber Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Shipping-Number")));
            WebElement foreignKeyShippingNumber = driver.findElement(By.id("foreignKey-Shipping-Number"));
            foreignKeyShippingNumber.click();
            Assert.assertTrue(foreignKeyShippingNumber.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(foreignKeyShippingNumber.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, "Foreign key ShippingNumber Element text =" + foreignKeyShippingNumber.getText());//Shipping..
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key & Foreign Key Displayed For DocumentsCluster");
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     *  DataStudioDocumentsURLsClusterForeignAndPrimaryKey()
     *
     * This test is used to automate DataStudio-Subject shipments- Documents URLs Cluster ForeignKey And PrimaryKey buttons(verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 5) //priyanka
    public void DataStudioDocumentsURLsClusterForeignAndPrimaryKey() {
        test = extent.createTest("Data Studio DocumentsURLs Cluster Foreign Key & Primary Key In Internal View");
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            test.createNode(" Data Studio DocumentsURLs Cluster Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Document URLs")));
            WebElement documentsURLsCluster = driver.findElement(By.id("plusCircle-text-table-Document URLs"));
            documentsURLsCluster.click();
            Assert.assertTrue(documentsURLsCluster.getText().equals("Document URLs"));//validation 1
            Assert.assertEquals(documentsURLsCluster.getText(), "Document URLs");//validation 2
            test.log(Status.INFO, " Data Studio DocumentsURLs Cluster text =" + documentsURLsCluster.getText());//Document URLs
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key DocumentsURLs IdentifierElement  Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Document-URL-Identifier")));
            WebElement primaryKeyDocumentsURLsIdentifier = driver.findElement(By.id("primaryKey-Document-URL-Identifier"));
            primaryKeyDocumentsURLsIdentifier.click();
            Assert.assertTrue(primaryKeyDocumentsURLsIdentifier.getText().equals("Document.."));//validation 1
            Assert.assertEquals(primaryKeyDocumentsURLsIdentifier.getText(), "Document..");//validation 2
            test.createNode("text on primary Key Documents URLs Identifier=" + primaryKeyDocumentsURLsIdentifier.getText());//Document..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Shipping Number Element  Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Shipping-Number")));
            WebElement foreignKeyShippingNumber = driver.findElement(By.id("foreignKey-Shipping-Number"));
            foreignKeyShippingNumber.click();
            Assert.assertTrue(foreignKeyShippingNumber.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(foreignKeyShippingNumber.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, "Foreign key Shipping Number Element text=" + foreignKeyShippingNumber.getText());//Shipping..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Plant Identifier Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Plant-Identifier")));
            WebElement foreignKeyPlantIdentifier = driver.findElement(By.id("foreignKey-Plant-Identifier"));
            foreignKeyPlantIdentifier.click();
            Assert.assertTrue(foreignKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(foreignKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "Foreign key Plant Identifier Element text =" + foreignKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key & Foreign Key Displayed For DocumentsURLs Cluster ");
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     * DataStudioPackingItemsClusterForeignAndPrimaryKey()
     *
     * This test is used to automate DataStudio-Subject shipments- PackingItems Cluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 6) //priyanka
    public void DataStudioPackingItemsClusterForeignAndPrimaryKey() {
        test = extent.createTest("Data Studio Packing Items Cluster Foreign Key & Primary Key In Internal View");
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            test.createNode("PackingItems Cluster Click");
            WebElement packingItemsClusterButton = driver.findElement(By.id("plusCircle-text-table-Packing Items"));
            packingItemsClusterButton.click();
            Assert.assertTrue(packingItemsClusterButton.getText().equals("Packing Items"));//validation 1
            Assert.assertEquals(packingItemsClusterButton.getText(), "Packing Items");//validation 2
            test.log(Status.INFO, "PackingItems Cluster text =" + packingItemsClusterButton.getText());//Packing Items
            // action.moveToElement(packingItemsClusterButton).click().perform();
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key PackingItem Identifier Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Packing-Item-Identifier")));
            WebElement primaryKeyPackingItemIdentifierButton = driver.findElement(By.id("primaryKey-Packing-Item-Identifier"));
            primaryKeyPackingItemIdentifierButton.click();

            Assert.assertTrue(primaryKeyPackingItemIdentifierButton.getText().equals("Packing .."));//validation 1
            Assert.assertEquals(primaryKeyPackingItemIdentifierButton.getText(), "Packing ..");//validation 2
            test.log(Status.INFO, "Primary Key PackingItem Identifier Element text=" + primaryKeyPackingItemIdentifierButton.getText());//Packing ..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Plant Identifier Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Plant-Identifier")));
            WebElement foreignKeyPlantIdentifier = driver.findElement(By.id("foreignKey-Plant-Identifier"));
            foreignKeyPlantIdentifier.click();
            Assert.assertTrue(foreignKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(foreignKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "Foreign key Plant Identifier Element text=" + foreignKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key HandlingUnit Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Handling-Unit")));
            WebElement foreignKeyHandlingUnit = driver.findElement(By.id("foreignKey-Handling-Unit"));
            foreignKeyHandlingUnit.click();
            Assert.assertTrue(foreignKeyHandlingUnit.getText().equals("Handling.."));//validation 1
            Assert.assertEquals(foreignKeyHandlingUnit.getText(), "Handling..");//validation 2
            test.log(Status.INFO, "Foreign key HandlingUnit Element text = " + foreignKeyHandlingUnit.getText());//Handling..
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key & Foreign Key Displayed For PackingItems Cluster ");

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     * DataStudioPackagesClusterForeignKeyPrimaryKey()
     *
     * This test is used to automate DataStudio-Subject Shipments- PackagesClusterCluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 7) //priyanka
    public void DataStudioPackagesClusterForeignKeyPrimaryKey() {
        test = extent.createTest("Data Studio Packages Cluster", "Foreign Key & Primary Key In Internal View");
        /// WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {

            test.createNode("Packages Cluster Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Packages")));
            WebElement packagesCluster = driver.findElement(By.id("plusCircle-text-table-Packages"));
            packagesCluster.click();
            Assert.assertTrue(packagesCluster.getText().equals("Packages"));//validation 1
            Assert.assertEquals(packagesCluster.getText(), "Packages");//validation 2
            test.log(Status.INFO, "Packages Cluster text" + packagesCluster.getText());//Packages
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key HandlingUnit Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Handling-Unit")));
            WebElement primaryKeyHandlingUnit = driver.findElement(By.id("primaryKey-Handling-Unit"));
            primaryKeyHandlingUnit.click();
            Assert.assertTrue(primaryKeyHandlingUnit.getText().equals("Handling.."));//validation 1
            Assert.assertEquals(primaryKeyHandlingUnit.getText(), "Handling..");//validation 2
            test.log(Status.INFO, "Primary Key HandlingUnit Element text=" + primaryKeyHandlingUnit.getText());//Handling..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Plant Identifier Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Plant-Identifier")));
            WebElement foreignKeyPlantIdentifier = driver.findElement(By.id("foreignKey-Plant-Identifier"));
            foreignKeyPlantIdentifier.click();
            Assert.assertTrue(foreignKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(foreignKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "Foreign key Plant Identifier Element text =" + foreignKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key  ShippingNumber Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Shipping-Number")));
            WebElement foreignKeyShippingNumber = driver.findElement(By.id("foreignKey-Shipping-Number"));
            foreignKeyShippingNumber.click();
            Assert.assertTrue(foreignKeyShippingNumber.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(foreignKeyShippingNumber.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, "Foreign key  ShippingNumber Element text =" + foreignKeyShippingNumber.getText());//Shipping..
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key & Foreign Key Displayed For Packages Cluster ");
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }

    }

    /**
     * DataStudioLocationClusterPrimaryAndForeignKey()
     *
     * This test is used to automate DataStudio-Subject shipments- Location Cluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 8) //priyanka
    public void DataStudioLocationClusterPrimaryAndForeignKey() {
        test = extent.createTest("Data Studio Location Cluster", "Primary Key & ForeignKey In Internal View");
        // WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {
            test.createNode("Location Cluster Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Location")));
            WebElement locationCluster = driver.findElement(By.id("plusCircle-text-table-Location"));
            locationCluster.click();
            Assert.assertTrue(locationCluster.getText().equals("Location"));//validation 1
            Assert.assertEquals(locationCluster.getText(), "Location");//validation 2
            test.log(Status.INFO, "Location Cluster text validation =" + locationCluster.getText());//Location
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key Plant Identifier Element Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Plant-Identifier")));
            WebElement primaryKeyPlantIdentifier = driver.findElement(By.id("primaryKey-Plant-Identifier"));
            primaryKeyPlantIdentifier.click();
            Thread.sleep(5 * 1000);
            Assert.assertTrue(primaryKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(primaryKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "validation Primary Key Plant Identifier Element text  validation=" + primaryKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode(" Primary Key Displayed For Location Cluster ");

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }
    }

    /**
     * DataStudioShipmentsClusterForeignAndPrimaryKey()
     *
     * This test is used to automate DataStudio-Subject shipments- Shipments Cluster ForeignKey And PrimaryKey buttons (verify its existence)
     *
     * @author priyanka
     */

    @Test(priority = 9) //priyanka
    public void DataStudioShipmentsClusterForeignAndPrimaryKey() {
        test = extent.createTest("Data Studio Shipments Cluster Foreign Key & Primary Key In Internal View");
        //WebDriverWait wait = new WebDriverWait(driver, 30);
         driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);//this is global so no need to mention multiple times
        //implicitlyWait (or) wait is not working so using Thread
        try {

            test.createNode("Shipments Cluster Click");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table-Shipments")));
            WebElement shipmentsCluster = driver.findElement(By.id("plusCircle-text-table-Shipments"));
            shipmentsCluster.click();
            Assert.assertTrue(shipmentsCluster.getText().equals("Shipments"));//validation 1
            Assert.assertEquals(shipmentsCluster.getText(), "Shipments");//validation 2
            test.log(Status.INFO, "Shipments Cluster text validation =" + shipmentsCluster.getText());//Shipments
            Thread.sleep(5 * 1000);

            test.createNode("Primary key ShippingNumber Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("primaryKey-Shipping-Number")));
            WebElement primaryKeyShippingNumber = driver.findElement(By.id("primaryKey-Shipping-Number"));
            primaryKeyShippingNumber.click();
            String ShippingNumberActual = driver.getTitle();
            String ShippingNumberExpected = "Shipping Number";
            if (ShippingNumberActual.equals(ShippingNumberExpected)) {
                test.createNode("Primary key ShippingNumber Element title validation  pass" + ShippingNumberActual);
            } else {
                test.createNode( "Primary key ShippingNumber Element title validation Failed");
            }

            Assert.assertTrue(primaryKeyShippingNumber.getText().equals("Shipping.."));//validation 1
            Assert.assertEquals(primaryKeyShippingNumber.getText(), "Shipping..");//validation 2
            test.log(Status.INFO, "Primary key ShippingNumber Element text validation =" + primaryKeyShippingNumber.getText());//Shipping..
            Thread.sleep(5 * 1000);

            test.createNode("Foreign key Plant Identifier Element Click");
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foreignKey-Plant-Identifier")));
            WebElement foreignKeyPlantIdentifier = driver.findElement(By.id("foreignKey-Plant-Identifier"));
            foreignKeyPlantIdentifier.click();
            String plantIdentifierActual = driver.getTitle();
            String plantIdentifierExpected = "Plant Identifier";
            if (plantIdentifierActual.equals(plantIdentifierExpected)) {
                test.createNode("Foreign key Plant Identifier Element title validation  pass");
                System.out.println("Foreign key Plant Identifier Element title validation  pass" + driver.getTitle());
            } else {
                test.createNode("Foreign key Plant Identifier Element title validation Failed");
            }
            Assert.assertTrue(foreignKeyPlantIdentifier.getText().equals("Plant Id.."));//validation 1
            Assert.assertEquals(foreignKeyPlantIdentifier.getText(), "Plant Id..");//validation 2
            test.log(Status.INFO, "Foreign key Plant Identifier Element text Validation =" + foreignKeyPlantIdentifier.getText());//Plant Id..
            Thread.sleep(5 * 1000);

            test.createNode("Primary Key & Foreign Key Displayed For Shipments Cluster ");
        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e); // catches exception (test still passes)
            Assert.assertTrue(false);
        }
    }
}