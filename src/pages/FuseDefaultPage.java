package pages;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.BasePage;
import support.Driver_Properties;

public class FuseDefaultPage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='add-page']")
	private WebElement newPage;

	@FindBy(xpath = "//input[@class='indented submitonenter']")
	private WebElement newPageInput;

	@FindBy(xpath = "(//button[text()=\"Create\"])[2]")
	private WebElement createButton;

	@FindBy(xpath = "//a[contains(text(),'Messaging')]")
	private WebElement messagePane;

	@FindBy(xpath = "//*[text()=\"Send an SMS\"]")
	private WebElement sendSMS;

	@FindBy(xpath = "//*[text()=\"Send an Email\"]")
	private WebElement sendEmail;

	@FindBy(xpath = "//div[@id=\"tabs-2\"]/child::div[contains(@class,\"start-module\")]/descendant::div[contains(@id,\"node\")]")
	private WebElement startNode;

	@FindBy(xpath = "//div[@id=\"tabs-2\"]/child::div[contains(@id,\"module\")]/descendant::div[contains(@id,\"rec\")]")
	private WebElement smsRecieveNode;

	@FindBy(xpath = "//div[text()='Send an Email']")
	private WebElement emailTitleTab;

	@FindBy(xpath = "//input[@name='smtp_url']")
	private WebElement smtpUrl;

	@FindBy(xpath = "//input[@name=\"port\"]")
	private WebElement emailPort;

	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement emailUserName;

	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement emailPassword;

	@FindBy(xpath = "//textarea[@name=\"from_constant\"]")
	private WebElement emailFrom;

	@FindBy(xpath = "//textarea[@name=\"to_constant\"]")
	private WebElement emailTo;

	@FindBy(xpath = "//textarea[@name=\"subject_constant\"]")
	private WebElement emailSubject;

	@FindBy(xpath = "//textarea[@name=\"cc_constant\"]")
	private WebElement emailCc;

	@FindBy(xpath = ".//div[text()='Send an SMS']")
	private WebElement sendSMSNode;

	@FindBy(xpath = "(//a[@title=\"Toggle between using a variable or a constant\"]/following-sibling::textarea[@name=\"message_phrase[]\"])[2]")
	private WebElement emailText;

	@FindBy(xpath = "//div[@id=\"module-2\"]/descendant::div[contains(@id,\"node\")][2]")
	private WebElement smsNotSentNode;

	@FindBy(xpath = "//div[@id=\"module-2\"]/descendant::div[contains(@id,\"node\")][1]")
	private WebElement smsSentNode;

	@FindBy(xpath = "//div[@id=\"module-3\"]/descendant::div[contains(@id,\"rec\")]")
	private WebElement emailRecieveNode;

	@FindBy(xpath = "//div[@id=\"module-3\"]/descendant::div[contains(@id,\"node\")][1]")
	private WebElement sentEmailNode;

	@FindBy(xpath = "//div[@id=\"module-3\"]/descendant::div[contains(@id,\"node\")][2]")
	private WebElement notSentEmailNode;

	@FindBy(xpath = "//a[contains(text(),'Basic')]")
	private WebElement basicPane;

	@FindBy(xpath = "//li[text()=\"Hang Up or Exit\"]")
	private WebElement exitNode;

	@FindBy(xpath = "//div[@id='module-4']/descendant::div[text()='Exit App']")
	private WebElement exitTab1;

	@FindBy(xpath = "//div[@id=\"module-4\"]/descendant::div[contains(@id,\"rec\")]")
	private WebElement exitTab1Recieve;

	@FindBy(xpath = "//div[@id='module-5']/descendant::div[text()='Exit App']")
	private WebElement exitTab2;

	@FindBy(xpath = "//div[@id=\"module-5\"]/descendant::div[contains(@id,\"rec\")]")
	private WebElement exitTab2Recieve;

	@FindBy(xpath = "//div[@id='module-6']/descendant::div[text()='Exit App']")
	private WebElement exitTab3;

	@FindBy(xpath = "//div[@id=\"module-6\"]/descendant::div[contains(@id,\"rec\")]")
	private WebElement exitTab3Recieve;

	WebElement defaultTab(String tabName) {
		return driver.findElement(By.xpath("//a[@class=\"tab-label\"][text()=\"" + tabName + "\"]"));
	}

	WebElement tabPanel(String tabPanel) {
		return driver.findElement(By.xpath("//div[@id=\"" + tabPanel + "\"]"));
	}

	WebElement panel(String tabPanel) {
		return driver.findElement(By.xpath("(//div[@id=\"" + tabPanel + "\"]/descendant::div[@class=\"panel\"])[2]"));
	}

	WebElement phoneNumer(String tabPanel) {
		return driver.findElement(By.xpath("//div[@id=\"" + tabPanel
				+ "\"]/descendant::div[@class=\"panel\"]/descendant::textarea[@name=\"phone_constant\"]"));
	}

	WebElement smsText(String tabPanel) {
		return driver.findElement(By.xpath("//div[@id=\"" + tabPanel
				+ "\"]/descendant::div[@class=\"panel\"]/descendant::textarea[@name=\"phone_constant\"]/following::a[contains(@title,\"Toggle between using a variable or a constant\")]/following-sibling::textarea"));
	}

	public FuseDefaultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewPage(String pageName) {
		newPage.click();
		newPageInput.clear();
		newPageInput.sendKeys(pageName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createButton);
	}

	public void expandMessagePane() {
		messagePane.click();
	}

	public void addSendSMS(String tabName) {

		Actions act = new Actions(driver);
		WebElement tab = defaultTab(tabName);
		String tabId = tab.getAttribute("href");
		System.out.println("tabId : " + tabId);
		String[] str = tabId.split("#");
		WebElement tabPanel = tabPanel(str[1]);
		act.dragAndDrop(sendSMS, tabPanel).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(panel(str[1])));
		act.dragAndDrop(startNode, smsRecieveNode).perform();
		phoneNumer(str[1]).sendKeys("9012345678");
		smsText(str[1]).sendKeys("Hello World");
		act.clickAndHold(sendSMSNode).moveByOffset(-350, -100).build().perform();
		act.release(sendSMSNode).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addSendEmail(String tabName) {

		WebElement tab = defaultTab(tabName);
		String tabId = tab.getAttribute("href");
		String[] str = tabId.split("#");
		WebElement tabPanel = tabPanel(str[1]);
		Actions act = new Actions(driver);
		act.dragAndDrop(sendEmail, tabPanel).perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(emailTitleTab));
		wait.until(ExpectedConditions.elementToBeClickable(emailText));
		smtpUrl.sendKeys("http//:mail.gmail.com");
		emailPort.sendKeys("5555");
		emailUserName.sendKeys("ABCD");
		emailPassword.sendKeys("password123");
		emailFrom.sendKeys("abc123@gmail.com");
		emailTo.sendKeys("efg456@ymail.com");
		emailSubject.sendKeys("Testing Email");
		emailCc.sendKeys("hij789@gmail.com");
		emailText.sendKeys("Sample Email Test 123");
		act.dragAndDrop(smsNotSentNode, emailRecieveNode).perform();
		basicPane.click();
		act.dragAndDrop(exitNode, tabPanel).perform();

		wait.until(ExpectedConditions.elementToBeClickable(exitTab1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.clickAndHold(exitTab1).moveByOffset(-350, 100).build().perform();
		act.release(exitTab1).perform();

		act.dragAndDrop(exitNode, tabPanel).perform();
		wait.until(ExpectedConditions.elementToBeClickable(exitTab2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.clickAndHold(exitTab2).moveByOffset(-150, 200).build().perform();
		act.release(exitTab2).perform();

		act.dragAndDrop(smsSentNode, exitTab1Recieve).perform();
		act.dragAndDrop(sentEmailNode, exitTab2Recieve).perform();
		act.dragAndDrop(exitNode, tabPanel).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.clickAndHold(exitTab3).moveByOffset(400, 200).build().perform();
		act.release(exitTab3).perform();
		act.dragAndDrop(notSentEmailNode, exitTab3Recieve).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
