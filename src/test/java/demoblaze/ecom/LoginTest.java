package demoblaze.ecom;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ExtentManager;

/**
 * Unit test for simple App.
 */
public class LoginTest extends LoginPage
{
	
    
	@Test
 	public void loginCheck() throws IOException, InterruptedException {
 		
        test = extent.createTest("Sample Test Case 1");
        test.log(Status.INFO, "Starting test case 1");
 		System.out.println("check logging in");
 		login();
        test.log(Status.PASS, "Login test case passed successfully");

 		
 	}

}


