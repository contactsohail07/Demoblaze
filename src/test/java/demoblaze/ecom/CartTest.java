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

import pages.CartPage;
import utils.ExtentManager;

public class CartTest extends CartPage {
	



	
	@Test(priority=1)
	public void editCart() throws IOException {
		
		System.out.println("check edit cart");
        test = extent.createTest("Sample Test Case 3");
        test.log(Status.INFO, "Starting test case 3");

		checkOut();
		
	}
	
	
	
	@Test(priority=2)
	public void order() throws IOException {

		placeOrder();		
        test.log(Status.PASS, "Cart test case passed successfully");

	}
	
	

}
