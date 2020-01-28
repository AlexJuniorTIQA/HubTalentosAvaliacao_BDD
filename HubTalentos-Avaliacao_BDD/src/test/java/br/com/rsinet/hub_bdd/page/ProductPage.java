package br.com.rsinet.hub_bdd.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Classe de mapeamento de elementos: Página de Produtos do site
 * AdvantageOnlineShopping
 **/
public class ProductPage {

	final WebDriver driver;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/nav/a[3]")
	private WebElement elementProductName;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement elementAddToCart;

	@FindBy(how = How.ID, using = "menuCart")
	private WebElement elementMenuCart;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/label/span")
	private WebElement elementNotFound;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article[4]/div/div[2]/a/label")

	private WebElement elementHPEliteBookFolioDetails;

	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * Método de Comparação: Recebe um objeto do tipo String o convertendo para
	 * letras em caixa alta e o comparado com o nome de produto da página via
	 * getText
	 **/
	public void assertEqualsProduct(String expected) {
		Assert.assertEquals(expected.toUpperCase(), elementProductName.getText());
	}

	/**
	 * Método de Comparação: Recebe um objeto do tipo String e concatena com "No
	 * result for", o comparando com o texto Not Found da página via getText do
	 * elemento vegente
	 **/
	public void assertEqualsProductFail(String expected) {
		Assert.assertEquals("No results for \"" + expected + "\"", elementNotFound.getText());
	}
	/**Retorna um click ao Details do produto HP ELITE BOOK FOLIOS**/
	public void ClickEelementHPEliteBookFolioDetails() {
		elementHPEliteBookFolioDetails.click();
	}

}
