package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableLeafGround {

	public static void main(String[] args) throws InterruptedException {

		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		//Create an object for Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		// Added Implicit Wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Get the number of columns using list of webelements
		List<WebElement> tableCols = driver.findElements(By.xpath("//table//tr/td"));
		//Get the Size
		int ColSize = tableCols.size();
		//Print the total no of columns present
		System.out.println("No of Columns: " + ColSize);

		////Get the number of rows using list of webelements
		List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr"));
		//Get the Size
		int rowSize = tableRows.size();
		//Print the total no of rows present
		System.out.println("No of Rows: " + rowSize);

		//Get the progress value of Learn to Interact with Elements
		String text = driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText();
		//Print it
		System.out.println("Learn to interact with Elements progress value :" + text);

		//Get the value of Vital Task for least completed Progress
		WebElement leastProgress = driver.findElement(By.xpath("//table//tr[6]/td[3]/input[1]"));
		//Click it
		leastProgress.click();

		//Add a sleep of 2secs to check whether check is made or not
		Thread.sleep(2000);

		//Close the browser
		driver.close();

	}

}
