package BrowserWindows;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handlesWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/");
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("kosmik");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("kosmik");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
//		String windowId = driver.getWindowHandle();
//		System.out.println(windowId);
		
		driver.findElement(By.xpath("//a[@class='selected']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		ArrayList<String> windowIDsList = new ArrayList<String>(windowIDs);
		
		String parent = windowIDsList.get(0);
		String child = windowIDsList.get(1);
		
		driver.switchTo().window(child);
		System.out.println(parent);
		System.out.println(child);
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("kosmik");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("kosmik");
		
		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='selected']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
