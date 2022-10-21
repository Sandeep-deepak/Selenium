package DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDown {
	
	public static void selectChoiceValues(WebDriver driver, String... value) {		// String... can handle multiple String values
		
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if (!value[0].equalsIgnoreCase("all")) {		// For Selecting Specific options
			for(WebElement item : choiceList) {
				String text = item.getText();
				
				for(String val : value)
					if (text.equals(val))
						item.click();
						break;
			}
		} else {			
			try {
				for(WebElement item : choiceList)		// For Selecting all options
					item.click();
			} catch (Exception e) {}
		}
		

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("file://E:\\Selenium Drivers & JARs\\Demo Webpages\\ComboTree jQuery Plugin Demos.html"); // https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		// Single Selection DropDown
		driver.findElement(By.xpath("//input[@id='justAnotherInputBox']")).click();
		selectChoiceValues(driver, "choice 4");
		
		// Multi Selection DropDown
		driver.findElement(By.id("justAnInputBox")).click();
//		selectChoiceValues(driver, "choice 2", "choice 2 3", "choice 6 2 1", "choice 6 2");
		selectChoiceValues(driver, "all");
		
		// Multi Selection With Cascade Option Select DropDown
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
		selectChoiceValues(driver, "choice 2", "choice 4", "choice 7", "choice 6 2 1");
		
		Thread.sleep(5000);
//		driver.close();
	}
	
	
	
	
}
