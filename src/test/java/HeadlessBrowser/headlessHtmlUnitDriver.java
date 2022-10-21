package HeadlessBrowser;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class headlessHtmlUnitDriver {

	public static void main(String[] args) {
		// Add HtmlUnit Driver & HtmlUnit driver with Dependencies Jar files to Project
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=common/home");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}
}