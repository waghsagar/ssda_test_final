package ssda_test.admin;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AdminDashboardTab;
import pageObjects.AdminOrdersTab;
import pageObjects.LoginPage;
import resources.TestBase;
import resources.Utilities;

public class TC05_AdminDashboardCompletedOrderDetailsValidationTest extends TestBase {

	public WebDriver driver;
	LoginPage lp;
	AdminDashboardTab adt;
	AdminOrdersTab aot;
	Utilities util;
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public String deliveryDate = "";
	public String status = "Completed";
	public String totalCompletedOrders = "";

	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		util = new Utilities();
		lp = new LoginPage(driver);
		adt = new AdminDashboardTab(driver);
		aot = new AdminOrdersTab(driver);
	}

	@Test(priority=1)
	public void testTotalCompletedOrdersDisplayedOnDashboardTab() {
		log.info("Validate Orders displayed on Admin Order tab page");
		lp.getMobile().sendKeys(prop.getProperty("admin_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("admin_password"));
		lp.getLogin().click();
		util.waitForElementToBeVisible(driver, adt.getClearDateButton(), 5);
		Assert.assertTrue(adt.getClearDateButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
		adt.getClearDateButton().click();
		util.waitForElementToBeInvisible(driver, adt.getNoOrdersFound(), 120);
		Assert.assertFalse(adt.getTotalCompletedOrders().getText().contentEquals("0"));
		log.info("Completed orders are displayed on Admin Dashboard tab");
		totalCompletedOrders = adt.getTotalCompletedOrders().getText();
		log.info("Customer clicks on Orders tab");
		adt.getOrdersTab().click();
		log.info("Order tab page opens");
		util.waitForElementToBeVisible(driver, aot.getOrderNoDetails(), 60);
		Assert.assertTrue(aot.getOrderNoDetails().isDisplayed());
		log.info("Customer orders displayed on Orders tab page");
		util.clickOnElementUsingActions(driver, aot.getStatusFilter());
		// Get the all WebElements inside the dropdown in List
		List<WebElement> dropdown_list = aot.getDropdownOptions();
		// Iterating through the list and selecting the desired option
		for(int j = 0; j < dropdown_list.size(); j++){
			if(dropdown_list.get(j).getText().contains(status)){
				log.info("Select "+ status +" from status dropdown");
				dropdown_list.get(j).click();
				util.waitForAllElementsToBeInvisible(driver, aot.getDropdownOptions(), 30);
				break;
			}
		}
		Assert.assertTrue(aot.getTotalOrdersFound().getText().contains(totalCompletedOrders));
		log.info("Total Completed orders displayed on Dashboard tab matches with Completed orders displayed on Orders tab");
	}
	
	@Test(priority=2)
	public void testSearchByDateFilterForCompletedOrders() {
		log.info("Validate search by date filter on dashboard tab for Completed orders");
		util.doubleClick(driver, aot.getOrderNoHeader());
		log.info("User double clicks on OrderNo header to sort with recent orders placed");
		deliveryDate = aot.getDeliveryDateDetails().getText();
		log.info("User enters delivery date to search from all orders");
		aot.getDeliveryDateFilter().sendKeys(deliveryDate);
		aot.getDeliveryDateFilter().sendKeys(Keys.ENTER);
		
		String totalCompletedOrders = aot.getTotalOrdersFound().getText();
		aot.getDashboardTab().click();
		util.waitForElementToBeInvisible(driver, adt.getPageLoading(), 30);
		util.waitForElementToBeInvisible(driver, adt.getNoOrdersFound(), 120);
		Assert.assertFalse(adt.getTotalCompletedOrders().getText().contentEquals("0"));
		adt.getSearchDateFilter().sendKeys(deliveryDate);
		adt.getSearchDateFilter().sendKeys(Keys.ENTER);
		
		Assert.assertTrue(totalCompletedOrders.contains(adt.getTotalCompletedOrders().getText()));
		log.info("Completed orders by date displayed on Dashboard tab matches with Completed orders by date displayed on Orders tab");
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
