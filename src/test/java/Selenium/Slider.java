package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_Slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		System.out.println("Location of the Min Slider: " + min_Slider.getLocation());	// (59, 250)
		System.out.println("Height & Width of the Min Slider: " + min_Slider.getSize());	// (21, 21)
		
		Actions act = new Actions(driver);
		// Sliding Min
		// dragAndDropBy(WebElement source, int xOffset, int yOffset)
		act.dragAndDropBy(min_Slider, 100, 0).perform();
		
		System.out.println("Min Slided Location: " + min_Slider.getLocation());	// (158, 250) Horizontal Slider
		System.out.println("Min Slided Height & Width: " + min_Slider.getSize());	// (21, 21)

		// Sliding Max
		WebElement max_Slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println("Location of the Max Slider: " + max_Slider.getLocation());	// (411, 250)
		System.out.println("Height & Width of the Max Slider: " + max_Slider.getSize());	// (21, 21)

		act.dragAndDropBy(max_Slider, -100, 0).perform();
		
		System.out.println("Max Slided Location: " + max_Slider.getLocation());	// (313, 250)
		System.out.println("Max Slided Height & Width: " + max_Slider.getSize());	// (21, 21)
		
	}

}
