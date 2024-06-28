package preethiAcademy;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import preethiAcademy.abstractComponenets.reuseableComponents;

public class orderPage extends reuseableComponents {

	WebDriver driver;
	public orderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(productName));
		return match;
	}

}
