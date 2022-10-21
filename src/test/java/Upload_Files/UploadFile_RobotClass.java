package Upload_Files;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_RobotClass {

	public static void main(String[] args) throws AWTException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
		
		// Using Robot Class
		// Click on Select file to upload button
		WebElement selectButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectButton);
		
		// On Window based application
		/* 1) Copy the path to clipBoard
		   2) CTRL + V (paste the location in file field)
		   3) Enter	(Clicks on Open Button) */
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		String filePath = "C:\\Users\\Sandeep\\eclipse-workspace\\Selenium_WebDriver_Practice\\Upload_Documents\\Sample_File.pdf";
		
		// Put path of file in a ClipBoard
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// CTRL + V
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		
		// Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
