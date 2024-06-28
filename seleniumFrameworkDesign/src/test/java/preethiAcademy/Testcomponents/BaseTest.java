package preethiAcademy.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import preethiAcademy.landingPage;

public class BaseTest {
	public WebDriver driver;
	public landingPage LandingPage;

	public WebDriver intializeDriver() throws IOException {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//preethiAcademy//resources//GlobalData.properties");
		prop.load(fis);
		String BrowserName =System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String BrowserName = prop.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			 System.setProperty("webdriver.chrome.driver",
			"/Users/885576/Documents/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("FireFox")) {
			// firefox
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			// edge
			System.setProperty("webdriver.edge.driver", "/Users/885576/Documents/edgedriver.exe");

			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
		// String to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Screenshots" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}

	@BeforeTest(alwaysRun = true)
	public landingPage launchApplication() throws IOException {
		driver = intializeDriver();
		LandingPage = new landingPage(driver);
		LandingPage.goTo();
		return LandingPage;

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.close();

	}
}
