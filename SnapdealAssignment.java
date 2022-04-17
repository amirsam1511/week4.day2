package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		//Created object for chromeOptions
		ChromeOptions options = new ChromeOptions();
		//Used addArguments to disable notifications
		options.addArguments("--disable-notifications");
		//Create an object for Chrome Driver
		ChromeDriver driver = new ChromeDriver(options);
		//Get the url and maximize the screen
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		// Added Implicit Wait of 15 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Get the value of Men's Fashion using xpath
		WebElement menshirt = driver.findElement(By.xpath("//span[@class = 'catText']"));
		//Create an object for actions class
		Actions builder = new Actions(driver);
		//Hover on to Men's Shirt
		builder.moveToElement(menshirt).perform();
		//Click Sport Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		//Get the count of no of shoes
		String shoesCount = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		//Print the count
		System.out.println("No of Shoes present: " + shoesCount);
		//Click Training Shoes
		driver.findElement(By.xpath("//div[contains(text(),'Training')]")).click();
		//Click Popularity
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		//Sort by Low to High
		driver.findElement(By.xpath("//ul[@class = 'sort-value']//li[@data-index='1']")).click();
		//Use sleep of 5 secs
		Thread.sleep(5000);
		//Get the list of webelements of price using xpath
		List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class ,'product-price')]"));
		//Print all the products price
		System.out.println("Total Products Present: " + price.size());
		//Use wait of 5secs
		Thread.sleep(5000);
		//Iterate through foreach loop for each webelement
		for (WebElement eachEle : price) {
			//Get the price of each product
			String prodPrice = eachEle.getText();
			//Print the price of each product and checked if it's sorted
			System.out.println("Items are sorted as follows: " + prodPrice);
		}
		//Get the start range 
		WebElement startRange = driver.findElement(By.name("fromVal"));
		//Clear the existing value
		startRange.clear();
		//Enter 600 in start range
		startRange.sendKeys("600");

		//Get the end range 
		WebElement endRange = driver.findElement(By.name("toVal"));
		//Clear the existing value
		endRange.clear();
		//Enter 1200 in end range
		endRange.sendKeys("1200");

		//Select Go
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		//Add a sleep of 3secs
		Thread.sleep(3000);
		// When more colors are there then this will be used
		//driver.findElement(By.xpath("//button[contains(text(),'More')]")).click();
		//Get the value of Navy Color
		WebElement checkColor = driver.findElement(By.xpath("//input[@value='Navy']/following::label[1]"));
		//Checked Yellow too but since now it's  not present commented it
		//WebElement checkYellow = driver.findElement(By.xpath("//input[contains(@id,'Yellow')]/following::label[1]"));

		//Check if Navy is selected or not using if-else condition
		if(checkColor.isSelected()!= true) {
			checkColor.click();

		}
		else {
			System.out.println("No Colors are available");;
		}

		//Get the value of Price Filter
		String filterPrice = driver.findElement(By.xpath("//a[contains(text(),'600')]")).getText();
		//Get the value of Color Filter
		String filterColor = driver.findElement(By.xpath("//a[text()='Navy']")).getText();
		//Checked if all the filters are applied
		if(filterPrice.contains("600")&& filterColor.contains("Navy")) {
			System.out.println("All Filters are applied");
		}
		//Add a sleep of 3secs
		Thread.sleep(3000);
		//Get the element of wishlist icon
		WebElement hoverItem = driver.findElement(By.xpath("//i[contains(@class,'heart-icon')]"));
		//Hover on to wishlist icon and click View
		builder.moveToElement(hoverItem)
		.click(driver.findElement(By.xpath("//div[contains(text(),'View')]"))).perform();
		//Add a sleep of 3secs
		Thread.sleep(3000);
		//Get the final Cost
		String finalPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		//Print it
		System.out.println("Cost is " + finalPrice);
		//Get the discount
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		//Print it
		System.out.println("Discount is " + discount);

		//Created a source file for screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		//Create an object for file with desired location
		File destination = new File("./snaps/screenshot1.png");
		//Copy the image from source to destination
		FileUtils.copyFile(source, destination);
		//Close the Current window
		driver.findElement(By.xpath("//div/i[@class='sd-icon sd-icon-delete-sign']")).click();
		//Close the browser
		driver.close();

	}

}

