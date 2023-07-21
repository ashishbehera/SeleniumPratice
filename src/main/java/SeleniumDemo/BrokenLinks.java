package SeleniumDemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		SoftAssert a = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//		System.out.println(url);
		
	
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
		
		for(WebElement footer:footerLinks) {
			String url = footer.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
			a.assertTrue(statusCode < 400, url+" is Broken");

		}
		
		a.assertAll();
		
		
	
	
		

	}

}
