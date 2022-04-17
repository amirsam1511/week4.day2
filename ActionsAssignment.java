package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment {

	public static void main(String[] args) {

		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		// Added Implicit Wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Switch to Frame using index
		driver.switchTo().frame(0);
		//Get the element using xpath
		WebElement resize = driver.findElement(By.xpath("//div[contains(@class,'gripsmall')]"));
		//Create an object for actions class
		Actions builder = new Actions(driver);
		//Used dragandDropBy function to resize the image
		builder.dragAndDropBy(resize, 30, 30).perform();
		//Close the browser
		driver.close();
	}

}
