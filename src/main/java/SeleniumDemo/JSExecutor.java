package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JSExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> amountListProd = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int total =0;
		
		for(WebElement amount:amountListProd) {
			int amountValue = Integer.parseInt(amount.getText());
			total += amountValue;
			
		}
		int actualAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(total, actualAmount	);
		driver.quit();
		
		
		
		
		
	}

}
