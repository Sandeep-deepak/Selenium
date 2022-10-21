package Selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	public static void main(String[] args) throws InterruptedException {
		// Also similar to WebDriverWait with more flexibility in polling time and Ignoring Exceptions
		// Waiting 30 seconds for an element to be present on the page, 
		// checking for its presence once every 5 seconds.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Fluent Wait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
		
		// Usage of Fluent Wait
		WebElement element = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//h3[text()='Selenium']"));
			}
		});
		
		element.click();
		
		Thread.sleep(5000);
		driver.close();
	}
	
//		// Or
//		// Fluent Wait Example 2
//	public static void main(String[] args) throws InterruptedException {
//	
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();		
//		
//		driver.findElement(By.name("q")).sendKeys("Selenium");
//		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
//		
//		By elementLoc = By.xpath("//h3[text()='Selenium']");
//		waitForElementWithFluentWait(driver, elementLoc).click();
//		
//		Thread.sleep(5000);
//		driver.close();
//	}
//	
//	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
//		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
//		
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(locator);
//			}
//		});
//		
//		return element;
//	}
	

}
