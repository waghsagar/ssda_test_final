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

public class TC08_PendingOrderDetailsWindowValidationOnAdminOrdersTab extends TestBase {

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
	public void testPendingOrderDetailsClickCloseButtonOnOrderDetailsWindow() {
		log.info("Validate Pending order details in Order Details window and click on Close Button");
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
			if(dropdown_list.get(j).getText().contains("Pending")){
				log.info("Select Pending from status dropdown to view Pending orders");
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

	@Test(priority=2)
	public void testDontSelectTimeslotClickSubmitButtonOnTimeSlotSelectionWindow() {
		log.info("Validate without selecting timeslot User clicks on Submit button for Pending order on Order Details window");
		aot.getViewOrderDetailsButton().click();
		util.waitForElementToBeVisible(driver, aot.getOrderDetailsWindow(), 30);
		Assert.assertTrue(aot.getOrderDetailsWindow().isDisplayed());
		log.info("Click Timeslot link on orders details window to change timeslot");
		util.clickOnElementUsingActions(driver, aot.getTimeSlotOrderDetailsWindow());
		util.waitForElementToBeVisible(driver, aot.getSelectDeliveryDate(), 30);
		Assert.assertTrue(aot.getSelectDeliveryTimeSlot().isEnabled());
		aot.getSubmitDeliveryTimeSlot().click();
		util.waitForElementToBeVisible(driver, aot.getAlert(), 30);
		Assert.assertTrue(aot.getAlert().isDisplayed());
		Assert.assertEquals(aot.getAlert().getText(), "Aggregator not available for selected timeslot");
		util.waitForElementToBeInvisible(driver, aot.getAlert(), 30);
		log.info("Aggregator not available for selected timeslot alert message displayed");
	}

	@Test(priority=3)
	public void testSelectTimeslotClickCancelButtonOnTimeSlotSelectionWindow() {
		log.info("Validate after selecting timeslot User clicks on Cancel button for Pending order on Order Details window");
		util.clickOnElementUsingActions(driver, aot.getTimeSlotOrderDetailsWindow());
		util.waitForElementToBeVisible(driver, aot.getSelectDeliveryDate(), 30);
		Assert.assertTrue(aot.getSelectDeliveryTimeSlot().isEnabled());
		aot.getSelectDeliveryTimeSlot().click();
		log.info("Customer selects the delivery timeslot and then clicks on Cancel button");
		aot.getCancelDeliveryTimeSlot().click();
		log.info("After clicking on Cancel button timeslot selection window closes");
	}

	@Test(priority=4)
	public void testSelectTimeslotClickSubmitButtonOnTimeSlotSelectionWindow() {
		log.info("Validate change timeslot of Pending order on Order Details window");
		util.clickOnElementUsingActions(driver, aot.getTimeSlotOrderDetailsWindow());
		util.waitForElementToBeVisible(driver, aot.getSelectDeliveryDate(), 30);
		deliveryDate = aot.getSelectDeliveryDate().getText();
		timeSlot = aot.getSelectDeliveryTimeSlot().getText();
		log.info("User selects new timeslot for Product delivery and click on Submit");
		aot.getSelectDeliveryTimeSlot().click();
		aot.getSubmitDeliveryTimeSlot().click();
		util.waitForElementToBeVisible(driver, aot.getAlert(), 120);
		Assert.assertTrue(aot.getAlert().isDisplayed());
		Assert.assertTrue(aot.getAlert().getText().contains("Timeslot changed"));
		util.waitForElementToBeInvisible(driver, aot.getAlert(), 30);
		Assert.assertTrue(aot.getTimeSlotOrderDetailsWindow().getText().contains(timeSlot));
		Assert.assertTrue(deliveryDate.contains(aot.getDeliveryDateOrderDetailsWindow().getText()));
		log.info("Validated updated delivery time & date after successful timeslot change");
	}

	@Test(priority=5)
	public void testIncreaseDecreaseQuantityOnOrderDetailsWindow() {
		log.info("Validate increase and decrease product quantity on Order Details window");
		Assert.assertTrue(aot.getOrderDetailsWindow().isDisplayed());
		log.info("orders details window displayed on Orders tab page");
		quantity = Integer.parseInt(aot.getProductQuantityOrderDetailsWindow().getAttribute("value"));
		if(aot.getIncreaseQuantityButtonOrderDetailsWindow().isEnabled()) {
			aot.getIncreaseQuantityButtonOrderDetailsWindow().click();
			System.out.println("Quantity after clicking on Plus button: "+ aot.getProductQuantityOrderDetailsWindow().getAttribute("value"));
			Assert.assertEquals(aot.getProductQuantityOrderDetailsWindow().getAttribute("value"),String.valueOf(quantity+1));
			if (aot.getDecreaseQuantityButtonOrderDetailsWindow().isEnabled()) {
				aot.getDecreaseQuantityButtonOrderDetailsWindow().click();
				System.out.println("Quantity after clicking on Minus button: "+ aot.getProductQuantityOrderDetailsWindow().getAttribute("value"));
				Assert.assertEquals(aot.getProductQuantityOrderDetailsWindow().getAttribute("value"),String.valueOf(quantity));
				log.info("User can increase or decrease product quantity on Order Details window");
			}
		} else {
			Assert.assertFalse(aot.getIncreaseQuantityButtonOrderDetailsWindow().isEnabled());
			log.info("Increase quantity button is disabled as only one item quantity per order is allowed for selected product");
		}
	}

	@Test(priority=6)
	public void testClickReadyForDeliveryButtonOnOrderDetailsWindow() {
		log.info("Validate after clicking ReadyForDelivery button order status changes to Ready");
		aot.getReadyForDeliveryButtonOrderDetailsWindow().click();
		log.info("User clicks on ReadyForDelivery Button on Order Details window");
		util.waitForElementToBeVisible(driver, aot.getAlert(), 60);
		Assert.assertTrue(aot.getAlert().isDisplayed());
		Assert.assertTrue(aot.getAlert().getText().contains("Status successfully Changed"));
		log.info("Status successfully Changed alert message displayed");
		util.waitForElementToBeInvisible(driver, aot.getAlert(), 30);
		util.waitForElementToBeInvisible(driver, aot.getPageLoading(), 60);
		Assert.assertTrue(aot.getTimeslotDetails().isDisplayed());
		log.info("Customer orders displayed on Orders tab page");
		aot.getClearFilterButton().click();
		aot.getOrderNoFilter().sendKeys(orderNo);
		Assert.assertEquals(aot.getOrderNoDetails().getText(), orderNo);
		Assert.assertEquals(aot.getStatusDetails().getText(), "READY");
		log.info("After clicking ReadyForDelivery button on Order Details window order status changes to Ready");
	}
	
	@Test(priority=7)
	public void testRemoveItemFromPendingOrderOnOrderDetailsWindow() {
		log.info("Validate remove items from Pending order present on order details window");
		aot.getClearFilterButton().click();
		util.clickOnElementUsingActions(driver, aot.getStatusFilter());
		// Get the all WebElements inside the dropdown in List
		List<WebElement> dropdown_list = aot.getDropdownOptions();
		// Iterating through the list and selecting the desired option
		for(int j = 0; j < dropdown_list.size(); j++){
			if(dropdown_list.get(j).getText().contains("Pending")){
				log.info("Select Pending from status dropdown to view Pending orders");
				dropdown_list.get(j).click();
				util.waitForAllElementsToBeInvisible(driver, aot.getDropdownOptions(), 30);
				break;
			}
		}
		util.doubleClick(driver, aot.getOrderNoHeader());
		log.info("User double clicks on OrderNo header to sort with recent orders placed");
		orderNo = aot.getOrderNoDetails().getText();
		aot.getViewOrderDetailsButton().click();
		util.waitForElementToBeVisible(driver, aot.getOrderDetailsWindow(), 30);
		Assert.assertTrue(aot.getOrderDetailsWindow().isDisplayed());
		log.info("Orders details window displayed on Orders tab page");
		while (aot.getProductNameListOrderDetailsWindow().size() > 1){
			log.info("Multiple items present in order displayed on Order details window");
			int numberOfProducts = aot.getProductNameListOrderDetailsWindow().size();
			aot.getRemoveProductButtonOrderDetailsWindow().click();
			log.info("User clicks on Remove item from order button");
			List<WebElement> newProductlistAfterRemoveClick= aot.getProductNameListOrderDetailsWindow();
			Assert.assertEquals(newProductlistAfterRemoveClick.size(), (numberOfProducts-1));
			log.info("Number of items in order list are reduced by 1");
		}
		Assert.assertEquals(aot.getProductNameListOrderDetailsWindow().size(), 1);
		log.info("Only one item present in order displayed on Order details window");
	}

	@Test(priority=8)
	public void testClickCancelButtonOnCancelOrderConfirmationPopup() {
		log.info("Validate after clicking Cancel button on Cancel Order Confirmation popup order details window closed");
		aot.getRemoveProductButtonOrderDetailsWindow().click();
		util.waitForElementToBeVisible(driver, aot.getCancelOrderPopup(), 30);
		log.info("Cancel Order Confirmation popup displayed");
		Assert.assertTrue(aot.getCancelOrderPopup().isDisplayed());
		log.info("Click on Cancel button on Cancel Order Confirmation popup");
		aot.getCancelButtonOnCancelOrderPopup().click();
		util.waitForElementToBeInvisible(driver, aot.getPageLoading(), 40);
		Assert.assertTrue(aot.getTimeslotDetails().isDisplayed());
		log.info("After clicking Cancel button on Cancel Order Confirmation popup order details window closed");
	}

	@Test(priority=9)
	public void testClickProceedButtonOnCancelOrderConfirmationPopup() {
		log.info("Validate after clicking Proceed button on Cancel Order Confirmation popup order status changes to Cancelled");
		aot.getViewOrderDetailsButton().click();
		util.waitForElementToBeVisible(driver, aot.getOrderDetailsWindow(), 30);
		Assert.assertTrue(aot.getOrderDetailsWindow().isDisplayed());
		while (aot.getProductNameListOrderDetailsWindow().size() > 1){
			aot.getRemoveProductButtonOrderDetailsWindow().click();
		}
		Assert.assertEquals(aot.getProductNameListOrderDetailsWindow().size(), 1);
		log.info("Only one item present in order displayed on Order details window");
		aot.getRemoveProductButtonOrderDetailsWindow().click();
		util.waitForElementToBeVisible(driver, aot.getCancelOrderPopup(), 30);
		log.info("Cancel Order Confirmation popup displayed");
		Assert.assertTrue(aot.getCancelOrderPopup().isDisplayed());
		log.info("Click on Proceed button on Cancel Order Confirmation popup");
		aot.getProceedButtonOnCancelOrderPopup().click();
		util.waitForElementToBeVisible(driver, aot.getAlert(), 60);
		Assert.assertTrue(aot.getAlert().isDisplayed());
		Assert.assertTrue(aot.getAlert().getText().contains("Cancelled"));
		log.info("Order cancelled successfully alert message displayed");
		util.waitForElementToBeInvisible(driver, aot.getAlert(), 30);
		util.waitForElementToBeInvisible(driver, aot.getPageLoading(), 60);
		Assert.assertTrue(aot.getTimeslotDetails().isDisplayed());
		log.info("Customer orders displayed on Orders tab page");
		aot.getClearFilterButton().click();
		aot.getOrderNoFilter().sendKeys(orderNo);
		Assert.assertEquals(aot.getOrderNoDetails().getText(), orderNo);
		Assert.assertEquals(aot.getStatusDetails().getText(), "CANCELLED");
		log.info("After clicking Proceed button on Cancel Order Confirmation popup order status changes to Cancelled");
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
