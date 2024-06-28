package preethiAcademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import preethiAcademy.Testcomponents.BaseTest;

public class ErrorValidation extends BaseTest{
@Test(groups= {"errorHandling"})
	public void loginErrorMessage() throws IOException {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
	String productName = "ZARA COAT 3";
	landingPage LandingPage=launchApplication();
	productCatalogue productCatalog = LandingPage.loginPageApp("preethi12@gmail.com", "Pree123");
    LandingPage.getErrorMessage();
    Assert.assertEquals("Incorrect Email or Password", LandingPage.getErrorMessage());
	}

public class productNameError extends BaseTest{
@Test
	public void submitTest() throws IOException {
	String productName = "ZARA COAT 33";
	landingPage LandingPage=launchApplication();
	productCatalogue productCatalog = LandingPage.loginPageApp("preethi12@gmail.com", "Pree1234");
	List<WebElement> products = productCatalog.getProductsList();
    productCatalog.addProductToCart(productName);
    cartPage cartPage=productCatalog.goToCart();
    Boolean match=cartPage.verifyProductDisplay(productName);
	Assert.assertFalse(match);

}}
}

