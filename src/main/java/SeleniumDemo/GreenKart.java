package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		addKart(driver,itemsNeeded);

	}

	public static void addKart(WebDriver driver,String[] itemsNeeded) {
	
		int count = 0;
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product']/h4"));
		System.out.println(productList.size());
		for (WebElement product : productList) {
			String item = product.getText();

			for (String name : itemsNeeded) {
				if (item.contains(name)) {
					driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
					count++;
					if (count == itemsNeeded.length)
						break;
				}
			}

		}

		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		String promoInfo = driver.findElement(By.cssSelector(".promoInfo")).getText();
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")))
		Assert.assertEquals(promoInfo, "Code applied ..!");
		
	}

}
