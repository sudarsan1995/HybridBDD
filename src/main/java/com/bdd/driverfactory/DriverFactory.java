package com.bdd.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlocaldriver=new ThreadLocal<>();
	
	// below method will drive about initialize driver 
	
	public WebDriver initialize_driver(String browser) // this paramater we will get it from configreader class
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlocaldriver.set(new ChromeDriver());
		}
		
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlocaldriver.set(new FirefoxDriver());
		}
		
		else if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlocaldriver.set(new EdgeDriver());
		}
		
		else 
		{
			System.out.println("Please pass the correct browsername" +browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
		
	}
	
	
	
	public static synchronized WebDriver getDriver()
	{
		return tlocaldriver.get();
	}
	
}

