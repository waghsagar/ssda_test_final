package ssda_test.admin;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class TC12_CancelledOrderDetailsWindowValidationOnAdminOrdersTab extends TestBase {

	public WebDriver driver;
	LoginPage lp;
	AdminDashboardTab adt;
	AdminOrdersTab aot;
	Utilities util;

	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public String deliveryDate = "";
	public String status = "";
	public String totalCanceledOrders = "";
	public String orderNo = "";
	public String timeSlot = "";
	public String customerName = "";
	public String contact = "";
	public String amount = "";
	public int quantity = 0;


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
	public void testCancelledOrderDetailsClickCloseButtonOnOrderDetailsWindow() {
		log.info("Validate Cancelled order details in Order Details window and click on Close Button");
		lp.getMobile().sendKeys(prop.getProperty("admin_mobile"));
		lp.getPassword().sendKeys(prop.getProperty("admin_password"));
		lp.getLogin().click();
		util.waitForElementToBeVisible(driver, adt.getClearDateButton(), 5);
		Assert.assertTrue(adt.getClearDateButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
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
			if(dropdown_list.get(j).getText().contains("Cancelled")){
				log.info("Select Cancelled from status dropdown to view Cancelled orders");
				dropdown_list.get(j).click();
				util.waitForAllElementsToBeInvisible(driver, aot.getDropdownOptions(), 30);
				break;
			}
		}
		util.doubleClick(driver, aot.getOrderNoHeader());
		log.info("User double clicks on OrderNo header to sort with recent orders placed");
		orderNo = aot.getOrderNoDetails().getText();
		deliveryDate = aot.getDeliveryDateDetails().getText();
		timeSlot = aot.getTimeslotDetails().getText();
		customerName = aot.getCustomerNameDetails().getText();
		contact = aot.getContactDetails().getText();
		amount = aot.getAmountDetails().getText();
		status = aot.getStatusDetails().getText();	
		log.info("User clicks on Order Details button");
		aot.getViewOrderDetailsButton().click();
		util.waitForElementToBeVisible(driver, aot.getOrderDetailsWindow(), 30);
		Assert.assertTrue(aot.getOrderDetailsWindow().isDisplayed());
		log.info("Orders Details window displayed on Orders tab page");
		Assert.assertTrue(aot.getOrderNumberOrderDetailsWindow().getText().contains(orderNo));
		Assert.assertTrue(aot.getDeliveryDateOrderDetailsWindow().getText().contains(deliveryDate));
		Assert.assertTrue(aot.getTimeSlotOrderDetailsWindow().getText().contains(timeSlot));
		Assert.assertTrue(aot.getStatusOrderDetailsWindow().getText().contains(status));
		Assert.assertTrue(aot.getCustomerNameOrderDetailsWindow().getText().contains(customerName));
		Assert.assertTrue(aot.getCustomerContactOrderDetailsWindow().getText().contains(contact));
		Assert.assertEquals(aot.getTotalAmountOrderDetailsWindow().getText(), amount);
		log.info("Customer order details displayed in Order Details window are correct");
		aot.getCloseButtonOrderDetailsWindow().click();
		log.info("Click on Close Button on Order Details window");
		util.waitForElementToBeInvisible(driver, aot.getPageLoading(), 60);
		Assert.assertTrue(aot.getTimeslotDetails().isDisplayed());
	}

	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
