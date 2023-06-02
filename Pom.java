package pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Pom {
	WebDriver wd;
	String parent;

	By userName = By.xpath("//input[@id='txtUsername']");
	By passWord = By.xpath("//input[@id='txtPassword']");
	By login = By.xpath("//button[text()='Login']");
	
	By hrAministration = By.xpath("(//span[text()='HR Administration'])[1]");
	
	By addUser = By.xpath("//i[contains(text(),'add')]");
	
	By selectEmployee = By.xpath("(//input[@id='selectedEmployee_value'])");
	public By employee = By.xpath("(//span[text()='aliyah Haq'])");
	By newUsername = By.xpath("(//input[@id='user_name'])");
	public By essDownArrow = By.xpath("(//i[@class='material-icons' and text()='arrow_drop_down'])[2]");
	public By essRole = By.xpath("(//span[text()='Default ESS'])");
	public By supervisorDownArrow = By.xpath("(//i[@class='material-icons' and text()='arrow_drop_down'])[3]");
	By supervisorRole = By.xpath("(//a[@class='dropdown-item' and @id='bs-select-2-2'])");
	public By adminDownArrow = By.xpath("(//i[@class='material-icons' and text()='arrow_drop_down'])[4]");
	By adminRole = By.xpath("(//span[@class='text' and text()='main'])");
	By enabled = By.xpath("//label[text()='Enabled']");
	By newPassword = By.xpath("//input[@id='password']");
	By confirmPassword = By.xpath("//input[@id='confirmpassword']");
	
	By saveButton = By.xpath("//button[@id='modal-save-button']");
	
	public By successMessage = By.xpath("//div[text()='Successfully Saved']");
	
	public By logoutDownarrow = By.xpath("//i[text()='arrow_drop_down']");
	By logout = By.xpath("//a[text()='Logout from all browsers']");
	
	public void openBrowserWith_Url(String url)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		wd = new ChromeDriver(op);
		wd.get(url);
		wd.manage().window().maximize();
	}
	
	public void enterUsername(String str)
	{
		wd.findElement(userName).sendKeys(str);
	}
	
	public void enterPassword(String str)
	{
		wd.findElement(passWord).sendKeys(str);
	}
	
	public void clickLogin()
	{
		wd.findElement(login).click();
	}
	
	public void clickHrAdministration()
	{
		wd.findElement(hrAministration).click();
	}
	
	public void waitUntil_AddUser_Appears()
	{
		parent = wd.getWindowHandle();
		new WebDriverWait(wd, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//i[contains(text(),'add')]"))));
	}
	
	public void clickAddUser() throws InterruptedException
	{
		wd.findElement(By.xpath("//i[contains(text(),'add')]")).click();
		Thread.sleep(4);
		
	}
	
	public void switchToPopup()
	{
		Set<String> handles = wd.getWindowHandles();
		for(String handle: handles)
		{
			if(!handle.equals(parent))
			{
				wd.switchTo().window(handle);
			}
			else continue;
		}
		
	}
	
	public void enterEmployeeValue(String str)
	{
		wd.findElement(selectEmployee).sendKeys(str);
	}
	
	public void clickEmployee()
	{
		wd.findElement(employee).click();
	}
	
	public void clickDownArrow(By locator)
	{
		wd.findElement(locator).click();
	}
	
	public void enterNewUsername(String str)
	{
		wd.findElement(newPassword).sendKeys("Admin");
	}
	
	public void selectEss()
	{
		wd.findElement(essRole).click();
	}
	
	public void selectSupervisorRole()
	{
		wd.findElement(supervisorRole).click();
	}
	
	public void selectAdminRole()
	{
		wd.findElement(adminRole).click();
	}

	public void selectEnabled()
	{
		wd.findElement(enabled).click();
	}

	public void enterNewPassword()
	{
		wd.findElement(newPassword).sendKeys("SrijaAravind");
	}

	public void confirmPassword()
	{
		wd.findElement(supervisorRole).click();
	}

	public void clickSaveButton()
	{
		wd.findElement(saveButton).click();
	}

	public void printSuccessMessage()
	{
		String message = wd.findElement(By.xpath("//div[text()='Successfully Saved']")).getAttribute("text");
		System.out.println(message);
	}

	public void ClickLogout()
	{
		wd.findElement(logout).click();
	}
	
}
