package br.com.rsinet.hub_bdd.page;

import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe de mapeamento de elementos: HomePage do site AdvantageOnlineShopping
 **/
public class HomePage {

	final WebDriver driver;
	///////////// Elements: Account Details////////////////
	@FindBy(how = How.ID, using = "menuUser")

	public WebElement elementIconUser;

	@FindBy(how = How.ID, using = "menuSearch")

	private WebElement elementIconSearch;

	@FindBy(how = How.ID, using = "autoComplete")

	private WebElement elementSearch;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")

	private WebElement elementCreatNewAccount;

	@FindBy(how = How.ID, using = "tabletsTxt")

	private WebElement elementTablets;

	@FindBy(how = How.ID, using = "headphonesTxt")

	private WebElement elementHeadPhones;

	@FindBy(how = How.ID, using = "speakersTxt")

	private WebElement elementSpeakers;

	@FindBy(how = How.ID, using = "laptopsTxt")

	private WebElement elementLaptops;

	@FindBy(how = How.ID, using = "miceTxt")

	private WebElement elementMice;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[3]/a/span")
	private WebElement elementUserLink;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	/** Retorna um click ao Icone de Usuário **/
	public void clickIconuser() {
		elementIconUser.click();
	}

	/** Retorna um click ao Icone de Criar Nova Conta **/
	public void clickCreatNewAccount() {
		elementCreatNewAccount.sendKeys(Keys.ENTER);
	}

	/**
	 * Método de click por meio do JavaScriptExecutor, recebe como parâmetro um
	 * objeto do tipo By. Metodo de click útil quando o click padrão do
	 * DriverElement não esperá o elemento aparecer
	 **/
	public void javaScriptClick(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(by));
	}

	/**
	 * Recebe como parâmetro um objeto do tipo String para pesquisa de elemento via
	 * By.LinkTextm, retorna um click via JavaScripteExecutor
	 **/
	public void findElementLinkText(String linkText) {
		javaScriptClick(By.linkText(linkText));
	}

	/**
	 * Método para pesquisa na barra superior, recebe como parâmetro um objeto do
	 * tipo String e interage enviando um SendKeys mais a Tecla Enter
	 **/
	public void setSearch(String search) {
		elementSearch.sendKeys(search + Keys.ENTER);
	}

	/**
	 * Método de espera para Página inicial, utiliza um JavaScriptExecutor e WebDriverWait,
	 * aguardando á página inicial do site AdvantageOnlineShopping ser carregada
	 **/
	public void waitHome() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
	}

	/**
	 * Método para Comparação: Recebe um objeto do tipo String de
	 * expectativa, e compara com o usuário logado na página
	 **/
	public void assertEqualsUser(String expected) {
		Assert.assertEquals(expected, elementUserLink.getText());
	}

	/** Retorna um click ao Icone de pesquisa **/
	public void clickIconSearch() {
		elementIconSearch.click();
	}
	/**Retorna um click via JavAScriptExecutor ao Icone de Mouse(Mice)**/
	public void clickMice() {
		javaScriptClick(By.id("miceTxt"));
	}

}