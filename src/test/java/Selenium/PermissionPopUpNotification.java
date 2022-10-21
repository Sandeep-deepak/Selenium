package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopUpNotification {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // Disables Show Notifications PopUp(like Alert)
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options); // send options as parameter
		
		driver.get("https://www.hdfcbank.com/");
		
	}

}
