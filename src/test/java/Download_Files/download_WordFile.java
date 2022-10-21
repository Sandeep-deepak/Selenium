package Download_Files;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class download_WordFile {

	public static void main(String[] args) throws InterruptedException {

		String location = System.getProperty("user.dir") + "\\Downloads\\";
		
		// --------------------- Chrome Browser ---------------------
		
		// Changing Download Location
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
				
		
		// --------------------- Edge Browser ---------------------
		
		// not Working
//		HashMap preferences = new HashMap();
//		preferences.put("download.default_directory", location);
//		
//		EdgeOptions options = new EdgeOptions();
//		// setExperimentalOption() is not existed for Edge 
//		// It may be available in Selenium 4
//		options.setExperimentalOption("prefs", preferences);
//		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver(options);
		
		
		// --------------------- FireFox Browser ---------------------
		
		// In Firefox when we click on download button, it opens a Windows based window which contains Save File, Open With
		// For Complete List of MIME Types (i,e., Media type and subtypes)
		// https://www.sitepoint.com/mime-types-complete-list/
		
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword"); // Specify media type
//		// Download file at Specified Location
////		// 0 - Desktop
////		profile.setPreference("browser.download.folderList", 0);  
////		// 1 - Downloads
////		profile.setPreference("browser.download.folderList", 1);
//		// 2 - Desired Location
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.download.dir", location);
//		
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(profile);
//		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver(options);
		
		
		// --------------------- Opening Website ---------------------
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		// Download Button
		WebElement downloadBtn = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadBtn);
		Thread.sleep(3000);
		try {
			// Switching to Ad & Click on Close button 
			driver.switchTo().frame("aswift_3");
			driver.switchTo().frame("ad_iframe");
			driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		} catch (Exception e) {
		}
		
		
	}

}
