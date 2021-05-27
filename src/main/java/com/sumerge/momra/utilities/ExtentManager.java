package com.sumerge.momra.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentManager {
    private static ExtentReports extent;
    private static Platform platform;
    public static String reportFileName = "MOMRA_" + Constants.MODULE_NAME + "_E2E UI ExecutionReport" + "_"
            + new SimpleDateFormat("dd-MM-yyyy hh-mm-ss-ms").format(new Date()) + ".html";
    private static String macPath = System.getProperty("user.dir") + "/TestReport";
    private static String linuxPath = System.getProperty("user.dir") + "/TestReport";
    private static String windowsPath = System.getProperty("user.dir") + "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String linuxReportFileLoc = linuxPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

    public static String filePathAndName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    public static ExtentReports createInstance() {
        platform = getCurrentPlatform();
        filePathAndName = getReportFileLocation(platform);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePathAndName);
//		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//		htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("MOMRA E2E UI Report on " + Constants.ENVIRONMENT_NAME);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("MOMRA " + Constants.MODULE_NAME + " E2E UI Report on " + Constants.ENVIRONMENT_NAME);
        htmlReporter.config().setTimelineEnabled(true);

        extent = new ExtentReports();
        extent.setSystemInfo("OS", getCurrentPlatform().toString());
        extent.attachReporter(htmlReporter);

        return extent;
    }

    // Select the extent report file location based on platform
    private static String getReportFileLocation(Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
                break;
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            case LINUX:
                reportFileLocation = linuxReportFileLoc;
                createReportPath(linuxPath);
                System.out.println("ExtentReport Path for LINUX: " + linuxPath + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }

    // Create the report path if it does not exist
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    // Get current platform
    public static Platform getCurrentPlatform() {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }

}