package com.generic.functional.automation.ui.tests.login;

import java.util.concurrent.TimeUnit;

import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class HomeScreenAutomation extends TestConfig {


    @Test
    public void testSVGClickTestCase() throws Exception {

        test = extent.createTest("SVGClickTestCase");
        login.doLogin(driver, test);

        //driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2 > path")).click();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
//        driver.findElement(By.id("mainArc-d5f6e57b-d157-4ec5-bbc4-9fd35cc68775")).click();
//        driver.findElement(By.id("mainArc-f18c2bb1-ad7d-4583-8b64-7ef98ba647cc")).click();
//        driver.findElement(By.xpath("//button[@id='simple-tab-1']/span")).click();
//        driver.findElement(By.xpath("(//button[@id='simple-tab-1']/span)[3]")).click();
//        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div/div[2]/div/div/div")).click();
//        driver.findElement(By.id("react-select-2-option-0")).click();
//        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[2]/div[2]/div/div/div")).click();
//        driver.findElement(By.id("react-select-3-option-0")).click();
//        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[3]/div[2]/div/div/div")).click();
//        driver.findElement(By.id("react-select-4-option-0")).click();
//        driver.findElement(By.xpath("//div[@id='panel1d-content']/div/div/form/div[4]/div[2]/button/span")).click();
//        driver.findElement(By.xpath("//div[@id='panel1d-header']/div")).click();
    }

}
