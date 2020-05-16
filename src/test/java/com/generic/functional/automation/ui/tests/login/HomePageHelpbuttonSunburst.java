
package com.generic.functional.automation.ui.tests.login;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic.functional.automation.ui.tests.common.TestConfig;

public class HomePageHelpbuttonSunburst extends TestConfig {

	@Test
	public void HomePageHelpbuttonsunburst() throws Exception {
		// HomePage with help button click and sunburst Select documents

		test = extent.createTest("SVGClickTestCase");

		login.doLogin(test);
		driver.findElement(By.cssSelector("svg.MuiSvgIcon-root.explore-query-svg.ml-2 > path")).click();
		test.log(Status.INFO, "Help Button Clicked");
		driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d")).click();
		driver.findElement(By.id("mainArc-11a018d0-8978-48ff-9c7b-ea8606201da5")).click();
		driver.findElement(
				By.xpath("//div[@id='gatsby-focus-wrapper']/div/header/div/div/div[3]/div[6]/div/div[2]/span")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();

	}

}
