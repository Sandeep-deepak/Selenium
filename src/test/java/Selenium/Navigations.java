package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Both methods are used for opening the url in browser. only difference is in the parameters
		// get() accepts only one String parameter & waits till page load
		// navigate().to() accepts String parameter and URL instance as parameter & doesn't wait to page load
		
		driver.get("https://demo.opencart.com/");
//		driver.get("https://demo.nopcommerce.com/"); // Or
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		driver.navigate().back();	// openCart
		Thread.sleep(2000);
		driver.navigate().forward();	// nopCommerce
		Thread.sleep(2000);
		driver.navigate().refresh();	// Refresh/Reload Page
		
		
		Thread.sleep(6000);
		driver.close();
	}

}
