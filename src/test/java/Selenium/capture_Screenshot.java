package Selenium;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class capture_Screenshot {
	
	public static void main(String arg[]) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		// According to hierarchy of classes and interfaces in WebDriver Interface in Selenium WebDriver
//		ChromeDriver driver = new ChromeDriver();
//		TakesScreenshot ts = driver;
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		// Full Page Screenshot
		// driver is instance variable of WebDriver Interface & ts is instance variable of TakesScreenshot Interface
		TakesScreenshot ts = (TakesScreenshot) driver;			// so we need to typeCast TakesScreenshot Interface
		File src = ts.getScreenshotAs(OutputType.FILE);			// Captures & save the Screenshot somewhere in memory (like ClipBoard)
		File trg = new File(".//Screenshots//homepage.png");	// Specifying our own location to Store Screenshot with File_Name.extension
		FileUtils.copyFile(src, trg);							// Copies the File from Source location to Target location 
		
		// Selenium 4 feature
		
		// Screenshot of Section/portion of page (We don't need to use TakesScreenshot Interface because getScreenshotAs() method is already available in WebElement)
		WebElement section = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]"));
		File src1 = section.getScreenshotAs(OutputType.FILE);
		File trg1 = new File(".//Screenshots//featuredProducts.png");
		FileUtils.copyFile(src1, trg1);
		
		// Screenshot of Element in page
		WebElement ele = driver.findElement(By.linkText("Your Store"));
		File src2 = ele.getScreenshotAs(OutputType.FILE);
		File trg2 = new File(".//Screenshots//logo.png");
		FileUtils.copyFile(src2, trg2);
		
		Thread.sleep(3000);
		driver.close();
	}
}
