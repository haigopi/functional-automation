package com.generic.framework.ui.helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import sun.tools.jconsole.Tab;

public class QueryChecker {
    public static void runSearchBubbleQuery(WebDriver driver, String query, ExtentTest test) throws Exception { // Table xpath necessary for table validation
        WebElement searchBubble = driver.findElement(By.xpath("//input[@name='']"));
        searchBubble.click();
        String[] splited = query.split(" ");
        Thread.sleep(1000 * 5);
        test.log(Status.INFO, "Typing " + query);
        for(int i = 0; i < splited.length; i++) {
            searchBubble.sendKeys(splited[i] + " ");
            Thread.sleep(500);

        }
        Thread.sleep(1000 * 3);
        test.log(Status.INFO, "Typed " + searchBubble.getAttribute("value"));
        searchBubble.sendKeys(Keys.ENTER);
        test.log(Status.INFO, "Successfully validated");
        Thread.sleep(1000 * 5);
        String col_xpath = "";
        //TableChecker.rowValidator(driver, test, table_xpath); // if table xpath changes, use this method: table xpath currently - //*[@id="query-search-result-table"]/div/div/div[1]/div
        TableChecker.rowValidatorWithoutXpath(driver, test);
        //TableChecker.getColumnCount(driver, test, table_xpath);
        TableChecker.getColumnCountAndNames(driver, test);

    }
}
