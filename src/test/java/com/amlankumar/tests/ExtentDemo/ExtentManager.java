package com.amlankumar.tests.ExtentDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter html;
    private static ExtentTest test;

    public static ExtentReports getInstance(){
        if (extent == null) {
            html = new ExtentHtmlReporter("extentReportATB6X.html");
            html.config().setTheme(Theme.STANDARD);
            html.config().setDocumentTitle("API Automation Report");
            html.config().setReportName("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(html);
            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Tester", "AmlanK");

        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description) {
        test = extent.createTest(testName, description);
        return test;
    }
}
