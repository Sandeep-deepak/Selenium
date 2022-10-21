package HeadlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessChrome {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.opencart.com/index.php?route=common/home");
		System.out.println(driver.getTitle());
		
		driver.close();
	}
}
