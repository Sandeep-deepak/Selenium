package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SizenLocationOfElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		// Location
		// Method 1
		System.out.println("Location(x,y): " + logo.getLocation());
		System.out.println("Location(x): " + logo.getLocation().getX());
		System.out.println("Location(y): " + logo.getLocation().getY());
		// Method 1
		System.out.println("Location(x) by getRect(): " + logo.getRect().getX());
		System.out.println("Location(y) by getRect(): " + logo.getRect().getY());
		
		System.out.println("---------------------------------------");
		
		// Size
		// Method 1
		System.out.println("Size(Width,Height): " + logo.getSize());
		System.out.println("Size(Width): " + logo.getSize().getWidth());
		System.out.println("Size(Height): " + logo.getSize().getHeight());
		
		// Method 2
		System.out.println("Size(Width) by getRect(): " + logo.getRect().getDimension().getWidth());
		System.out.println("Size(Height) by getRect(): " + logo.getRect().getDimension().getHeight());
		
	}

}
