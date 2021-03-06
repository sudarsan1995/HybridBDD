package com.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {

private WebDriver driver;
	
	private By email=By.xpath("//input[@id='Email']");
	private By Pasword=By.xpath("//input[@id='Password']");
	private By Enter=By.xpath("//input[@type='submit' and @value='Log in']");
	private By login=By.xpath("//a[@class='ico-login']");
	private By currentuser=By.xpath("(//a[contains(@href,'/customer/info')])[1]");
	

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String get_TitleofthePage()
	{
		return driver.getTitle();
	}
	
	
	public void enter_username(String username)
	{
		 driver.findElement(email).sendKeys(username);
		
		
	}
	
	public void enter_password(String password)
	{
		 driver.findElement(Pasword).sendKeys(password);
	}
	
	public void ent()
	{
		driver.findElement(Enter).click();
	}
	
	public void Login()
	{
		driver.findElement(login).click();
	}
	
	public String Validate_Current_User_Information()
	{
		return driver.findElement(currentuser).getText();
		
	}
	
	
}
