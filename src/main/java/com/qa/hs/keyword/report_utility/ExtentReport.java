package com.qa.hs.keyword.report_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {

    private ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public static ExtentTest logger;

    public void startReport() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport " + timeStamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Host Name", "Qualitest");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Username", "PAVAN");

        htmlReporter.config().setDocumentTitle("Extent Test Report");
        htmlReporter.config().setReportName("Automation Results");
        htmlReporter.config().setTheme(Theme.DARK);
    }
}
