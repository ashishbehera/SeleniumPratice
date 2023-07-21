package SeleniumDemo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScopr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());

		WebElement footerDriver = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
		List<WebElement> totalFooterLinks = footerDriver.findElements(By.tagName("a"));
		System.out.println(totalFooterLinks.size());

		WebElement columnDriver = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[2]"));
		List<WebElement> totalFooterLinksFirstSec = columnDriver.findElements(By.tagName("a"));
		System.out.println(totalFooterLinksFirstSec.size());

		String parentHandle = driver.getWindowHandle();

		for (WebElement footerLinks : totalFooterLinksFirstSec) {
			String linkText = footerLinks.getText();
			String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			footerLinks.sendKeys(clickOnLinkTab);

//			
//			driver.navigate().back();

			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> itr = windowHandles.iterator();

			while (itr.hasNext()) {
				String handle = itr.next();
				if (!handle.equals(parentHandle)) {
					driver.switchTo().window(handle);
					System.out.println("Page Title is: " +driver.getTitle());		
					driver.close();
					driver.switchTo().window(parentHandle);

				}
			}

		}

	}

}
