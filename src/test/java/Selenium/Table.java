package Selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
1) How many rows in table
2) How many columns in a table
3) Retrieve the specific row/column data
4) Retrieve all the data from the table
5) Print Current Price(RS) & % Change of Company 'IDFC Bank' in Dynamic table
*/

public class Table {

	public static void main(String arg[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();

		// 1) How many rows in table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int rowSize = rows.size();
		System.out.println("Number of Rows in a Table: " + rowSize); // 26

		// 2) How many columns in a table
		int colSize = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th")).size();
		System.out.println("Number of Columns in a Table: " + colSize); // 5

		// 3) Retrieve the specific row/column data
		String value = driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[1]")).getText();
		System.out.println("The Value is: " + value);

		// 4) Retrieve all the data from the table
		System.out.println("Data from the table............");

		for (int r = 1; r <= rowSize; r++) // 1 2 3.....26
			for (int c = 1; c < colSize; c++) { // 1 2 3 4 5
				String data = driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(data + "	");
			}
		System.out.println();

		// 5) Print Current Price(RS) & % Change of Company 'IDFC Bank' in Dynamic table

		for (int r = 1; r <= rowSize; r++) {
			// iterate through each row of first column
			String company = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + r + "]/td[1]"))
					.getText();

			if (company.equals("IDFC Bank")) {
				String currentPrice = driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + r + "]/td[4]")).getText();
				String percentageChange = driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + r + "]/td[5]")).getText();

				System.out.println(company + "  " + currentPrice + "  " + percentageChange);
			}
		}

		
		// ********** Sample *****************
		String text = "Showing 1 to 20 of 8511 (426 Pages)";
		System.out.println(text.indexOf("("));
		System.out.println(text.indexOf("P"));

		String extracted = text.substring(text.indexOf("(") + 1, text.indexOf("P") - 1); // 426
		int a = Integer.valueOf(extracted);
		System.out.println(a);

		Thread.sleep(5000);
		driver.quit();
	}

}
