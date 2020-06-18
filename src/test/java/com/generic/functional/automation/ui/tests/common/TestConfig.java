package com.generic.functional.automation.ui.tests.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.generic.framework.ui.functional.ExtentManager;
import com.generic.framework.ui.functional.Login;
import com.generic.framework.ui.functional.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

@Slf4j
public class TestConfig {

    protected static final String DEFAULT_DOWNLOAD_DIR =  System.getProperty("user.dir")+File.separator+"downloads";
    protected WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    protected Login login;
    protected ExtentReports extent;
    public ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Setup Started...");
        System.out.println("Default Download Directory..."+DEFAULT_DOWNLOAD_DIR);
        setOS();
        setReport();

        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DEFAULT_DOWNLOAD_DIR);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(AppConstants.BASE_URL);


        //driver.manage().window().maximize();
        extent = ExtentManager.getInstance();
        login = new Login(driver);

    }

    private void setReport() {
        extent = ExtentManager.getInstance();
    }

    private void setOS() {
        String osName = System.getProperty("os.name");

        String driverName = "chromedriver_83.exe";

        System.out.println("OS found -> " + osName);
        if (!osName.startsWith("Windows")) {
            driverName = "chromedriver_83-macb";
        }

        System.setProperty("webdriver.chrome.driver", driverName);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {

        if(test!=null)
            return;

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = TakeScreenshot(driver, result.getName());

            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
        }


    }

    public String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + AppConstants.SCREEN_SHOT_PATH + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {

        System.out.println("Flushing out...");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        if(extent!=null) {
            extent.flush();
        }
        driver.quit();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
