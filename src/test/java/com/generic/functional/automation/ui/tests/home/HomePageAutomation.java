package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageAutomation extends TestConfig {

    @Test
    public void testSVGClickTestCase() throws Exception {

        test = extent.createTest("SVGClickTestCase");
        login.doLogin(test);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2 > path")).click();
        test.log(Status.INFO, "Help Button Clicked");
        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
        driver.findElement(By.id("mainArc-2609f85e-b113-407e-b007-dcea50347141")).click();
        driver.findElement(By.id("mainArc-f1124b1f-1a19-4d8e-97f5-48ad1854db7a")).click();
        driver.findElement(By.id("mainArc-a5cc64db-9de3-414a-98a4-e975accd1246")).click();
        driver.findElement(By.xpath("//div[@id='simple-tabpanel-0']/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[3]/div[2]/div/div/div[3]/div")).click();
        driver.findElement(By.xpath("//div[@id='simple-tabpanel-0']/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]")).click();
    }
}
