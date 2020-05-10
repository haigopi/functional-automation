package com.generic.framework.ui.functional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extentReports = null;
    private static ExtentHtmlReporter htmlReporter;
    private ExtentManager() {
    }

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + AppConstants.REPORT_PATH);
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);

            htmlReporter.config().setDocumentTitle("A4 Functional Test Automation Report"); // Tittle of Report
            htmlReporter.config().setReportName("A4 Functional Test Report"); // Name of the report
            htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

            // General information releated to application
            extentReports.setSystemInfo("Application Name", "A4 Tests");
            extentReports.setSystemInfo("User Name", "Gopi K Kancharla");
            extentReports.setSystemInfo("Envirnoment", "QE");



        }

        return extentReports;
    }
}
