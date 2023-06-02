package Orange;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.Pom;

public class OrangeHrm {
	
	WebDriver wd;
	Pom PomObj = new Pom();
	String url = "https://srijag-trials79.orangehrmlive.com/auth/login";
	
	@BeforeSuite
	public void openBrowser()
	{
		PomObj.openBrowserWith_Url(url);
	}
	
	@BeforeTest
	public void login()
	{
		PomObj.enterUsername("Admin");
		PomObj.enterPassword("E0@i1ifAGJ");
		PomObj.clickLogin();
		
		PomObj.clickHrAdministration();
	}
	
	@Test
	public void AddUser() throws InterruptedException
	{	
		PomObj.waitUntil_AddUser_Appears();
		PomObj.clickAddUser();
		
		PomObj.switchToPopup();
		
		PomObj.enterEmployeeValue("a");
		PomObj.waitFor(2,PomObj.employee);
		PomObj.clickEmployee();
		
		PomObj.enterNewUsername("Srija Aravind");
		
		PomObj.clickDownArrow(PomObj.essDownArrow);
		PomObj.waitFor(2,PomObj.essRole);
		PomObj.selectEss();
		
		PomObj.clickDownArrow(PomObj.supervisorDownArrow);
		PomObj.selectSupervisorRole();
		
		PomObj.clickDownArrow(PomObj.adminDownArrow);
		PomObj.selectAdminRole();
		
		PomObj.selectEnabled();
		
		PomObj.enterNewPassword();
		
		PomObj.clickSaveButton();
		PomObj.waitFor(1, PomObj.successMessage);
		PomObj.printSuccessMessage();
	}
	
	@AfterTest
	public void logout()
	{
		PomObj.clickDownArrow(PomObj.logoutDownarrow);
		PomObj.ClickLogout();
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		wd.quit();
	}

}
