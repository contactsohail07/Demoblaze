package demoblaze.ecom;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.LogoutPage;
import utils.ExtentManager;

public class LogoutTest extends LogoutPage {
	



	
	@Test
	public void logoutCheck() throws InterruptedException {
		System.out.println("logout check");
        test = extent.createTest("Sample Test Case 2");
        test.log(Status.INFO, "Starting test case 2");
		logout();
        test.log(Status.PASS, "logout test case passed successfully");

		
	}	
	

	
	

}
