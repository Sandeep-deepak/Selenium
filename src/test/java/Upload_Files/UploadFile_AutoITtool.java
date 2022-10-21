package Upload_Files;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_AutoITtool {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
		
		// Using AutoIT Tool
		// Click on Select file to upload button
		WebElement selectButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectButton);
		
		// Download AutoIT & Install both (autoit-v3-setup.exe, SciTE4AutoIt3.exe)
		// Write Script by Identifying the elements of window based application using identifier (AutoIT tool)
		// Compile the Script to generate exe file
		// use that exe file as runtime execution of selenium script
		
		String fileAutoit = "C:\\Users\\Sandeep\\eclipse-workspace\\Selenium_WebDriver_Practice\\Upload_Documents\\AutoIT_Script&Runner\\fileUpload.exe";
		Runtime.getRuntime().exec(fileAutoit);
		
	}

}
