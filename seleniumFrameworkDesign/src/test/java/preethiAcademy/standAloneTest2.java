package preethiAcademy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import preethiAcademy.Testcomponents.BaseTest;

public class standAloneTest2 extends BaseTest {

	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchase"})

	public void submitTest(HashMap<String,String>input) throws IOException {

		landingPage LandingPage = launchApplication();
		productCatalogue productCatalog = LandingPage.loginPageApp(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalog.getProductsList();
		productCatalog.addProductToCart(input.get("productName"));
		cartPage cartPage = productCatalog.goToCart();
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		checkoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmationMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
	}

	@Test(dependsOnMethods = { "submitTest" }) // to verify whether Zara coat 3 is displaying in cart page

	public void orderHistory() throws IOException {
		String productName = "ZARA COAT 3";
		landingPage LandingPage = launchApplication();
		productCatalogue productCatalog = LandingPage.loginPageApp("preethi12@gmail.com", "Pree1234");
		orderPage orderPage = productCatalog.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		/*HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "preethi12@gmail.com");
		map.put("password", "Pree1234");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "preethi12@gmail.com");
		map1.put("password", "Pree1234");
		map1.put("productName", "ADIDAS ORIGINAL");*/
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir"+"\\src\\test\\java\\preethiAcademy\\data\\PurchaseOrder.json"));
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
}
