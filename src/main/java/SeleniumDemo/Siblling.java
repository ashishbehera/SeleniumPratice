package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Siblling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//driver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement countryDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select ddlCountry = new Select(countryDropDown);
		ddlCountry.selectByVisibleText("AED");
		System.out.println(ddlCountry.getFirstSelectedOption().getText());
		driver.findElement(By.id("divpaxinfo")).click();
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

	}

}
