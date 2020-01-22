package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.page.DriverElement;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private WebDriver driver;

	@Before
	public void Inicializa() throws Exception {
		driver = DriverElement.getChromeDriver();
	}

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

}
