package com.bdd.Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bdd.Utils.ConfigReader;
import com.bdd.driverfactory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	 private DriverFactory driverfact;
	 private WebDriver driver;
	 private ConfigReader configread;
	 Properties pro;
	 
	 
	 @Before(order=0)
	 public void get_Property()
	 {
		 configread=new ConfigReader();
		pro= configread.initialize_the_properties();
		 
	 }
	 
	 @Before(order=1)
	 public void launch_browser()
	 {
		String browsername= pro.getProperty("browser");
		driverfact=new DriverFactory();
		driver=driverfact.initialize_driver(browsername);
	 }
	 
	 @After(order=1)
	 public void quit_Browser()
	 {
		 driver.quit();
	 }
	 
	 /*
	 @After(order=0)
	 public void get_Screenshot(Scenario scenario)
	 {
		
		 
		 if(scenario.isFailed())
		 {
			 String screenshotname=scenario.getName().replaceAll("", "_");
			 
			 byte[] sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(sourcepath, "image/png", screenshotname);
			 
		 }
		
			 
		 }
		*/
	
		 
	 

	 @AfterStep
	 public void getScreenshot_EachStep(Scenario scenario)
	 {
			
		
		 if(scenario.isFailed())
		 {
			 String screenshotname=scenario.getName().replaceAll("", "_");
			 
			 byte[] sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(sourcepath, "image/png", screenshotname);
			 
		 }
		 else {
			 
		 String screenshotname=scenario.getName();
		 byte[] sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(sourcepath, "image/png", screenshotname);
	 }
	
	 }
	 
	 
 
}
	 

