package br.com.rsinet.hub_bdd.stepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature",
				glue = "br.com.rsinet.hub_bdd.teste"
		)
public class RunnerTest {
	
}
