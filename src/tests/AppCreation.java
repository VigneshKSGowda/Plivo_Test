package tests;

import org.testng.annotations.Test;

import pages.FuseDefaultPage;
import support.BaseTest;
import support.Driver_Properties;

public class AppCreation extends BaseTest {

	@Test
	public void addNewPage() {
		FuseDefaultPage defaultPage = new FuseDefaultPage(driver);
		defaultPage.createNewPage("test");
		defaultPage.expandMessagePane();
		defaultPage.addSendSMS("test");
		defaultPage.addSendEmail("test");

	}

}
