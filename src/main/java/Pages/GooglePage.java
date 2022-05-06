package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

	protected WebDriver driver;

	private By searchTxtBox = By.name("q");

	private By SearchBtn = By.name("btnK");

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	public void wait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void goToURL(String string) {
		driver.get(string);
	}

	public void enterKeyword(String string) {
		wait(searchTxtBox);
		driver.findElement(searchTxtBox).sendKeys(string);
	}

	public void clickSearchBtn() {
		wait(SearchBtn);
		driver.findElement(SearchBtn).click();
	}

}
