package Pages;

import java.util.concurrent.TimeUnit;

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
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void goToURL(String string) {

		driver.get(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

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
