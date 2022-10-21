package BrowserWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class chordMethod {

	public static void main(String[] args) throws InterruptedException {
		
		// Open Link in New Tab using chord() method
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		System.out.println("Title of parent Page: " + driver.getTitle());
		
		String tab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		
		driver.findElement(By.linkText("Register")).sendKeys(tab);
		
		// For Switching Windows/Tabs
		// Window IDs are unique Every time we run Script
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		String parentWinId = it.next();
		String childWinId = it.next();
		System.out.println("Parent Window ID: " + parentWinId);
		System.out.println("Child Tab ID: " + childWinId);
		
		Thread.sleep(2000);
		driver.switchTo().window(childWinId);
		System.out.println("Title of Child New Tab: " + driver.getTitle());
		Thread.sleep(3000);	
		driver.close();	// Closes Current Instance (Child new Tab)
		
		driver.switchTo().window(parentWinId);
		System.out.println("Title of Parent Page: " + driver.getTitle());
		Thread.sleep(5000);
		driver.quit(); // Quit Driver Instance
		
	}

}
