package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/885576/Documents/chromedriver.exe");
//"C:\Users\885576\Documents\msedgedriver.exe"
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a=new Actions(driver);
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).doubleClick().sendKeys("hello").build().perform();
		//moves to particular element
		WebElement move=driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(move).contextClick().build().perform();
		driver.close();
		driver.navigate().refresh();
		
	}

}
