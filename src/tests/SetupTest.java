package tests;

import org.testng.annotations.Test;

import pages.FuseLoginPage;
import support.BaseTest;

public class SetupTest extends BaseTest {

	@Test
	public void selectCreateApp() {
		FuseLoginPage loginPage = new FuseLoginPage(driver);
		loginPage.SelectCreateApp();
	}

}
