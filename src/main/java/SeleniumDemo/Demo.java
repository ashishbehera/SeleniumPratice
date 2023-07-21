package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//driver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
//		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("Test@12345");
		driver.findElement(By.id("send2")).click();
		String errMsg = driver.findElement(By.cssSelector("div[for='email']")).getText();
		System.out.println(errMsg);
		//driver.close();

	}

}
