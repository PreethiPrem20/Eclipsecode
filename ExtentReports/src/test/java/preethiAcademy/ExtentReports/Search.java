package preethiAcademy.ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Search {

		
	    WebDriver driver;
	    ExtentReports extent;
	    ExtentTest test;

	    @BeforeMethod
	    public void setUp()
	    {
	    	//System.setProperty("webdriver.chrome.driver", "/Users/885576/Documents/chromedriver.exe");
	        driver = new ChromeDriver();
	        extent = new ExtentReports();
	        String path=System.getProperty("user.dir")+"\\reports\\index.html";
	        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	        reporter.config().setReportName("Automation report");
	        reporter.config().setDocumentTitle("Test Results");

	 

	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Maharaja");
	    }

	    @Test
	    public void googleSearch()
	    {
	        test = extent.createTest("Google Search");
	        driver.get("https://www.google.com");
	        WebElement searchbox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
	        searchbox.sendKeys("Automation Testing");
	        searchbox.submit();
	        test.log(Status.INFO, "Performed Google search");
	    }

	    @AfterMethod
	    public void close()
	    {
	        driver.quit();
	        extent.flush();
	    }

	}


