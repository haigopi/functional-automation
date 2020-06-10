package com.generic.functional.automation.ui.tests.login;

import com.generic.functional.automation.ui.tests.common.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class VerifyDownloadAndPrintButtonTest extends TestConfig  {
  @Test
    public void verifyDownloadAndPrintButtonTest  () throws Exception {
      test = extent.createTest("VerifyDownloadAndPrintButtonTest ");

      login.doLogin(test);
      test.createNode("Help Button Click");
      WebElement helpButton = driver.findElement(By.cssSelector(".explore-quiries-inner"));
      helpButton.click();
      Thread.sleep(5 * 1000);
      test.createNode("Subject Shipments Button Click");
      WebElement SubjectShipmentsButtonClick = driver.findElement(By.id("mainArc-0b981a1b-32dc-43b1-b257-70c8c5a6cc6d"));
      Thread.sleep(5 * 1000);
      test.createNode("Freight Charges Click");
      driver.findElement(By.id("mainArc-2609f85e-b113-407e-b007-dcea50347141")).click();
      Thread.sleep(5 * 1000);
      test.createNode("Carrier Identifier Click");
      driver.findElement(By.id("mainArc-a5cc64db-9de3-414a-98a4-e975accd1246")).click();
      Thread.sleep(5 * 1000);
      test.createNode("Download Button Click");
      driver.findElement(By.cssSelector("#search-result-download-csv > span.MuiIconButton-label > svg.MuiSvgIcon-root > path")).click();

      Thread.sleep(5 * 1000);
      test.createNode("Print Button Clck");
      driver.findElement(By.cssSelector("#search-result-print > span.MuiIconButton-label > svg.MuiSvgIcon-root > path")).click();
      Thread.sleep(5 * 1000);



    }
}
