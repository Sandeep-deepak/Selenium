package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragnDropAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement italy = driver.findElement(By.id("box106"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(rome, italy).perform();
		
		// Not Working may be WebPage problem
//		driver.get("https://chercher.tech/practice/drag-drop.html");
//
//		WebElement blueBox = driver.findElement(By.xpath("//div[@id='box1']"));
//		WebElement destination = driver.findElement(By.xpath("//div[@id='destination']"));
//		Actions act = new Actions(driver);
//		act.dragAndDrop(blueBox, destination).perform();
	}

}
