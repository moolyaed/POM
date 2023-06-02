package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("userName"),prop.getProperty("passWord"));
	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
