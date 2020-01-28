package br.com.rsinet.hub_bdd.runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./feature/",
				glue = "br.com.rsinet.hub_bdd.stepDefinition",
				//tag={"@tag"}, 
				plugin = {
						"com.cucumber.listener.ExtentCucumberFormatter:target/reports/StepsReportTest.html" })
public class RunnerTest {
	@AfterClass
	public static void writeExtentReport() throws IOException { 		
		Reporter.loadXMLConfig(new File("./extent-config.xml"));
	}
}

