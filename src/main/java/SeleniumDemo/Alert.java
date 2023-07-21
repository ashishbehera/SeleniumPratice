package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Alert {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//driver//chromedriver");
		String name= "KrishnaDas";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Alert
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		String txt = driver.switchTo().alert().getText();
		Assert.assertEquals(txt, "Hello "+name+", share this practice page and share your knowledge");
		driver.switchTo().alert().accept();
		
		//Confirm Button
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		String txtConfirm = driver.switchTo().alert().getText();
		Assert.assertEquals(txtConfirm, "Hello "+name+", Are you sure you want to confirm?");
		driver.switchTo().alert().accept();
		driver.quit();
		

	}

}
