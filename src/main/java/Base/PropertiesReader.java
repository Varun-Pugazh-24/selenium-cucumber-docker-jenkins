package Base;

import org.aeonbits.owner.Config;

import Enums.BrowserType;

@Config.Sources("file:${user.dir}/src/test/resources/cucumber.properties")
public interface PropertiesReader extends Config {
	
	boolean isRemoteWebDriver();
	
	BrowserType browser();

}
