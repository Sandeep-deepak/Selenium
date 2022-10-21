package MouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragnDropImages {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.globalsqa.com/demo-site/draganddrop/");
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='gallery']/li//h5[text()='High Tatras']"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='gallery']/li//h5[text()='High Tatras 2']"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='gallery']/li//h5[text()='High Tatras 3']"));
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='gallery']/li//h5[text()='High Tatras 4']"));
		WebElement trash = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(item1, trash).perform();
		act.dragAndDrop(item2, trash).perform();
		act.dragAndDrop(item3, trash).perform();
		act.dragAndDrop(item4, trash).perform();
//		act.moveToElement(item3).clickAndHold().moveToElement(trash).release().build().perform();
		System.out.println("For loop Starting");
		Thread.sleep(3000);
		// Extra features
		
		// Rough Not Working(Expected to recycle the image "High Tatras 3" but result was recycling first added one to trash)
		
		List<WebElement> imgs = driver.findElements(By.xpath("//*[@id='trash']/ul/li/h5"));
		WebElement recycleDelBtns = driver.findElement(By.xpath("//*[@id='trash']/ul/li//a[text()='Recycle image']"));
	
		String imgText;
		
		for(WebElement item : imgs) { 
			imgText = item.getAttribute("innerText");
			System.out.println(imgText);
			System.out.println("element: " + recycleDelBtns.getAttribute("innerText"));
			if (imgText.equals("High Tatras 3") || imgText.equals("High Tatras 2")) {
				Thread.sleep(1000);
				System.out.println("Clicked: " + imgText);
				recycleDelBtns.click();
				break;
			}
		}
		
//		Thread.sleep(5000);
//		// by clicking Delete button
//		List<WebElement> delBtns = driver.findElements(By.xpath("//ul[@id='gallery']//li//a[text()='Delete image']"));
//		// Deleting All Elements
//		for(WebElement ele : delBtns) {
//			Thread.sleep(1000);
//			ele.click();
//		}
		
		Thread.sleep(5000);
//		driver.close();
		driver.quit();
		
	}

}
