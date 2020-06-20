package com.generic.framework.ui.helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueryChecker {
    public static void runSearchBubbleQuery(WebDriver driver, String query, ExtentTest test) throws Exception {
        WebElement searchBubble = driver.findElement(By.xpath("//input[@name='']"));
        searchBubble.click();
        Thread.sleep(1000 * 5);
        test.log(Status.INFO, "Typing " + query);
        for(int i = 0; i < query.length(); i++) {
            searchBubble.sendKeys(Character.toString(query.charAt(i)));
            Thread.sleep(150);

        }
        Thread.sleep(1000 * 3);
        test.log(Status.INFO, "Typed " + searchBubble.getAttribute("value"));
        searchBubble.sendKeys(Keys.ENTER);
        test.log(Status.INFO, "Successfully validated");
        Thread.sleep(1000 * 5);
    }
}
