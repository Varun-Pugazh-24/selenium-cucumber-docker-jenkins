package TestHooks;

import Base.Base;
import Base.BrowserFactory;
import Base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() throws Throwable {
		String browser = Base.initProperties().getProperty("browser");

		if (Base.initProperties().getProperty("run_tests_in").equalsIgnoreCase("remote")) {		
			
			DriverFactory.getInstance().setDriver(BrowserFactory.initRemoteDriver(browser));

		} else {
			DriverFactory.getInstance().setDriver(BrowserFactory.initLocalDriver(browser));

		}

	}

	@After
	public void afterScenario() {
		DriverFactory.getInstance().closeBrowser();
	}

}
