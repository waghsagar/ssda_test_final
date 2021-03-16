package ssda_test.customer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomerHomePage;
import pageObjects.LoginPage;
import resources.TestBase;
import resources.Utilities;

public class TC08_CustLogoutTest extends TestBase{

	public WebDriver driver;
	LoginPage lp;
	CustomerHomePage chp;
	Utilities util;
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		util = new Utilities();
		lp = new LoginPage(driver);
		chp = new CustomerHomePage(driver);
	}
	
	@Test(priority=1)
	public void testCustomerLogout() {
		log.info("Validate logout functionality for customer account");
		lp.getMobile().sendKeys(prop.getProperty("cust_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("cust_password"));
		log.info("Enter valid customer credentials and click on Login button");
		lp.getLogin().click();
		util.waitForElementToBeInvisible(driver, chp.getNoRecordsFound(), 30);
		Assert.assertTrue(chp.getCheckoutButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("customer"));
		log.info("Customer home page is displayed");
		chp.getUserMenu().click();
		log.info("Customer clicks on UserMenu and then Logout link");
		chp.getLogoutLink().click();
		log.info("Customer logs out from application and login page is displayed");
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		log.info("Customer clicks on back button in browser to go back and open application again");
		driver.navigate().back();
		util.waitForElementToBeVisible(driver, chp.getAlert(), 30);
		Assert.assertTrue(chp.getAlert().isDisplayed());
		Assert.assertTrue(chp.getAlert().getText().contains("must login first"));
		log.info("Alert message displayed as You must login first!");
		util.waitForElementToBeInvisible(driver, chp.getAlert(), 30);
		Assert.assertTrue(lp.getMobile().isDisplayed());
	}

	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
