package DropDowns;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		driver.manage().window().maximize();
		
		WebElement drpAnimalsEle = driver.findElement(By.id("animals")); // Select tag ID
		Select drpAnimals = new Select(drpAnimalsEle);
		
//		drpAnimals.selectByVisibleText("Big Baby Cat");
		drpAnimals.selectByValue("avatar");
//		drpAnimals.selectByIndex(1);
		
		// Selecting option from DropDown without using Methods
		List<WebElement> allOptions = drpAnimals.getOptions();
		System.out.println("No. of options: " + allOptions.size());
		
		for(WebElement option : allOptions) {
			if (option.getText().equals("Baby Cat")) {
				option.click();
				break;
			}
		}
		
	}

}
