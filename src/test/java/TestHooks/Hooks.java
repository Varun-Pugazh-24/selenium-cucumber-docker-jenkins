package TestHooks;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BrowserFactory;
import Base.DriverFactory;
import Base.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void beforeScenario() throws Throwable {

		PropertiesReader prop = ConfigFactory.create(PropertiesReader.class);

		if (prop.isRemoteWebDriver()) {

			DriverFactory.getInstance().setDriver(BrowserFactory.initializeRemoteWebDriver(prop.browser()));

		} else {
			DriverFactory.getInstance().setDriver(BrowserFactory.initializeWebDriver(prop.browser()));

		}

	}

	@AfterStep
	public void afterStep(Scenario scenario) {

		// Take a screenshot...
		final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
				.getScreenshotAs(OutputType.BYTES);
		// embed it in the report.
		scenario.attach(screenshot, "image/png", null);

	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {

		// Take a screenshot...
		final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
				.getScreenshotAs(OutputType.BYTES);
		// embed it in the report.
		scenario.attach(screenshot, "image/png", scenario.getName());

	}

	@After
	public void afterScenario() {
		DriverFactory.getInstance().closeBrowser();

	}

}
