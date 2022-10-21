package MySQL_DBTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Database_Testing {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
		
		// User Data
		String cust_Firstname = "Sandeep";
		String cust_Lastname = "B";
		String cust_Email = "demo123@gmail.com";
		String cust_Tele = "9876545210";
		String cust_pswd = "1234";
		
		// User Registration
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Register')])[1]")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys(cust_Firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(cust_Lastname);
		driver.findElement(By.id("input-email")).sendKeys(cust_Email);
		driver.findElement(By.id("input-telephone")).sendKeys(cust_Tele);
		driver.findElement(By.id("input-password")).sendKeys(cust_pswd);
		driver.findElement(By.id("input-confirm")).sendKeys(cust_pswd);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// On Successful Registration
		try {
			String confMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
			if (confMsg.equals("Your Account Has Been Created!")) {
				System.out.println("Registration Successful from the UI/Application");
			} else {
				System.out.println("Registration Not Successful");
			}
		} catch (Exception e) {
			System.out.println("Some problem in Application");
		}
		
		// Database Validation
		// 1) Create a Connection
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opencart", "root", "");
				
		// 2) Create Statement/ Query
		Statement stmt = con.createStatement();
		String query = "SELECT firstname, lastname, email, telephone FROM oc_customer;";
				
		// 3) Execute Statement/Query & 4) Store data in ResultSet
		ResultSet rs = stmt.executeQuery(query); // Contains data of table
				
		boolean status = false;
		
		while(rs.next()) {
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			String email = rs.getString("email");
			String tele = rs.getString("telephone");
			
			if (cust_Firstname.equals(fname) && cust_Lastname.equals(lname)
					&& cust_Email.equals(email) && cust_Tele.equals(tele)) {
				System.out.println("First Name" + " | " + "Last Name" + " | " + "Email" + " | " + "Telephone");
				System.out.println("--------------------------------------------------");
				System.out.println(fname + " | " + lname + " | " + email + " | " + tele);
				System.out.println("Record found in the table || Test Passed");
				status = true;
				break;
			}
		}
		
		if (status==false) {
			System.out.println("Record Not found || Test Failed");
		}

		// Close Connection
		con.close();
				
		Thread.sleep(5000);
		driver.close();
		
	}

}
