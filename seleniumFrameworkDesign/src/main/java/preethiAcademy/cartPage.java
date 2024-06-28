package preethiAcademy;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import preethiAcademy.abstractComponenets.reuseableComponents;

public class cartPage extends reuseableComponents {

	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = ".cart h3")
	List<WebElement> cartproducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartproducts.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(productName));
		return match;
	}
	public checkoutPage goToCheckout() {
		checkOutEle.click();
		return new checkoutPage(driver);
	}

}
