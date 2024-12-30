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

import pages.CategoriesPage;
import utils.ExtentManager;

public class CategoriesTest extends CategoriesPage{




	@Test
 	public void phoneSelect() throws InterruptedException {
 		
 		System.out.println("check phone selection");
        test = extent.createTest("Sample Test Case 5");
        test.log(Status.INFO, "Starting test case 5");

 		phones();
        test.log(Status.PASS, "Categories test case passed successfully");

 		
 	}
	
	
}
