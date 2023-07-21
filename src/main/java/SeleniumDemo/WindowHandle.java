package SeleniumDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		String email = null;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		String mainHandle = driver.getWindowHandle();
		System.out.println(mainHandle);

		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		
		while(itr.hasNext()) {
			String handle = itr.next();
			System.out.println(handle);
			if(!handle.equals(mainHandle)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0].trim();
				driver.switchTo().window(mainHandle);
				break;
			}
		}
		
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
	}

}
