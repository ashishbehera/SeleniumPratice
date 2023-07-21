package SeleniumDemo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		List<String> price =null;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//Requirement
		//Capture all webelments into list
		//Capture text of all webelments into new(Original) list
		//sort on the original list --> Sorted List
		//Compare Original Vs Sorted list
		driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
		
		List<WebElement> veggieList= driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList = veggieList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		do {
			List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
			//Scan the name column with Rice and print the price
			price = rows.stream().filter(s->s.getText().contains("Strawberry")).
			map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
			
		}while(price.size() < 1);
			

	}

	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
