package com.generic.functional.automation.ui.tests.help;

import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class HelpButtonTest extends TestConfig {

    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testHelpButtonTestCase() throws Exception {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("superadmin");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Design_20");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span")).click();
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2")).click();
        driver.findElement(By.id("mainArc-890e16a2-6415-4661-982d-33acafbb1fed")).click();
        Thread.sleep(1*2000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

