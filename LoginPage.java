package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory
	@FindBy( xpath= "//input[@id='txtUsername']")
	WebElement userName;
	
	@FindBy( xpath= "//input[@id='txtPassword']")
	WebElement passWord;

	@FindBy( xpath= "//button[text()='Login']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(wd, this);
	}
	
	public HomePage login(String un ,String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
