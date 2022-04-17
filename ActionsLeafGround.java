package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsLeafGround {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		// Added Implicit Wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Get the element of draggable option in leafground using xpath and click it
		driver.findElement(By.xpath("//h5[text()='Draggable']")).click();
		//Get the element of draggable using Id
		WebElement dragAndDrop = driver.findElement(By.id("draggable"));
		// Create an object for actions class
		Actions builder = new Actions(driver);
		//Use dragAndDropBy function to drop the webelement 
		builder.dragAndDropBy(dragAndDrop, 80, 80).perform();
		//Navigate back to main page
		driver.navigate().back();
		//Get the element of droppable option in leafground using xpath and click it
		driver.findElement(By.xpath("//h5[text()='Droppable']")).click();
		//Get the draggable element using Id
		WebElement drag = driver.findElement(By.id("draggable"));
		//Get the droppable element using Id
		WebElement drop = driver.findElement(By.id("droppable"));
		//Use dragAndDrop function to drag and drop the element
		builder.dragAndDrop(drag, drop).perform();
		//Navigate back to main page
		driver.navigate().back();
		//Get the element of selectable option in leafground using xpath and click it
		driver.findElement(By.xpath("//h5[text()='Selectable']")).click();
		//Get the list of item1 to item4 using xpath
		WebElement item1 = driver.findElement(By.xpath("//li[text() = 'Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text() = 'Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text() = 'Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text() = 'Item 4']"));
		//Use Click And Hold function and keyboard function KEYDown and release it
		builder.keyDown(Keys.CONTROL)
		.clickAndHold(item1)
		.clickAndHold(item2)
		.clickAndHold(item3)
		.clickAndHold(item4)
		.release().perform();
		//Add a sleep of 2secs
		Thread.sleep(2000);
		//Navigate back to main page
		driver.navigate().back();
		//Get the element of sortable option in leafground using xpath and click it
		driver.findElement(By.xpath("//h5[text()='Sortable']")).click();
		//Get the window Handles using Set
		Set<String> windowHandles = driver.getWindowHandles();
		//Copy it to set using arraylist
		List<String> listHandles = new ArrayList<String>(windowHandles);
		//Get the second window handle
		String secondWindowHandle = listHandles.get(1);
		//Switch to second window handle
		driver.switchTo().window(secondWindowHandle);
		//Get the webelement using xpath
		WebElement sort1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		//Use dragAndDropby function using action class and pause it for 2secs
		builder.dragAndDropBy(sort1, 130, 130).pause(2000).perform();
		//Close the browser
		driver.quit();
	}

}
