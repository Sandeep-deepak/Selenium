package KeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeys_KeyboardAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://text-compare.com/");
		
		WebElement input1 = driver.findElement(By.id("inputText1"));
		WebElement input2 = driver.findElement(By.id("inputText2"));
		
		input1.sendKeys("Welcome to Selenium");
		
		Actions act = new Actions(driver);
		
		// Ctrl + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		// Ctrl + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
				
		// TAB
		act.sendKeys(Keys.TAB);
		act.perform();
		
		// Ctrl + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		// Compare Texts
		if (input1.getAttribute("value").equals(input2.getAttribute("value"))) {
			System.out.println("Text Copied");
		} else {
			System.out.println("Text Not Copied");
		}
		
	}

}
