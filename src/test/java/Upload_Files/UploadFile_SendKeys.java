package Upload_Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_SendKeys {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		// If input tag Attribute type="file" use sendKeys() method directly
		// by passing path of the file to upload
		
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
		// Using sendKeys()
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Sandeep\\eclipse-workspace\\Selenium_WebDriver_Practice\\Upload_Documents\\Sample_File.pdf");
		
		Thread.sleep(5000);
		driver.close();
	}
}
