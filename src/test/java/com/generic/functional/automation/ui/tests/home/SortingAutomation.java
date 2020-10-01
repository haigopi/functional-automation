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
public class SortingAutomation extends TestConfig {

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
     * @Description : testColumresize is used to verify whether the columns can be resized are not.
     *
     * @author Pardhu
     */

    @Test(groups = {"regressionTest"})
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

    /**
     * removing Column by drag drop
     *
     * @author Pardhu
     */
    @Test(groups = {"regressionTest"})
    public void testDragDropCol() {
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
            Actions action = new Actions(driver);
            WebElement ROWID_1Col = driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[3]/div"));
            WebElement sam = driver.findElement(By.id("simple-tab-0"));
            //while(ROWID_1Col.isDisplayed())
            //{
            action.clickAndHold(ROWID_1Col).moveByOffset(-100, -100).release().build().perform();
            //action.dragAndDrop(ROWID_1Col,sam);
            //action.dragAndDropBy(ROWID_1Col,0,0).build().perform();
            //action.release();
            //action.perform();
            //}
            if (ROWID_1Col.isDisplayed()) {
                System.err.println("Failed its not removed");
            }
            test.createNode("Columremoving verified successfully");

            //Thread.sleep(5000); //use this if you want to observe the size while execution.

        } catch (Exception e) {
            e.printStackTrace();
            test.createNode("Exception " + e + "in testColumresize").fail(e);
        }

    }
    /**
     * @Description: testVerifyRadioButton validate the Expand and Collapse functionality of Tabular view
     *
     * @author: Prasanna
     */

    @Test(groups = {"smokeTest"})
    public void testVerifyRadioButton() {//prasanna
        test = extent.createTest("Verifying the Radio button collapse and expand the Query result Test");
        driver.manage().timeouts().implicitlyWait(time_to_wait, TimeUnit.SECONDS);

        try {
            login.doLogin(test);

            queryChecker.runSearchBubbleQuery(driver, "list of packages", test);
            test.createNode("Display the Query result Table ");
            WebElement collapseButton = driver.findElement(By.cssSelector("div.query-text > svg.MuiSvgIcon-root"));
            collapseButton.click();
            test.createNode("collapse the query result");
            Thread.sleep(2 * 1000);
            WebElement expandButton = driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.search-show-more"));
            expandButton.click();
            Thread.sleep(2 * 1000);
            WebElement ColumnName = driver.findElement(By.xpath("//*[text()='ROWID']"));
            test.createNode(" Test is passes if it displays true ");
            if (ColumnName.isDisplayed()) {
                test.createNode("Radio button is working successfully ");
            } else {
                throw new Exception("fail the tabular view radio button");

            }


        } catch (Exception e) {
            test.createNode("Exception (" + e.toString() + ") found").fail(e);
            test.createNode("Error in validation of Radio button   --" + e + "---In testVerifyRadioButton  ");
        }


    }
}






