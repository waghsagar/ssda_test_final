package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOrdersTab {

	public WebDriver driver;
	
	private By dashboardTab = By.xpath("//div[contains(text(),'DASHBOARD')]//parent::div[@role='tab']");
	
	private By customersTab = By.xpath("//div[contains(text(),'CUSTOMERS')]//parent::div[@role='tab']");
	
	private By inventoryTab = By.xpath("//div[contains(text(),'INVENTORY')]//parent::div[@role='tab']");
	
	private By storeTab = By.xpath("//div[contains(text(),'STORE')]//parent::div[@role='tab']");
	
	private By ordersTab = By.xpath("//div[contains(text(),'ORDERS')]//parent::div[@role='tab']");
	
	private By UserMenu = By.xpath("//a[@id='dropdown']");
	
	private By changeEmailLink = By.xpath("//a[text()='Change Email/Password']");
	
	private By logoutLink = By.xpath("//a[text()='Logout']");
	
	private By customerNameFilter = By.xpath("//input[@placeholder='Customer Name']");
	
	private By orderNoFilter = By.xpath("//input[@placeholder='Order Number']");
	
	private By deliveryDateFilter = By.xpath("//span[contains(.,'Delivery Date')]//parent::div/input");
	
	private By statusFilter = By.xpath("//span[contains(.,'Status')]/label/span");
	
	private By itemsPerPageFilter = By.xpath("//mat-select[@aria-label='Items per page:']");
	
	private By dropdownOptions = By.xpath("//div[@class='cdk-overlay-pane']//mat-option");
	
	private By totalsearchResults = By.xpath("//table[@role='grid']/tbody/tr");
	
	private By totalOrdersFound = By.xpath("//h4[contains(.,'orders found')]");
	
	private By orderNoHeader = By.xpath("//table[@role='grid']//button[contains(., 'ORDER NO')]");
	
	private By deliveryDateHeader = By.xpath("//table[@role='grid']//button[contains(.,'DELIVERY DATE')]");
	
	private By slotHeader = By.xpath("//table[@role='grid']//button[contains(.,'SLOT')]");
	
	private By customerNameHeader = By.xpath("//table[@role='grid']//button[contains(.,'CUSTOMER NAME')]");
	
	private By orderNoDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[1]");
	
	private By orderNoDetailsList = By.xpath("//table[@role='grid']/tbody/tr/td[1]");
	
	private By deliveryDateDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[2]");
	
	private By deliveryDateDetailsList = By.xpath("//table[@role='grid']/tbody/tr/td[2]");
	
	private By timeslotDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[3]");
	
	private By customerNameDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[4]");
	
	private By customerNameDetailsList = By.xpath("//table[@role='grid']/tbody/tr/td[4]");
	
	private By contactDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]");
	
	private By amountDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[6]");
	
	private By statusDetails = By.xpath("//table[@role='grid']/tbody/tr[1]/td[7]");
	
	private By allOrderStatusDetailsList = By.xpath("//table[@role='grid']/tbody/tr/td[7]");
	
	private By viewOrderDetailsButton = By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/button[1]");
	
	private By assignToAggrButton = By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/button[2]");
	
	private By markAsDeliveredButton = By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/button[3]");
	
	private By cancelOrderButton = By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/button[4]");
	
	private By clearFilterButton = By.xpath("//button[contains(.,'Clear Filters')]");
	
	private By refreshButton = By.xpath("//button[contains(.,'Refresh')]");
	
	private By confirmOrderYesButton = By.xpath("//*[@role='dialog']//button[contains(.,'Yes')]");
	
	private By confirmOrderNoButton = By.xpath("//*[@role='dialog']//button[contains(.,'No')]");
	
	private By alert = By.xpath("//div[@role='alertdialog']");
	
	private By orderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr");
	
	private By productNameListOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[2]");
	
	private By productQuantityOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[3]/input");
	
	private By decreaseQuantityOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[3]/button[1]");
	
	private By increaseQuantityOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[3]/button[2]");
	
	private By removeProductOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[3]/ng-conatiner/button");
	
	private By productPriceOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[4]");
	
	private By totalPriceOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[5]");
	
	private By orderNumberOrderDetailsWindow = By.xpath("//*[@role='dialog'] //div[contains(.,'Order')]/div[1]");
	
	private By deliveryDateOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Delivery Date')]");
	
	private By timeSlotOrderDetailsWindow = By.xpath("//*[@role='dialog'] //a[contains(.,'Time Slot')]");
	
	private By custNameOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Customer Name')]");
	
	private By custContactOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Customer Contact')]");
	
	private By totalAmountOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Customer Contact')]//following::h1");
	
	private By statusOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Status')]");
	
	private By readyForDeliveryButtonOrderDetailsWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Ready for Delivery')]");
	
	private By closeButtonOrderDetailsWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Close')]");
	
	private By markAsDeliveredButtonOrderDetailsWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Mark as Delivered')]");
	
	private By printDetailsButtonOrderDetailsWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Print Details')]");
	
	private By assignToAggrWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr");
	
	private By aggrNameFilterAggrWindow = By.xpath("//*[@role='dialog']//input[@placeholder='Aggregator Name']");
	
	private By mobileNumberFilterAggrWindow = By.xpath("//*[@role='dialog']//input[@placeholder='Mobile Number']");
	
	private By categoryFilterAggrWindow = By.xpath("//*[@role='dialog']//span[contains(.,'Category')]/label/span");
	
	private By statusFilterAggrWindow = By.xpath("//*[@role='dialog']//span[contains(.,'Status')]/label/span");
	
	private By clearFilterButtonAggrWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Clear Filters')]");
	
	private By refreshButtonAggrWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Refresh')]");
	
	private By aggrNameListAggrWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[1]");
	
	private By aggrStatusListAggrWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[4]");
	
	private By assignAggrRadioButtonListAggrWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr/td[7]//input");
	
	private By closeButtonAggrWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Close')]");
	
	private By changeAggrButtonAggrWindow = By.xpath("//*[@role='dialog']//button[contains(.,'Change Aggregator')]");
	
	private By pageLoading = By.xpath("//p[contains(.,'Please Wait...')]");
	
	private By deliveryDate = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-title[1]/child::h4");
	
	private By deliveryTimeSlot = By.xpath("//div[@class='cdk-global-overlay-wrapper']//div[2]//mat-card[1]//mat-card-content[1]//div[1]//div[1]//button[1]");
	
	private By submitDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Submit')]");
	
	private By cancelDeliveryTimeSlot = By.xpath("//div[@class='cdk-overlay-pane']//button[contains(.,'Cancel')]");
	
	private By cancelOrderPopup = By.xpath("//app-cancel-order-dialog[@class='ng-star-inserted']/h2");
	
	private By cancelButtonOnCancelOrderPopup = By.xpath("//button/span[contains(.,'Cancel')]");

    private By proceedButtonOnCancelOrderPopup = By.xpath("//button/span[contains(.,'Proceed')]");
    
	
	public AdminOrdersTab(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getDashboardTab()
	{
		return driver.findElement(dashboardTab);
	}
	
	public WebElement getCustomersTab()
	{
		return driver.findElement(customersTab);
	}
	
	public WebElement getInventoryTab()
	{
		return driver.findElement(inventoryTab);
	}
	
	public WebElement getStoreTab()
	{
		return driver.findElement(storeTab);
	}
	
	public WebElement getOrdersTab()
	{
		return driver.findElement(ordersTab);
	}
	
	public WebElement getUserMenu() {
		return driver.findElement(UserMenu);
	}
	
	public WebElement getChangeEmailLink() {
		return driver.findElement(changeEmailLink);
	}
	
	public WebElement getLogoutLink() {
		return driver.findElement(logoutLink);
	}
	
	public WebElement getCustomerNameFilter() {
		return driver.findElement(customerNameFilter);
	}
	
	public WebElement getOrderNoFilter() {
		return driver.findElement(orderNoFilter);
	}
	
	public WebElement getDeliveryDateFilter() {
		return driver.findElement(deliveryDateFilter);
	}
	
	public WebElement getStatusFilter() {
		return driver.findElement(statusFilter);
	}
	
	public WebElement getItemsPerPageFilter() {
		return driver.findElement(itemsPerPageFilter);
	}
	
	public List<WebElement> getDropdownOptions() {
		return driver.findElements(dropdownOptions);
	}
	
	public List<WebElement> getTotalsearchResults() {
		return driver.findElements(totalsearchResults);
	}
	
	public WebElement getTotalOrdersFound() {
		return driver.findElement(totalOrdersFound);
	}
	
	public WebElement getOrderNoHeader() {
		return driver.findElement(orderNoHeader);
	}
	
	public WebElement getDeliveryDateHeader() {
		return driver.findElement(deliveryDateHeader);
	}
	
	public WebElement getSlotHeader() {
		return driver.findElement(slotHeader);
	}
	
	public WebElement getCustomerNameHeader() {
		return driver.findElement(customerNameHeader);
	}
	
	public WebElement getOrderNoDetails() {
		return driver.findElement(orderNoDetails);
	}
	
	public List<WebElement> getOrderNoDetailsList() {
		return driver.findElements(orderNoDetailsList);
	}
	
	public WebElement getDeliveryDateDetails() {
		return driver.findElement(deliveryDateDetails);
	}
	
	public List<WebElement> getDeliveryDateDetailsList() {
		return driver.findElements(deliveryDateDetailsList);
	}
	
	public WebElement getTimeslotDetails() {
		return driver.findElement(timeslotDetails);
	}
	
	public WebElement getCustomerNameDetails() {
		return driver.findElement(customerNameDetails);
	}
	
	public List<WebElement> getCustomerNameDetailsList() {
		return driver.findElements(customerNameDetailsList);
	}
	
	public WebElement getContactDetails() {
		return driver.findElement(contactDetails);
	}
	
	public WebElement getAmountDetails() {
		return driver.findElement(amountDetails);
	}
	
	public WebElement getStatusDetails() {
		return driver.findElement(statusDetails);
	}
	
	public List<WebElement> getAllOrderStatusDetailsList() {
		return driver.findElements(allOrderStatusDetailsList);
	}
	
	public WebElement getViewOrderDetailsButton() {
		return driver.findElement(viewOrderDetailsButton);
	}
	
	public WebElement getAssignToAggrButton() {
		return driver.findElement(assignToAggrButton);
	}
	
	public WebElement getMarkAsDeliveredButton() {
		return driver.findElement(markAsDeliveredButton);
	}
	
	public WebElement getCancelOrderButton() {
		return driver.findElement(cancelOrderButton);
	}
	
	public WebElement getClearFilterButton() {
		return driver.findElement(clearFilterButton);
	}
	
	public WebElement getRefreshButton() {
		return driver.findElement(refreshButton);
	}
	
	public WebElement getConfirmOrderYesButton() {
		return driver.findElement(confirmOrderYesButton);
	}
	
	public WebElement getConfirmOrderNoButton() {
		return driver.findElement(confirmOrderNoButton);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
	
	public WebElement getOrderDetailsWindow() {
		return driver.findElement(orderDetailsWindow);
	}
	
	public List<WebElement> getProductNameListOrderDetailsWindow() {
		return driver.findElements(productNameListOrderDetailsWindow);
	}
	
	public WebElement getProductQuantityOrderDetailsWindow() {
		return driver.findElement(productQuantityOrderDetailsWindow);
	}
	
	public WebElement getDecreaseQuantityButtonOrderDetailsWindow() {
		return driver.findElement(decreaseQuantityOrderDetailsWindow);
	}
	
	public WebElement getIncreaseQuantityButtonOrderDetailsWindow() {
		return driver.findElement(increaseQuantityOrderDetailsWindow);
	}
	
	public WebElement getRemoveProductButtonOrderDetailsWindow() {
		return driver.findElement(removeProductOrderDetailsWindow);
	}
	
	public WebElement getProductPriceOrderDetailsWindow() {
		return driver.findElement(productPriceOrderDetailsWindow);
	}
	
	public WebElement getTotalPriceOrderDetailsWindow() {
		return driver.findElement(totalPriceOrderDetailsWindow);
	}
	
	public WebElement getOrderNumberOrderDetailsWindow() {
		return driver.findElement(orderNumberOrderDetailsWindow);
	}
	
	public WebElement getDeliveryDateOrderDetailsWindow() {
		return driver.findElement(deliveryDateOrderDetailsWindow);
	}
	
	public WebElement getTimeSlotOrderDetailsWindow() {
		return driver.findElement(timeSlotOrderDetailsWindow);
	}
	
	public WebElement getCustomerNameOrderDetailsWindow() {
		return driver.findElement(custNameOrderDetailsWindow);
	}
	
	public WebElement getCustomerContactOrderDetailsWindow() {
		return driver.findElement(custContactOrderDetailsWindow);
	}
	
	public WebElement getTotalAmountOrderDetailsWindow() {
		return driver.findElement(totalAmountOrderDetailsWindow);
	}
	
	public WebElement getStatusOrderDetailsWindow() {
		return driver.findElement(statusOrderDetailsWindow);
	}
	
	public WebElement getReadyForDeliveryButtonOrderDetailsWindow() {
		return driver.findElement(readyForDeliveryButtonOrderDetailsWindow);
	}
	
	public WebElement getCloseButtonOrderDetailsWindow() {
		return driver.findElement(closeButtonOrderDetailsWindow);
	}
	
	public WebElement getMarkAsDeliveredButtonOrderDetailsWindow() {
		return driver.findElement(markAsDeliveredButtonOrderDetailsWindow);
	}
	
	public WebElement getPrintDetailsButtonOrderDetailsWindow() {
		return driver.findElement(printDetailsButtonOrderDetailsWindow);
	}
	
	public WebElement getAssignToAggrWindow() {
		return driver.findElement(assignToAggrWindow);
	}
	
	public WebElement getAggrNameFilterAggrWindow() {
		return driver.findElement(aggrNameFilterAggrWindow);
	}
	
	public WebElement getMobileNumberFilterAggrWindow() {
		return driver.findElement(mobileNumberFilterAggrWindow);
	}
	
	public WebElement getCategoryFilterAggrWindow() {
		return driver.findElement(categoryFilterAggrWindow);
	}
	
	public WebElement getStatusFilterAggrWindow() {
		return driver.findElement(statusFilterAggrWindow);
	}
	
	public WebElement getClearFilterButtonAggrWindow() {
		return driver.findElement(clearFilterButtonAggrWindow);
	}
	
	public WebElement getRefreshButtonAggrWindow() {
		return driver.findElement(refreshButtonAggrWindow);
	}
	
	public List<WebElement> getAggrNameListAggrWindow() {
		return driver.findElements(aggrNameListAggrWindow);
	}
	
	public List<WebElement> getAggrStatusListAggrWindow() {
		return driver.findElements(aggrStatusListAggrWindow);
	}
	
	public List<WebElement> getAssignAggrRadioButtonListAggrWindow() {
		return driver.findElements(assignAggrRadioButtonListAggrWindow);
	}
	
	public WebElement getCloseButtonAggrWindow() {
		return driver.findElement(closeButtonAggrWindow);
	}
	
	public WebElement getChangeAggrButtonAggrWindow() {
		return driver.findElement(changeAggrButtonAggrWindow);
	}
	
	public WebElement getPageLoading() {
		return driver.findElement(pageLoading);
	}
	
	public WebElement getSelectDeliveryDate() {
		return driver.findElement(deliveryDate);
	}
	
	public WebElement getSelectDeliveryTimeSlot() {
		return driver.findElement(deliveryTimeSlot);
	}
	
	public WebElement getSubmitDeliveryTimeSlot() {
		return driver.findElement(submitDeliveryTimeSlot);
	}
	
	public WebElement getCancelDeliveryTimeSlot() {
		return driver.findElement(cancelDeliveryTimeSlot);
	}
	
	public WebElement getCancelOrderPopup() {
		return driver.findElement(cancelOrderPopup);
	}
	
	public WebElement getCancelButtonOnCancelOrderPopup() {
		return driver.findElement(cancelButtonOnCancelOrderPopup);
	}
	
	public WebElement getProceedButtonOnCancelOrderPopup() {
		return driver.findElement(proceedButtonOnCancelOrderPopup);
	}
}
