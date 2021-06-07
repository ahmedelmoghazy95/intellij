package com.sumerge.momra.tests;

import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.DriverHandler;

import com.sumerge.momra.listeners.TestListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class BaseTest extends TestListener {
    DriverHandler driverHandler;

    protected ThreadLocal<String> testName = new ThreadLocal<>();
    // Get Directory of the Upload File
//    public static String windowsPath = System.getProperty("user.dir") + "\\TestImages\\";

    @BeforeSuite
    public void resetTestData() {
        // Reset All Test Data Used
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUp(String page) throws InterruptedException, MalformedURLException {
        driverHandler = DriverHandler.getInstance();
        driverHandler.createDriver();
//		driverx.clearBrowserCache();

        if (page.equals(Constants.ENGINEERING_OFFICES_MODULE)) {
            driverHandler.gotoApplicationEngineeringOfficesPage();
        } else if (page.equals(Constants.REPORTS_MODULE)) {
            driverHandler.gotoApplicationReportsPage();
        } else if(page.equals(Constants.VISITS_VIOLATIONS_MODULE) ) {
            driverHandler.goToViolationsPage();
        }

    }
//********************Ask Amr about difference bet this & login method in login page************************
//    public HomePage logIn(String username, String password) {
//        return loginPage.login(username, password);
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverHandler.getDriver().quit();
        driverHandler.setDriver(null);
    }
}
