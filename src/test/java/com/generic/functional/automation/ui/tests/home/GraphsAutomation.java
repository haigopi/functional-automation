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
public class GraphsAutomation extends TestConfig {

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
     * testDocBydocTypeOGraphs is use to verify the graphs.
     *
     * @author Pardhu
     */
    @Test(groups = {"regressionTest"})
    public void testDocBydocTypeOGraphs() {
        test = extent.createTest("Verify DocByDoctypeGraph");
        // WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);

            WebElement helpbtn = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpbtn));
            helpbtn.click();
            test.createNode("HelpButton clicked");

            WebElement shipment = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(shipment));
            shipment.click();
            test.createNode("clicked on shipments");
            //clicking on shipments

            WebElement document = driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            wait.until(ExpectedConditions.visibilityOf(document));
            document.click();
            test.createNode("clicked on documents");
            //clicking on documents

            WebElement documenttype = driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8"));
            wait.until(ExpectedConditions.visibilityOf(documenttype));
            documenttype.click();
            test.createNode("clicked on document type");
            //clicking on document Type

            WebElement Ograph = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[5]/div/div/div/header/div/div/div/button[3]/span[1]"));
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

            WebElement show = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span"));
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

    @Test (enabled = false, groups = {"regressionTest"})
    public void testDocTypeGraph() {
        test = extent.createTest("Verify DocByDoctypeGraph");
        // WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            login.doLogin(test);
            WebElement helpbtn = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpbtn));
            helpbtn.click();
            test.createNode("HelpButton clicked");

            WebElement shipment = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(shipment));
            shipment.click();
            test.createNode("clicked on shipments");
            //clicking on shipments

            WebElement document = driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5"));
            wait.until(ExpectedConditions.visibilityOf(document));
            document.click();
            test.createNode("clicked on documents");
            //clicking on documents

            WebElement documenttype = driver.findElement(By.id("mainArc-287afee1-7e35-4f10-a768-4d44610ecea8"));
            wait.until(ExpectedConditions.visibilityOf(documenttype));
            documenttype.click();
            test.createNode("clicked on document type");
            //clicking on document Type

            WebElement graphicalView = driver.findElement(By.xpath("//span[text()='Graphical View']"));
            wait.until(ExpectedConditions.visibilityOf(graphicalView));
            graphicalView.click();
            test.createNode("clicked on graphical View");

            test.createNode("DocByDoctypeGraph verified successfully");
        } catch (Exception e) {
            test.createNode("Exception " + e + "in DocTypeGraphs");

        }
    }


    @Test(groups = {"smokeTest"})
    public void testShipmentsDocURLsDocProGraph() {//prasanna
        test = extent.createTest("Verifying Shipments Documents Test");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
        try {
            driver.manage().window().maximize();
            login.doLogin(test);
            WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
            wait.until(ExpectedConditions.visibilityOf(helpButton));
            //highlightHelper.highLightElement(driver, helpButton);
            helpButton.click();
            test.log(Status.INFO, "Sunburst Shown");
            test.createNode("Click on the help button to open sunburst ");

            WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
            wait.until(ExpectedConditions.visibilityOf(SubjectShipmentsButtonClick));
            SubjectShipmentsButtonClick.click();
            test.log(Status.INFO, "Subject Shipments Button Click");
            test.createNode("Shipments click on sunburst ");
            Thread.sleep(2 * 1000);

            WebElement DocumentURLsCluster = driver.findElement(By.id("mainArc-bfe454df-aa7e-43a8-9bf2-8a4941d59edd"));
            wait.until(ExpectedConditions.visibilityOf(DocumentURLsCluster));
            DocumentURLsCluster.click();
            test.log(Status.INFO, "Document URLs Cluster Click");
            test.createNode("Document URLs Cluster Click");
            Thread.sleep(5 * 1000);
            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-d71a8a74-5e78-426f-ad9e-a7bab8283818"));
            wait.until(ExpectedConditions.visibilityOf(DocumentsProviderCluster));
            DocumentsProviderCluster.click();
            test.log(Status.INFO, "Documents Provider Cluster Click");
            test.createNode("Documents Provider Cluster Click");
            Thread.sleep(2 * 1000);
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
            test.createNode("Error in the graphical view of Doc URLs  --" + e + "---In testShipmentsSunburstDocURLsDocClick ");
        }
    }


    @Test(groups = {"regressionTest"})
    public void testForValidationOfAllOtherGraphsInDocProv() {//prasanna
        test = extent.createTest("Verifying the all Other GraphicalViews in Doc URLS Doc Providers Test");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);
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
            Thread.sleep(2 * 1000);
            WebElement DocumentURLsCluster = driver.findElement(By.id("mainArc-bfe454df-aa7e-43a8-9bf2-8a4941d59edd"));
            DocumentURLsCluster.click();
            test.log(Status.INFO, "Document URLs Cluster Click");
            test.createNode("Document URLs Cluster Click");
            Thread.sleep(5 * 1000);
            WebElement DocumentsProviderCluster = driver.findElement(By.id("mainArc-d71a8a74-5e78-426f-ad9e-a7bab8283818"));
            DocumentsProviderCluster.click();
            test.log(Status.INFO, "Documents Provider Cluster Click");
            test.createNode("Documents Provider Cluster Click");
            Thread.sleep(2 * 1000);
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
            Assert.assertEquals(count.getText(), "COUNT");
            count.click();

            WebElement Graph1 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph1.click();
            test.createNode(" Graph button selected");
            //Thread.sleep(2*1000);

            WebElement graphSelector1 = driver.findElement(By.id("react-select-4-option-0"));
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
            Assert.assertEquals(count1.getText(), "COUNT");
            count1.click();

            WebElement Graph2 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph2.click();
            test.createNode(" Graph button selected");

            WebElement graphSelector2 = driver.findElement(By.id("react-select-4-option-1"));
            Assert.assertTrue(graphSelector2.getText().equals("Horizontal Bar Graph")); //1st Validator
            Assert.assertEquals(graphSelector2.getText(), "Horizontal Bar Graph");// 2nd Validator
            graphSelector2.click();
            test.createNode(" Selected Horizontal graph ");

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
            Assert.assertEquals(count2.getText(), "COUNT");
            count2.click();

            WebElement Graph3 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph3.click();
            test.createNode(" Graph button selected");

            WebElement graphSelector3 = driver.findElement(By.id("react-select-4-option-2"));
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
            Assert.assertEquals(count3.getText(), "COUNT");
            count3.click();

            WebElement Graph4 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph4.click();
            test.createNode(" Graph button selected");

            WebElement graphSelector4 = driver.findElement(By.id("react-select-4-option-3"));
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
            Assert.assertEquals(count4.getText(), "COUNT");
            count4.click();

            WebElement Graph5 = driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div"));
            Graph5.click();
            test.createNode(" Graph button selected");
            //Thread.sleep(2*1000);

            WebElement BG = driver.findElement(By.id("react-select-4-option-4"));
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

            WebElement internal = driver.findElement(By.id("internal"));
            highlightHelper.highLightElement(driver, internal);
            //WebElement internal = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[3]/div/div/div/div[3]/div/div[4]/div/div[1]/svg/g/g[1]/circle"));
            System.out.println("Rad of the button is:- " + internal.getAttribute("r"));
            test.createNode("select on thr internal bubble and bubble radious " + internal.getAttribute("r"));

            WebElement ups = driver.findElement(By.id("ups"));
            highlightHelper.highLightElement(driver, ups);
            System.out.println("Rad of the button is:- " + ups.getAttribute("r"));
            test.createNode("select  the ups bubble and bubble radious " + ups.getAttribute("r"));

            WebElement FedEx = driver.findElement(By.id("fedex"));
            highlightHelper.highLightElement(driver, FedEx);
            System.out.println("Rad of the button is:- " + FedEx.getAttribute("r"));
            test.createNode("select  the FedEx bubble and bubble radious " + FedEx.getAttribute("r"));

            WebElement dhl = driver.findElement(By.id("dhl"));
            highlightHelper.highLightElement(driver, dhl);
            System.out.println("Rad of the button is:- " + dhl.getAttribute("r"));
            test.createNode("select the dhl bubble and bubble radious " + dhl.getAttribute("r"));

        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            test.createNode("Error in the all other graphical view validation test  --" + e + "---In  testForValidationOfAllOtherGraphsInDocProv ");
        }
    }
}















