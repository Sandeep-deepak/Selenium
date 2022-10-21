package HeadlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class heedlessFirefox {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);

		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://demo.opencart.com/index.php?route=common/home");
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
