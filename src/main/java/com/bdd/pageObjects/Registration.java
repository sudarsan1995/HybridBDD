package com.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;






public class Registration {

private WebDriver driver;
	
	private By register=By.xpath("//a[@class='ico-register']");
	private By male=By.xpath("//label[@for='gender-male']");
	private By female=By.xpath("//label[@for='gender-female']");
	private By firstname=By.xpath("//input[@name='FirstName']");
	private By lastname=By.xpath("//input[@name='LastName']");
	private By email=By.xpath("//input[@name='Email']");
	private By password=By.xpath("//input[@name='Password']");
	private By confirmpassword=By.xpath("//input[@name='ConfirmPassword']");
	private By ok=By.xpath("//input[@value='Register']");
	private By regsitercompletionmesage=By.xpath("//div[@class='result']");
	private By currentuserinfo=By.xpath("(//a[@class='account'])[1]");
	private By logout=By.xpath("//a[@class='ico-logout']");
	
	public Registration(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isRegisterLinkPresented()
	{
		return driver.findElement(register).isDisplayed();
	}
	
	public void clickOnMale()
	{
		driver.findElement(male).click();
	}
	
	public void clickonRegister()
	{
	 driver.findElement(register).click();
	}
	
	
	
	public void enterDetails(String firstnam,String lastnam,String emailid,String pwd,String confirmpwd)
	{

		driver.findElement(firstname).sendKeys(firstnam);
		driver.findElement(lastname).sendKeys(lastnam);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmpassword).sendKeys(confirmpwd);
	
		
		
	}
	
	
	
	
	
	public void clickOnOk()
	{
		driver.findElement(ok).click();
	}
	
	public void validateRegisterSuccessMessage()
	{
		String textofthemessage= driver.findElement(regsitercompletionmesage).getText().trim();
		if(textofthemessage.contains("Your registration completed"))
		{
			System.out.println("registration successfull");
		}
		
	}
	
	public  void validateCurrentUser()
	{
		String currentuser= driver.findElement(currentuserinfo).getText();
		if(currentuser.contains("test.com"))
		{
			System.out.println("current user logged in successfull");
		}
		
	}
	
	public void logout()
	{
		driver.findElement(logout).click();;
	}
	
	
}
