package BrowserWindows;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class openURLsIn2TabsnWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Selenium 4 or later Feature
		
		driver.get("https://demo.nopcommerce.com/");
//		driver.switchTo().newWindow(WindowType.TAB); // Opens below Link in new Tab
//		driver.switchTo().newWindow(WindowType.WINDOW);	// Opens below Link in new Window
		driver.get("https://demo.opencart.com/");

		System.out.println("Test Success");
		Thread.sleep(5000);
		driver.quit();
	}

}
