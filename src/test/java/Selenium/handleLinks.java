package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handleLinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Today's Deals")).click(); // Link Text
//		driver.findElement(By.partialLinkText("Today's")).click();	// Partial Link Text
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of Links in Page: " + links.size());
		
//		for(int i = 0; i<links.size(); i++) {
//			System.out.println("Link Text: " + links.get(i).getText());
//			System.out.println("Link: " + links.get(i).getAttribute("href"));
//		}
		
		// Enhanced For Loop
		for(WebElement link:links) {
			System.out.println("Link Text: " + link.getText());
			System.out.println("Link: " + link.getAttribute("href"));
		}
		
		Thread.sleep(5000);
		driver.close();
	}

}
