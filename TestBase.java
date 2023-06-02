package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver wd;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\PageObjectModel\\src\\main\\"
					+ "java\\config\\config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String BrowserName = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			wd = new ChromeDriver();
			
			wd.manage().window().maximize();
			wd.get(Url);
		}
	}
}
