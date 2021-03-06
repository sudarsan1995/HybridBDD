package com.bdd.stepDefinitions;



import java.util.List;

import org.junit.Assert;

import com.bdd.driverfactory.DriverFactory;

import com.bdd.pageObjects.Registration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class RegistrationPage {
	
	private Registration r = new Registration(DriverFactory.getDriver());

@Given("user landed registration page {string}")
public void user_landed_registration_page(String ExpectedpageTitile) {

	DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
	r.clickonRegister();
	String actualPageTitle=r.getPageTitle();
	Assert.assertTrue(actualPageTitle.equals(ExpectedpageTitile));
  
}

@Then("click on the option male")
public void click_on_the_option_male() {
    
   r.clickOnMale();
}

@Then("Enter the data for the below fields")
public void enter_the_data_for_the_below_fields(DataTable datafromfeaturefile) {

	
	List<List<String>> testdata=datafromfeaturefile.asLists();
	
	String first_name=testdata.get(1).get(0);
	String Last_name=testdata.get(1).get(1);
	String e_mail=testdata.get(1).get(2);
	String pass_word=testdata.get(1).get(3);
	String conf_password=testdata.get(1).get(4);
	
	r.enterDetails(first_name, Last_name, e_mail, pass_word, conf_password);
	
	
	
	
}

@When("click on the register button")
public void click_on_the_register_button() {

	r.clickOnOk();
}

@Then("validate the resgitration success msg")
public void validate_the_resgitration_success_msg() {
 
	r.validateRegisterSuccessMessage();
}

@Then("click continue")
public void click_continue() {
   
	System.out.println("not required");
	
}

@Then("Logout the application")
public void logout_the_application() {
  
	r.logout();
}
	
	
	
}
