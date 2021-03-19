package com.bdd.stepDefinitions;



import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bdd.driverfactory.DriverFactory;

import com.bdd.pageObjects.Registration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class RegistrationPage {
	
	private Registration r = new Registration(DriverFactory.getDriver());
	Logger log= Logger.getLogger(loginPageStepFile.class);

@Given("user landed registration page {string}")
public void user_landed_registration_page(String ExpectedpageTitile) {

	DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
	log.info("URL Entered");
	r.clickonRegister();
	log.info("clicked on register");
	String actualPageTitle=r.getPageTitle();
	Assert.assertTrue(actualPageTitle.equals(ExpectedpageTitile));
	log.info("actual page title is equal to expected page title");
  
}

@Then("click on the option male")
public void click_on_the_option_male() {
    
   r.clickOnMale();
   log.info("Cliekd on male radio button");
}

@Then("Enter the data for the below fields")
public void enter_the_data_for_the_below_fields(DataTable datafromfeaturefile) {

	
	List<List<String>> testdata=datafromfeaturefile.asLists();
	
	String first_name=testdata.get(1).get(0);
	log.info("first name saved in first name variable");
	String Last_name=testdata.get(1).get(1);
	log.info("last name saved in last name variable");
	String e_mail=testdata.get(1).get(2);
	log.info("email  saved in email  variable");
	String pass_word=testdata.get(1).get(3);
	log.info("password  saved in password variable");
	String conf_password=testdata.get(1).get(4);
	log.info("confirm password vauliue name saved in confirm password name variable");
	
	r.enterDetails(first_name, Last_name, e_mail, pass_word, conf_password);
	
	log.info("Entered all the manadatory fields");
	
	
	
	
}

@When("click on the register button")
public void click_on_the_register_button() {

	r.clickOnOk();
	log.info("Clicked on Ok");
}

@Then("validate the resgitration success msg")
public void validate_the_resgitration_success_msg() {
 
	r.validateRegisterSuccessMessage();
	log.info("regsitration suvvesss message popped up");
}

@Then("click continue")
public void click_continue() {
   
	log.info("not required");
	
	
	
}

@Then("Logout the application")
public void logout_the_application() {
  
	r.logout();
	log.info("logout successfull");
}
	
	
	
}
