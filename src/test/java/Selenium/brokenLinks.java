package Selenium;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of Links in Page: " + links.size());
		
		int brokenLinks = 0;
		
		for(WebElement element:links) {
			
			String url = element.getAttribute("href");
			
			if (url==null || url.isEmpty()) {
				System.out.println("URL is Empty");
				continue;
			}
			
			URL link = new URL(url);
			
			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				if (httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode() + url + " is " + "Broken Link");
					brokenLinks++;
				} else {
					System.out.println(httpconn.getResponseCode() + url + " is " + "Valid Link");
				}
			} catch (Exception e) {
			}
			
		}
		
		System.out.println("Number of Broken Links: " + brokenLinks);
		
		Thread.sleep(5000);
		driver.close();

	}

}
