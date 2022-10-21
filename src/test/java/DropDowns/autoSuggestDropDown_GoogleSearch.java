package DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']/div[1]/span"));
		
		System.out.println("Size of Auto Suggestions: " + list.size());
		
		for(WebElement listItem : list) {
			if (listItem.getText().contains("beginners")) {
				listItem.click();
				break;
			}  
		}
		
		Thread.sleep(5000);
		driver.close();
	}

}
