package JavaScriptExecutor;

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

public class JavaScriptExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
/*		// Syntax
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(Script, args);		*/
		
		// Click Action
		WebElement registerBtn = driver.findElement(By.xpath("//a[@class='ico-register']"));
		JavaScriptUtil.clickElementByJS(registerBtn, driver);
		
		// Getting title of the page
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		
		// Generate Alert
		JavaScriptUtil.generateAlert(driver, "This is JavaScript Alert...");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		// Refreshing the page
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		// Scroll page Down
		JavaScriptUtil.scrollPageDown(driver);
		
		// Scroll page UP
		Thread.sleep(2000);
		JavaScriptUtil.scrollPageUp(driver);
		
		// Zoom page
		JavaScriptUtil.zoomPageByJS(driver);
		
		// flash
		WebElement logoFlash = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flash(logoFlash, driver);
		
		// Drawing Border & take Screenshot
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.drawBorder(logo, driver);
//		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\logoJS.png");
		FileUtils.copyFile(src, trg);
		
		
		Thread.sleep(5000);
		driver.close();
	}

}
