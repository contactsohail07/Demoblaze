package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class LoginPage extends TestBase{
	
	
	public void login() throws IOException, InterruptedException {		
		
    	Properties prop = new Properties();
		InputStream obj=TestBase.class.getResourceAsStream("/base/Data.properties");
		prop.load(obj);
		System.out.println(driver.findElement(By.xpath("//a[@id='nava']")).getText()); 
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("loginpassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(5000);

		
	}
	
}
