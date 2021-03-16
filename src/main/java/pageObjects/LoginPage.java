package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	private By loginMobile = By.xpath("//input[@id='mobileNumber']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By alert = By.xpath("//div[@role='alertdialog']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getMobile()
	{
		return driver.findElement(loginMobile);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
}
