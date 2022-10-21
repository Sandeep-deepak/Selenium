package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Calender {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Type 1
		// Calendar with <form> Tag
		driver.get("https://demo.guru99.com/test/");
		
		//Find the date time picker control
		WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
		//Fill date as dd/mm/yyyy as 25/04/1996
        dateBox.sendKeys("25041996");
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0745PM");
		
		
		// Type 2
//		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
//				
//		String date = "25";
//		String month = "April";
//		String year = "2019";
//		JavascriptExecutor js = (JavascriptExecutor) driver;		
//		WebElement dateBox = driver.findElement(By.xpath("//div[@id='example']/div//button[@aria-label='Open the date view']"));
//		js.executeScript("arguments[0].click();", dateBox);
//				
//		WebElement preBtn = driver.findElement(By.xpath("//div[@class='k-header k-hstack']//a[@data-action='prev']"));
//		
//		while(true) {
//			String monYear = driver.findElement(By.xpath("//div[@class='k-header k-hstack']//a[@data-action='nav-up']")).getText();
//			if (monYear.contains(month) && monYear.contains(year)) {
//				break;
//			} else {
//				preBtn.click();
//			}
//		}
//				
//		// date selection not working & not implemented time dropdown
//		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='k-calendar-view k-calendar-monthview']/table/tbody/tr/td"));
//		for(WebElement ele: allDates) {
//			String dt = ele.getAttribute("innerText");
//			System.out.println(dt);
//			if (dt.equals(date)) 
////				System.out.println(dt);
////				ele.click();
//				js.executeScript("arguments[0].click();", ele);
//				break;
//		}
		
	}

}
