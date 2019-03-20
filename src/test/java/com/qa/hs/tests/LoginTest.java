package com.qa.hs.tests;

import com.qa.hs.keyword.engine.KeyWordEngine;
import com.qa.hs.keyword.report_utility.ExtentReport;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author NaveenKhunteta
 */
public class LoginTest {

    private KeyWordEngine keyWordEngine;
    private ExtentReport extentReport = new ExtentReport();

    @BeforeTest
    public void setUp() {
        extentReport.startReport();
    }

    @Test
    public void loginTest() {
        keyWordEngine = new KeyWordEngine();
        ExtentReport.logger = extentReport.extent.createTest("To verify Login functionality");
        keyWordEngine.startExecution("login");
    }

    @Test
    public void signUpTest() {
        keyWordEngine = new KeyWordEngine();
        ExtentReport.logger = extentReport.extent.createTest("To verify SignUp functionality");
        keyWordEngine.startExecution("signup");
    }

    @AfterTest
    public void endReport() {
        extentReport.endReport();
    }
}
