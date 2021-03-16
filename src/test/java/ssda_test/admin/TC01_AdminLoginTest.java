package ssda_test.admin;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminDashboardTab;
import pageObjects.LoginPage;
import resources.TestBase;
import resources.Utilities;

public class TC01_AdminLoginTest extends TestBase {

	public WebDriver driver;
	LoginPage lp;
	AdminDashboardTab adt;
	Utilities util;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		util = new Utilities();
		lp = new LoginPage(driver);
		adt = new AdminDashboardTab(driver);
	}

	@Test(priority=1)
	public void testAdminLoginWithValidCredentials() {
		driver.get(prop.getProperty("url"));
		log.info("Validate Admin login feature with valid credentials");
		lp.getMobile().sendKeys(prop.getProperty("admin_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("admin_password"));
		log.info("Enter valid Admin credentials and click on Login button");
		lp.getLogin().click();
		util.waitForElementToBeVisible(driver, adt.getClearDateButton(), 5);
		Assert.assertTrue(adt.getClearDateButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
		log.info("Admin Dashboard tab is displayed. Successfully validated Admin login with valid credentials");
	}
		
	@Test(priority=2)
	public void testOrdersDisplayedOnDashboardTab() {
		log.info("Validate whether Orders displayed on Admin Dashboard tab");
		Assert.assertTrue(adt.getNoOrdersFound().getText().contains("NO ORDERS FOUND"));
		util.waitForElementToBeInvisible(driver, adt.getNoOrdersFound(), 120);
		Assert.assertFalse(adt.getTotalPendingOrders().getText().contentEquals("0"));
		log.info("Orders are displayed on Admin Dashboard tab");
	}

	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
