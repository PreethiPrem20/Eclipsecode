package preethiAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import preethiAcademy.abstractComponenets.reuseableComponents;

public class landingPage extends reuseableComponents {
	WebDriver driver;

	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;// Initialization
		PageFactory.initElements(driver, this);
	}

	/*
	 * WebElement userEmail=driver.findElement(By.id("userEmail")); WebElement
	 * userPass=driver.findElement(By.id("userPassword")); WebElement
	 * loginbtn=driver.findElement(By.id("login"))
	 */
//PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPass;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(css = "[classname*='flyInOut']")
	WebElement ErrorMessage;

	public productCatalogue loginPageApp(String email, String pass) {
		userEmail.sendKeys(email);
		userPass.sendKeys(pass);
		login.click();
		productCatalogue productCatalog = new productCatalogue(driver);
		return productCatalog;
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
