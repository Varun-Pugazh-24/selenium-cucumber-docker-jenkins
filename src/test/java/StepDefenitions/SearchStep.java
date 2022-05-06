package StepDefenitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchStep {

	public static WebDriver driver;
	GooglePage gp ;

	@Before
	public void beforeScenario() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
