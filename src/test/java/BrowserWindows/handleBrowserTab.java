package BrowserWindows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handleBrowserTab {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		// Switching b/w Tabs in Browser
		
//		// ----------------- getWindowHandle() -----------------
//		String windowID = driver.getWindowHandle(); // return ID(Unique) of the Single Browser Window
//		System.out.println("Window ID is: " + windowID); // CDwindow-8F4967996ECBBF8B08382B341B2C7447
		
		// Open link in another Browser Window (Child window) TAB
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		// ----------------- getWindowHandles() -----------------
		Set<String> windowIDs = driver.getWindowHandles(); // return ID's of Multiple Browser Windows
		
//		// First Method - Iterator()		
//		Iterator<String> it = windowIDs.iterator();
//		
//		String parentWindowID = it.next();
//		String childWindowID = it.next();
//		
//		System.out.println("Parent Window ID is: " + parentWindowID);
//		System.out.println("Child Window ID is: " + childWindowID);
		
		// Second Method - List/ArrayList
		List<String> windowIDsList = new ArrayList<String>(windowIDs); // Converting Set --> List
 		
		String parentWindowID = windowIDsList.get(0);	// Parent Window ID
		String childWindowID = windowIDsList.get(1);	// Child Window ID
		
		System.out.println("Parent Window ID is: " + parentWindowID);
		System.out.println("Child Window ID is: " + childWindowID);
				
		
		// ----------------- How to use Window ID's for Switching -----------------
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent Window Title: " + driver.getTitle());
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child Window Title: " + driver.getTitle());
		
//		// ----------------- Get Title & Close Specific Window using for Each Loop -----------------
//		for(String winID : windowIDsList) {
////			System.out.println(winID); // Prints Windows ID
//			String title = driver.switchTo().window(winID).getTitle();
//			System.out.println("Title : " + title);
//			// Closes specific window
//			if (title.equals("OrangeHRM")) {
//				driver.close();
//			}
//		}
		
//		driver.close(); // Close Single Browser Window driver which Pinning
		driver.quit(); // Closes all Browser Windows
	}

}
