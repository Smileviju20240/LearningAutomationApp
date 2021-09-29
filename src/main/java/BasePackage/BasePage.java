package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	protected WebDriver driver;
	protected Properties prop;

	public WebDriver init_Driver() throws IOException {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\AppConfiguration\\Appconfig.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("config file is not found");
		} catch (IOException e) {
			System.out.println("config file is not loaded properly");
		}
		String browser_Name = prop.getProperty("browser");
		//String browser_Name = System.getProperty("browser"); //use command as clean install -Dbrowser=chrome
		
		switch (browser_Name) {

		case "chrome":
			launchChrome();
			break;

		case "firefox":
			launchFirefox();
			break;

		case "internetexplorer":
			launchInternetExplorer();
			break;

		default:
			System.out.println("Please provide the correct Browsername");
			break;

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		return driver;

	}

	public void launchInternetExplorer() {

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}

	public void launchFirefox() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	public void launchChrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

}
