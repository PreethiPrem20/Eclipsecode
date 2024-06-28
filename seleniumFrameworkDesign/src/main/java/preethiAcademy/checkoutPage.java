package preethiAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import preethiAcademy.abstractComponenets.reuseableComponents;

public class checkoutPage extends reuseableComponents {

	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".form-group input")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement suggest;

	@FindBy(css = ".actions a")
	WebElement submit;

	@FindBy(css = ".hero-primary")
	WebElement confirmMsg;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		suggest.click();

	}

	public confirmationPage submitOrder() {
		submit.click();
		return new confirmationPage(driver);
	}

}
