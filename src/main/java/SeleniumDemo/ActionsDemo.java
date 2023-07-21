package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("nav-link-accountList"));
		action.moveToElement(element).contextClick().build().perform();
		//driver.findElement(By.xpath("//span[text()='Sign in']")).click();

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		

	}

}
