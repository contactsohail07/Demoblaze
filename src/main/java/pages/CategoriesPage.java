package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CategoriesPage extends TestBase {


	public void phones() throws InterruptedException  {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[text()='Phones']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Nexus 6')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Nexus 6')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Phones']")));
		driver.findElement(By.xpath("//a[text()='Phones']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Iphone 6')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Iphone 6')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();		
		
		
		
	}

}
