package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
//		WebDriverWait mywait = new WebDriverWait(driver,10);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
		
//		WebElement element = mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[text()='Selenium']"))));
//		element.click();
		// Or 
		
		By eleLocator = By.xpath("//h3[text()='Selenium']");
		waitforElementPresent(driver, eleLocator, 10).click();
		
		Thread.sleep(5000);
		driver.close();
	}
	
	public static WebElement waitforElementPresent(WebDriver driver, By locator, int timeOut) {
		WebDriverWait mywait = new WebDriverWait(driver, timeOut);
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		return driver.findElement(locator);
	}

}
