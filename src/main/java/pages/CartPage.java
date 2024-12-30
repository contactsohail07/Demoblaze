package pages;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class CartPage extends TestBase{
	
	Properties prop = new Properties();
	InputStream obj=TestBase.class.getResourceAsStream("Data.properties");
	

	public void checkOut() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartur")));
		driver.findElement(By.id("cartur")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		for (WebElement element : prices) {
		    if(Integer.parseInt(element.getText())>700) {
		    	int item = prices.indexOf(element)+1;
		    	driver.findElement(By.xpath("(//tbody/tr/td[3])["+item+"]/following-sibling::td/a")).click();
		}
		}
		
	}
	

	public void placeOrder() throws IOException{
		
		prop.load(obj);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.id("name")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.id("country")).sendKeys(prop.getProperty("country"));
		driver.findElement(By.id("city")).sendKeys(prop.getProperty("city"));
		driver.findElement(By.id("card")).sendKeys(prop.getProperty("creditcard"));
		driver.findElement(By.id("month")).sendKeys(prop.getProperty("month"));
		driver.findElement(By.id("year")).sendKeys(prop.getProperty("year"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Purchase']")));
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		String actual= driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
		Assert.assertEquals(actual, "Thank you for your purchase!");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//button[text()='Purchase']/preceding-sibling::button")).click();

		
	}

}
