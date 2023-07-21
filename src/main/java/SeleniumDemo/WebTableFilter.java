package SeleniumDemo;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Tomato");
		List<WebElement> veggieList= driver.findElements(By.xpath("//tr/td[1]"));
	   List<WebElement> filteredList = veggieList.stream().filter(s-> s.getText().contains("Tomato")).collect(Collectors.toList());
	   Assert.assertEquals(veggieList.size(), filteredList.size());
	   driver.quit();
		

	}

}
