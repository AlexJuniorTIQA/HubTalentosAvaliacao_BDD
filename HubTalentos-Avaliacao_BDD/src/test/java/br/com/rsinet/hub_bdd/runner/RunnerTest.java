package br.com.rsinet.hub_bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./feature/ConsultaProdutoBarraDePesquisa.feature",
				glue = "br.com.rsinet.hub_bdd.stepDefinition",
				monochrome = true)
public class RunnerTest {

}


