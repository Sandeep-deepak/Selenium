package Selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Date_Picker_Drp {

	public static void main(String[] args) throws InterruptedException {
		// https://www.dummyticket.com/dummy-ticket-for-visa-application/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("dob")).click();
		
		Select month_Drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_Drp.selectByVisibleText("Apr");
		
		Select year_Drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_Drp.selectByVisibleText("1995");
		
		// Date Selection
		
		String date = "25";
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for (WebElement ele : dates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
