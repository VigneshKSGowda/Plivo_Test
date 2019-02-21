package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	WebDriver driver;

	MouseActions(WebDriver driver) {
		this.driver = driver;
	}

	Actions act = new Actions(driver);

	public void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).perform();
	}

}
