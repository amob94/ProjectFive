import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void mySetup() throws InterruptedException {
		String myURL = "https://www.saucedemo.com/";
		driver.get(myURL);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		WebElement UserName = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserName.sendKeys("standard_user");
		PasswordInputField.sendKeys("secret_sauce");
		LoginButton.click();

	}

	@Test(priority = 2)
	public void verifiyTheWordProductIsThere() {

		WebElement theMianNameOnTheWebSite = driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean expectedResult = true;
		boolean ActualifTheElementThere = theMianNameOnTheWebSite.isDisplayed();

		Assert.assertEquals(ActualifTheElementThere, expectedResult);

	}

	@Test(priority = 3)
	public void SortingItems() throws InterruptedException {
		Thread.sleep(1000);
		WebElement soso = driver.findElement(By.className("product_sort_container"));

		Select mySelctor = new Select(soso);

		mySelctor.selectByVisibleText("Price (low to high)");

		List<WebElement> ThePrices = driver.findElements(By.className("inventory_item_price"));
		String HighestPRiceAsText = ThePrices.getLast().getText().replace("$", "");
		String LowestPRiceASText = ThePrices.getFirst().getText().replace("$", "");
		System.out.println(HighestPRiceAsText);
		System.out.println(LowestPRiceASText);
		double  theHighestPrice = Double.parseDouble(HighestPRiceAsText); 
		double theLowestPrice = Double.parseDouble(LowestPRiceASText);
		
	boolean expectedValue = true ; 
		Assert.assertEquals(theHighestPrice<theLowestPrice, expectedValue,"if the highest price is higher than the lowest price this should return true ");
		

	
	}

	

}