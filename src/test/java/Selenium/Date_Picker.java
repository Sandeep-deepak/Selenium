package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Date_Picker {

	public static void main(String arg[]) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	
//		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("04/25/2022"); // input type="text" then we can use sendKeys()
		
		driver.findElement(By.xpath("//*[@id='datepicker']")).click();	// Opens Date Picker

		String setYear = "2021";
		String setMonth = "April";
		String setDate = "25";
		
		// Month & Year Selection
		while (true) {
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if (month.equalsIgnoreCase(setMonth) && year.equalsIgnoreCase(setYear)) 
				break;
			else 
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		// Date Selection
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele: allDates) {
			String dt = ele.getText();
			if (dt.equals(setDate)) 
				ele.click();
				break;
		}
		
		Thread.sleep(5000);
		driver.close();
	}
}
