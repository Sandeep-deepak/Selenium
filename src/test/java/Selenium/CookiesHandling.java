package Selenium;

import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		// To Capture Cookies from Browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies: " + cookies.size()); // 3
		
		// Print Cookies from Browser
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		// Add Cookie to the Browser
		Cookie cookieObj = new Cookie("MyCookie123", "123456");
		driver.manage().addCookie(cookieObj);
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after Adding: " + cookies.size()); // 4 
		
		// Delete Specific Cookie from Browser
		driver.manage().deleteCookie(cookieObj); // or
//		driver.manage().deleteCookieNamed("MyCookie123");
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting one: " + cookies.size()); // 3
		
		// Delete all Cookies from the Browser
		driver.manage().deleteAllCookies();
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting all: " + cookies.size()); // 0
		
		driver.quit();
	}

}
