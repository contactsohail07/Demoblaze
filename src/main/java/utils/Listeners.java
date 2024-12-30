package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;


import base.TestBase;

public class Listeners extends TestBase implements ITestListener{
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        long duration = result.getEndMillis() - result.getStartMillis();
        InfluxDBUtil.writeMetric(result.getName(), duration, true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        // Example: Capture screenshot here
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/" + result.getName() + ".png");
        try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long duration = result.getEndMillis() - result.getStartMillis();
        InfluxDBUtil.writeMetric(result.getName(), duration, false);
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finished: " + context.getName());
        InfluxDBUtil.close();

    }

}
