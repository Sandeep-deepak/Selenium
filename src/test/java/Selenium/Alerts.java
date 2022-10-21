package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		
//		// Alert Window with OK button
//		driver.findElement(By.name("alert")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//		
//		
//		// Alert Window with OK & Cancel button
//		driver.findElement(By.name("confirmation")).click();
//		Thread.sleep(2000);
////		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();		
		
		// Alert Window with input box, OK & Cancel button, Capture text from alert
		driver.findElement(By.name("prompt")).click();
		Thread.sleep(2000);
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("Message Displayed on Alert " + alertWindow.getText());
		
		alertWindow.sendKeys("Welcome");
		Thread.sleep(2000);
		alertWindow.accept();
//		alertWindow.dismiss();
		
		Thread.sleep(5000);
		driver.close();
	}

}
