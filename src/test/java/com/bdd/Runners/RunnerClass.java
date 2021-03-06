package com.bdd.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/com/bdd/features"},
		glue = {"com/bdd/stepDefinitions", "com/bdd/Hooks"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		
		
	
		)

public class RunnerClass {

}
