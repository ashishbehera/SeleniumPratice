package SeleniumDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrameExamples {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		String email = null;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("draggable")).click();
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();

		
		
		
	}

}
