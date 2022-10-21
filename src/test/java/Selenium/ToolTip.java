package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().frame(0);
		
		// Input Field
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='age']"));
		String toolTipText = inputBox.getAttribute("title");
		System.out.println("Input Field Tool Tip: " + toolTipText);
		
		// Link
		WebElement link = driver.findElement(By.xpath("//a[text()='Tooltips']"));
		String linkToolTipText = link.getAttribute("title");
		System.out.println("Link Tool Tip: " + linkToolTipText);
		
		Thread.sleep(5000);
		driver.quit();
		System.exit(0);
	}

}
