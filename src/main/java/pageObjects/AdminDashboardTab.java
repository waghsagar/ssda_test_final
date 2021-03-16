package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDashboardTab {

	public WebDriver driver;
	
	private By dashboardTab = By.xpath("//div[contains(text(),'DASHBOARD')]//parent::div[@role='tab']");
	
	private By customersTab = By.xpath("//div[contains(text(),'CUSTOMERS')]//parent::div[@role='tab']");
	
	private By inventoryTab = By.xpath("//div[contains(text(),'INVENTORY')]//parent::div[@role='tab']");
	
	private By storeTab = By.xpath("//div[contains(text(),'STORE')]//parent::div[@role='tab']");
	
	private By ordersTab = By.xpath("//div[contains(text(),'ORDERS')]//parent::div[@role='tab']");
	
	private By clearDateButton = By.xpath("//button[.='Clear Date']");
	
	private By searchDateFilter = By.xpath("//button[.='Clear Date']//parent::div //input");
	
	private By updateDataButton = By.xpath("//button[.='Update Data']");
	
	private By UserMenu = By.xpath("//a[@id='dropdown']");
	
	private By changeEmailLink = By.xpath("//a[text()='Change Email/Password']");
	
	private By logoutLink = By.xpath("//a[text()='Logout']");
	
	private By ordersCompletedTotal = By.xpath("//h2[contains(.,'Orders Completed')]");
	
	private By noOrdersFound = By.xpath("//h1[contains(text(),'Pending Orders')]//following::div[1]/div[contains(text(),'NO ORDERS FOUND')]");
	
	private By totalPendingOrders = By.xpath("//h1[contains(text(),'Pending Orders')]//following::h1[1]/strong");
	
	private By totalReadyOrders = By.xpath("//h1[contains(text(),'Ready Orders')]//following::h1[1]/strong");
	
	private By totalCompletedOrders = By.xpath("//h1[contains(text(),'Completed Orders')]//following::h1[1]/strong");
	
	private By totalLapsedOrders = By.xpath("//h1[contains(text(),'Lapsed Orders')]//following::h1[1]/strong");
	
	private By totalCanceledOrders = By.xpath("//h1[contains(text(),'Canceled Orders')]//following::h1[1]/strong");
	
	private By ordersSlideRightButton = By.xpath("//a[@class='carousel-control-next']/span[2]");
	
	private By ordersSlideLeftButton = By.xpath("//a[@class='carousel-control-prev']/span[2]");
	
	private By pendingOrderNumber = By.xpath("//h1[contains(text(),'Pending Orders')]//following::table[1]/tbody/tr[1]/td/a");
	
	private By allPendingOrdersDashboard = By.xpath("//h1[contains(text(),'Pending Orders')]//following::table[1]/tbody/tr/td[1]");
	
	private By allPendingOrdersTimeslotDashboard = By.xpath("//h1[contains(text(),'Pending Orders')]//following::table[1]/tbody/tr/td[2]");
	
	private By pendingOrderTimeSlot = By.xpath("//h1[contains(text(),'Pending Orders')]//following::table[1]/tbody/tr[1]/td[2]");
	
	private By orderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr");
	
	private By productNameOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr[1]/td[2]");
	
	private By productQuantityOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr[1]/td[3]/input");
	
	private By productPriceOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr[1]/td[4]");
	
	private By totalPriceOrderDetailsWindow = By.xpath("//*[@role='dialog']//table[@role='grid']/tbody/tr[1]/td[5]");
	
	private By orderNumberOrderDetailsWindow = By.xpath("//*[@role='dialog'] //div[contains(.,'Order')]/div[1]");
	
	private By deliveryDateOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Delivery Date')]");
	
	private By timeSlotOrderDetailsWindow = By.xpath("//*[@role='dialog'] //a[contains(.,'Time Slot')]");
	
	private By statusOrderDetailsWindow = By.xpath("//*[@role='dialog'] //h5[contains(.,'Status')]");
	
	private By closeButtonOrderDetailsWindow = By.xpath("//button[contains(.,'Close')]");
	
	private By pageLoading = By.xpath("//p[contains(.,'Please Wait...')]");
	
	
	public AdminDashboardTab(WebDriver driver) {
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
	
	public WebElement getClearDateButton()
	{
		return driver.findElement(clearDateButton);
	}
	
	public WebElement getSearchDateFilter()
	{
		return driver.findElement(searchDateFilter);
	}
	
	public WebElement getUpdateDataButton()
	{
		return driver.findElement(updateDataButton);
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
	
	public WebElement getOrdersCompletedTotal() {
		return driver.findElement(ordersCompletedTotal);
	}
	
	public WebElement getNoOrdersFound() {
		return driver.findElement(noOrdersFound);
	}
	
	public WebElement getTotalPendingOrders() {
		return driver.findElement(totalPendingOrders);
	}
	
	public WebElement getTotalReadyOrders() {
		return driver.findElement(totalReadyOrders);
	}
	
	public WebElement getTotalCompletedOrders() {
		return driver.findElement(totalCompletedOrders);
	}
	
	public WebElement getTotalLapsedOrders() {
		return driver.findElement(totalLapsedOrders);
	}
	
	public WebElement getTotalCanceledOrders() {
		return driver.findElement(totalCanceledOrders);
	}
	
	public WebElement getOrdersSlideRightButton() {
		return driver.findElement(ordersSlideRightButton);
	}
	
	public WebElement getOrdersSlideLeftButton() {
		return driver.findElement(ordersSlideLeftButton);
	}
	
	public WebElement getPendingOrderNumber() {
		return driver.findElement(pendingOrderNumber);
	}
	
	public WebElement getPendingOrderTimeSlot() {
		return driver.findElement(pendingOrderTimeSlot);
	}
	
	public WebElement getOrderDetailsWindow() {
		return driver.findElement(orderDetailsWindow);
	}
	
	public WebElement getProductNameOrderDetailsWindow() {
		return driver.findElement(productNameOrderDetailsWindow);
	}
	
	public WebElement getProductQuantityOrderDetailsWindow() {
		return driver.findElement(productQuantityOrderDetailsWindow);
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
	
	public WebElement getStatusOrderDetailsWindow() {
		return driver.findElement(statusOrderDetailsWindow);
	}
	
	public WebElement getCloseButtonOrderDetailsWindow() {
		return driver.findElement(closeButtonOrderDetailsWindow);
	}
	
	public List<WebElement> getAllPendingOrdersDashboard() {
		return driver.findElements(allPendingOrdersDashboard);
	}
	
	public List<WebElement> getAllPendingOrdersTimeslotDashboard() {
		return driver.findElements(allPendingOrdersTimeslotDashboard);
	}
	
	public WebElement getPageLoading() {
		return driver.findElement(pageLoading);
	}
}
