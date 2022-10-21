package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		WebElement components = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
		WebElement monitors = driver.findElement(By.xpath("//a[normalize-space()='Monitors (2)']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(components).moveToElement(monitors).click().perform();
		
	}

}
