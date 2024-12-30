package base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;



public class TestBase 
{
	
	public static WebDriver driver;
	public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupExtent() throws IOException {
        extent = ExtentManager.createInstance("reports/ExtentReport.html");
    }

	
	@BeforeTest
    public static void initialization() throws IOException

    {
    	
    	Properties prop = new Properties();
		InputStream obj=TestBase.class.getResourceAsStream("Data.properties");
		prop.load(obj);
		System.out.println(prop.getProperty("url"));
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+prop.getProperty("driverpath")+ "/chromedriver");
		//driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
    }
	
	
    @AfterSuite
    public void tearDownExtent() {
        extent.flush();
    }
    

}
