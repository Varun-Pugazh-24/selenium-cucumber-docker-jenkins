package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import Enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	static String REMOTE_URL = "http://localhost:4444/wd/hub";

	static WebDriver driver;
	static RemoteWebDriver rDriver;

	static ChromeDriver chromedriver;
	static EdgeDriver edgedriver;
	static FirefoxDriver firefoxdriver;
	
	private static final Map<BrowserType, Supplier<WebDriver>> BrowserDriverMAP = new HashMap<>();
	private static final Map<BrowserType, Supplier<WebDriver>> RemoteBrowserDriverMAP = new HashMap<>();

	static WebDriverListener listener = new MyListener();

	private static final Supplier<WebDriver> REMOTE_FIREFOX = () -> {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		cap.setCapability("zal:screenResolution", "1280x720");
		try {
			driver = new RemoteWebDriver(new URL(REMOTE_URL), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new EventFiringDecorator(listener).decorate(driver);
	};
	
	private static final Supplier<WebDriver> REMOTE_CHROME = () -> {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability("zal:screenResolution", "1280x720");
		try {
			driver = new RemoteWebDriver(new URL(REMOTE_URL), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new EventFiringDecorator(listener).decorate(driver);
	};

	private static final Supplier<WebDriver> EDGE = () -> {
		WebDriverManager.edgedriver().arch32().setup();
		edgedriver = new EdgeDriver();
		edgedriver.manage().window().maximize();
		edgedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new EventFiringDecorator(listener).decorate(edgedriver);
	};

	private static final Supplier<WebDriver> FIREFOX = () -> {
		WebDriverManager.firefoxdriver().setup();
		firefoxdriver = new FirefoxDriver();
		firefoxdriver.manage().window().maximize();
		firefoxdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new EventFiringDecorator(listener).decorate(firefoxdriver);
	};

	private static final Supplier<WebDriver> CHROME = () -> {
		WebDriverManager.chromedriver().setup();
		chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new EventFiringDecorator(listener).decorate(chromedriver);

	};

	static {

		BrowserDriverMAP.put(BrowserType.CHROME, CHROME);
		BrowserDriverMAP.put(BrowserType.FIREFOX, FIREFOX);
		BrowserDriverMAP.put(BrowserType.EDGE, EDGE);
		RemoteBrowserDriverMAP.put(BrowserType.FIREFOX, REMOTE_FIREFOX);
		RemoteBrowserDriverMAP.put(BrowserType.CHROME, REMOTE_CHROME);

	}

	public static WebDriver initializeWebDriver(BrowserType browser) {

		return BrowserDriverMAP.get(browser).get();
	}

	public static WebDriver initializeRemoteWebDriver(BrowserType browser) {
		
		return RemoteBrowserDriverMAP.get(browser).get();
	}

}
