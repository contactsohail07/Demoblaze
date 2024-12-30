package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

    public static ExtentReports createInstance(String filePath) throws IOException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
 //       sparkReporter.loadXMLConfig("extent-config.xml"); // Optional if you have a config file

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        return extent;
    }
}
