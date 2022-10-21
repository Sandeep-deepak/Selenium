package KeyboardActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboard_Action {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		
		act.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(1000);
		
		act.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000);
		
	}

}
