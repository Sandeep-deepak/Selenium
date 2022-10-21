package DropDowns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkDropDownSorted {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click(); // Click on Live Posting Tab
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpSelect = new Select(drpElement);
		
		List<WebElement> options = drpSelect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		
		System.out.println("OriginalList: " + originalList);
		System.out.println("Temp List: " + tempList);
		
		Collections.sort(tempList);	// Sorting tempList
		System.out.println("-------------------------------------------------------------");
		System.out.println("OriginalList: " + originalList);
		System.out.println("Temp List After Sorting: " + tempList);
		
		System.out.println("-------------------------------------------------------------");
		if (originalList.equals(tempList)) {
			System.out.println("DropDown Sorted...");
		} else {
			System.out.println("DropDown Unsorted...");
		}
		
		driver.close();
	}

}
