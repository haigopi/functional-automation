package com.generic.functional.automation.ui.tests.home;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HelpButtonTest extends TestConfig {

    @Test
    public void testSVGClickTestCase() throws Exception {

        test = extent.createTest("SVGClickTestCase");
        login.doLogin(test);
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.helpIcon.explore-query-svg.ml-2")).click();

    }
}
