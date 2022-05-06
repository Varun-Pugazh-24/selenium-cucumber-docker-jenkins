package StepDefenitions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;

public class SearchStep {

	public static WebDriver driver;
	GooglePage gp;

	@Before
	public void beforeScenario() throws MalformedURLException {
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		cap.setCapability("zal:name", "myTestName");
		cap.setCapability("zal:build", "myTestBuild");
		cap.setCapability("zal:screenResolution", "1280x720");
	    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

	}

	@After
	public void afterScenario() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("Go to google with url {string}")
	public void go_to_google_with_url(String string) {
		gp = new GooglePage(driver);
		gp.goToURL(string);
		System.out.println("Navigated to " + string);
	}

	@When("Search for {string} in search box")
	public void search_for_in_search_box(String string) {
		gp.enterKeyword(string);
		System.out.println("Entered keyword " + string);
	}

	@Then("Click on search button")
	public void click_on_search_button() {
		gp.clickSearchBtn();
		System.out.println("Clicked Search button");
	}

}
