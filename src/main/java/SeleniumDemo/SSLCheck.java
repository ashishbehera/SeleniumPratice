package SeleniumDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://expired.badssl.com");
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
	}

}
