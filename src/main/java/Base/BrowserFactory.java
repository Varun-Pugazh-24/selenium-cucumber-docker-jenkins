package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	static String REMOTE_URL = "http://localhost:4444/wd/hub";

	static WebDriver driver;
	static RemoteWebDriver rDriver;

	static ChromeDriver chromedriver;
	static EdgeDriver edgedriver;
	static FirefoxDriver firefoxdriver;

	public static WebDriver initLocalDriver(String browserName) throws Exception {

		switch (browserName.toLowerCase()) {

		case "chrome":
			return startChromeBrowser();

		case "edge":
			return startEdgeBrowser();

		case "firefox":
			return startFireFoxBrowser();

		}
		return null;

	}

	public static WebDriver initRemoteDriver(String browserName) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, browserName.toLowerCase().trim());
		cap.setCapability("zal:screenResolution", "1280x720");
		return driver = new RemoteWebDriver(new URL(REMOTE_URL), cap);
	}

	private static WebDriver startFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		firefoxdriver = new FirefoxDriver();
		firefoxdriver.manage().window().maximize();
		firefoxdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return firefoxdriver;
	}

	private static WebDriver startEdgeBrowser() {
		WebDriverManager.edgedriver().arch32().setup();
		edgedriver = new EdgeDriver();
		edgedriver.manage().window().maximize();
		edgedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return edgedriver;
	}

	private static WebDriver startChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return chromedriver;
	}

}
