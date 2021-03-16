package ssda_test.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

public class TC02_AdminOrdersTabFiltersValidationTest extends TestBase {

	public WebDriver driver;
	LoginPage lp;
	AdminDashboardTab adt;
	AdminOrdersTab aot;
	Utilities util;
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public String deliveryDate = "";
	public String orderNo = "";
	public String timeSlot = "";
	public String customerName = "";
	public String contact = "";
	public String amount = "";
	public String status = "";

	
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
	public void testCustomerOrdersDisplayedonOrderListPage() {
		log.info("Validate Orders displayed on Admin Order tab page");
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
		deliveryDate = aot.getDeliveryDateDetails().getText();
		util.doubleClick(driver, aot.getOrderNoHeader());
		log.info("User double clicks on OrderNo header to sort with recent orders placed");
		orderNo = aot.getOrderNoDetails().getText();
		//timeSlot = aot.getTimeslotDetails().getText();
		customerName = aot.getCustomerNameDetails().getText();
		//contact = aot.getContactDetails().getText();
		//amount = aot.getAmountDetails().getText();
		//status = aot.getStatusDetails().getText();
		log.info("Orders by Customer displayed on order tab page");
	}
	
	@Test(priority=2)
	public void testOrdersDisplayedPerPageFilter() {
		log.info("Validate if Orders are displayed per page as per option selected from dropdown");
		util.clickOnElementUsingActions(driver, aot.getItemsPerPageFilter());
		// Get the all WebElements inside the dropdown in List
		List<WebElement> dropdown_list = aot.getDropdownOptions();
		// Iterating through the list and selecting the desired option
		for(int j = 0; j < dropdown_list.size(); j++){
			if( dropdown_list.get(j).getText().contains("20")){
				dropdown_list.get(j).click();
				break;
			}
		}
		Assert.assertEquals(aot.getItemsPerPageFilter().getText(), "20");
		log.info("On Order list page user clicked option is displayed as selected");
		List<WebElement> totalSearchResult = aot.getTotalsearchResults();
		Assert.assertEquals(aot.getItemsPerPageFilter().getText(), String.valueOf(totalSearchResult.size()));
		log.info("On Order list page Orders displayed per page as per dropdown option selected");
	}
	
	@Test(priority=3)
	public void testSearchByOrderStatusFilter() {
		log.info("Validate if Orders are displayed as per Status selected from dropdown");
		ArrayList<String> orderStatus = new ArrayList<String>(Arrays.asList("Ready", "Pending", "Completed", "Lapsed", "Cancelled"));
		for(String status : orderStatus) {
			util.clickOnElementUsingActions(driver, aot.getStatusFilter());
			// Get the all WebElements inside the dropdown in List
			List<WebElement> dropdown_list = aot.getDropdownOptions();
			// Iterating through the list and selecting the desired option
			for(int j = 0; j < dropdown_list.size(); j++){
				if(dropdown_list.get(j).getText().contains(status)){
					log.info("Select "+ status +" from dropdown");
					dropdown_list.get(j).click();
					util.waitForAllElementsToBeInvisible(driver, aot.getDropdownOptions(), 30);
					break;
				}
			}
			List<WebElement> allOrderStatusDetails = aot.getAllOrderStatusDetailsList();
			for(int i = 0; i < allOrderStatusDetails.size(); i++){
				Assert.assertEquals(allOrderStatusDetails.get(i).getText(), status.toUpperCase());
			}
			log.info("On Orders tab page all orders displayed as per "+ status.toUpperCase() +" option selected from dropdown");
		}
	}
	
	@Test(priority=4)
	public void testSearchByOrderNumberFilter() {
		log.info("Validate search by order number feature on Order list page");
		aot.getClearFilterButton().click();
		log.info("User enters Order number to search from all orders");
		aot.getOrderNoFilter().sendKeys(orderNo);
		List<WebElement> allOrderNoDetails = aot.getOrderNoDetailsList();
		System.out.println("Total Orders found after search : "+ allOrderNoDetails.size());
		log.info("Total Orders found after search : "+ allOrderNoDetails.size());
		for(int i = 0; i < allOrderNoDetails.size(); i++){
			Assert.assertEquals(allOrderNoDetails.get(i).getText(), orderNo);
		}
		log.info("Orders found matches with order number searched by customer");
	}
	
	@Test(priority=5)
	public void testSearchByDeliveryDateFilter() {
		log.info("Validate search by delivery date feature on Order list page");
		aot.getClearFilterButton().click();
		log.info("User enters delivery date to search from all orders");
		aot.getDeliveryDateFilter().sendKeys(deliveryDate);
		aot.getDeliveryDateFilter().sendKeys(Keys.ENTER);
		List<WebElement> allDeliveryDateDetails = aot.getDeliveryDateDetailsList();
		System.out.println("Total Orders found after search : "+ allDeliveryDateDetails.size());
		log.info("Total Orders found after search : "+ allDeliveryDateDetails.size());
		for(int i = 0; i < allDeliveryDateDetails.size(); i++){
			Assert.assertEquals(allDeliveryDateDetails.get(i).getText(), deliveryDate);
		}
		log.info("All Orders found as per delivery date searched by User");
	}

	@Test(priority=6)
	public void testSearchByCustomerNameFilter() {
		log.info("Validate search by customer name feature on Order list page");
		aot.getClearFilterButton().click();
		log.info("User enters Customer name to search from all orders");
		aot.getCustomerNameFilter().sendKeys(customerName);
		List<WebElement> customerNameList = aot.getCustomerNameDetailsList();
		System.out.println("Total Orders found after search : "+ aot.getTotalOrdersFound().getText());
		log.info("Total Orders found after search : "+ aot.getTotalOrdersFound().getText());
		for(int i = 0; i < customerNameList.size(); i++){
			Assert.assertEquals(customerNameList.get(i).getText(), customerName);
		}
		log.info("All Orders found as per Customer Name searched by User");
	}
	
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
