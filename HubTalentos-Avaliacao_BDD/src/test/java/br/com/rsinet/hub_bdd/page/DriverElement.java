package br.com.rsinet.hub_bdd.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/** Classe de parametrizão dos Drivers **/
public class DriverElement {
	static WebDriver driver;

	/**
	 * Método de parametrização do ChromeDriver, define Link, Espera de Elemento e
	 * Resolução
	 **/
	public static WebDriver getChromeDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1200, 1500));
		return driver;
	}

	/**
	 * Metodo de Parametrização do Driver, verifica se há algum aberto e se haver,
	 * fecha o mesmo
	 **/
	public static void quitDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}
}
