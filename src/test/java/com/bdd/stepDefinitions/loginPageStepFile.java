package com.bdd.stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bdd.driverfactory.DriverFactory;
import com.bdd.pageObjects.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class loginPageStepFile {

	public LoginPage lp = new LoginPage(DriverFactory.getDriver());
	Logger log= Logger.getLogger(loginPageStepFile.class);
	
	
	@Given("user in the loginpage")
	public void user_in_the_loginpage() {
		// Write code here that turns the phrase above into concrete actions

		DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
		lp.Login();
		log.info("clicked on login");
	}

	@Then("enter username {string}")
	public void enter_username(String un) {
		// Write code here that turns the phrase above into concrete actions

		lp.enter_username(un);
		log.info("username entered");
	}

	@Then("enter password {string}")
	public void enter_password(String pwd) {
		// Write code here that turns the phrase above into concrete actions
		
		lp.enter_password(pwd);
		log.info("pasword entered");
	}

	@Then("click Login")
	public void click_login() {
		// Write code here that turns the phrase above into concrete actions

		lp.ent();
		log.info("clicked on signin ");
	}

	@Then("Validate TitleofThePage {string}")
	public void validate_titleof_the_page(String Expected_title_of_the_page) {
		
		String titleofthepage = lp.get_TitleofthePage();
		Assert.assertTrue(titleofthepage.contains(Expected_title_of_the_page));
		log.info("title of the page is equal to expected title of the page ");
	}

	@Then("validate current userinformation {string}")
	public void validate_current_userinformation(String current_user_info) {
	
		Assert.assertTrue(current_user_info.equals(lp.Validate_Current_User_Information()));
		log.info("current user info is equal to expected user information ");
	}


}
