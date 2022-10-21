package DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestDropDown_BingSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//div[@class='sa_tm']//span"));
		
		System.out.println("Size of Auto Suggestions: " + list.size());
		
		for(WebElement listItem : list) {
			if (listItem.getText().contains("download")) {
				listItem.click();
				break;
			}  
		}
		
		Thread.sleep(5000);
		driver.close();
	}

}
