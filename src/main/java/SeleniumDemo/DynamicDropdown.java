package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DynamicDropdown {

	public static void main(String[] args) {
		
		String opcaity = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//driver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(int i =0; i < countryList.size(); i++) {
			System.out.println(countryList.get(i).getText());
			if(countryList.get(i).getText().equalsIgnoreCase("India")) {
				countryList.get(i).click();
				break;
			}
		}

		
		driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector(".ui-state-highlight")).click();
		//driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
		driver.findElement(By.xpath("//td[@data-month='7'] //a[text()='21']")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=1; i <=4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		opcaity = driver.findElement(By.id("Div1")).getAttribute("style").split("opacity:")[1].trim().replace(";", ""); 
		Assert.assertEquals("0.5", opcaity);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		opcaity = driver.findElement(By.id("Div1")).getAttribute("style").split("opacity:")[1].trim().replace(";", ""); 
		Assert.assertEquals("1", opcaity);
		
		

			
		

		


	}

}
