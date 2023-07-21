package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		driver.findElement(By.id("datepicker")).click();
		
		while(!driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().equalsIgnoreCase("July")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));
		
		
		for(WebElement date:dates) {
			if(date.getText().equals("30")) {
				date.click();
				break;
			}
		}
		
		

	}

}
