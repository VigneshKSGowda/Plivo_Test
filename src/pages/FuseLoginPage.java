package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.BasePage;

public class FuseLoginPage {
	
	public WebDriver driver;

	@FindBy(xpath = "//a[@id='link-create']")
	private WebElement createApp;

	@FindBy(xpath = "//button[text()=\"Let's get started!\"]")
	private WebElement defaultStart;

	public FuseLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SelectCreateApp() {
		createApp.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(defaultStart));
		defaultStart.click();
	}

}
