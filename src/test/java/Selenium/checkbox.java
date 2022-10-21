package Selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame-one1434677811");
		Thread.sleep(1000);
		
//		// Check Single CheckBox
//		driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_1']")).click();
		
		// Select Multiple CheckBoxes
		List<WebElement> days = driver.findElements(By.xpath("//div[@id='q15']//table[@class='inline_grid choices']//td//label"));
		System.out.println("Number of CheckBoxes: " + days.size());
//		days.get(0).click();	// Check Specific checkBox By index
		
		// Select All CheckBoxes
		for(int i = 0; i<days.size(); i++) {
			days.get(i).click();
			Thread.sleep(1000);
		}
		// Or
//		for(WebElement day : days) {
//			Thread.sleep(1000);
//			day.click();
//		}
		
		// Select Specific CheckBoxes
//		for(int i = 0; i<days.size(); i++) {
//			String checkBoxName = days.get(i).getText();
//			if (checkBoxName.equals("Monday") || checkBoxName.equals("Saturday")) {
//				days.get(i).click();
//			}
//		}
		// Or
//		for(WebElement day : days) {
//			String checkBoxName = day.getText();
//			if (checkBoxName.equals("Monday") || checkBoxName.equals("Saturday")) {
//				day.click();
//			}
//		}
		
		// Select Last 2 CheckBoxes
//		// Total no. of CheckBoxes - no. of CheckBoxes want to select = Starting index
//		// 7-2 = 5
//		
//		for(int i = days.size()-2; i<days.size(); i++) {
//			Thread.sleep(1000);
//			days.get(i).click();
//		}

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.close();
	}

}
