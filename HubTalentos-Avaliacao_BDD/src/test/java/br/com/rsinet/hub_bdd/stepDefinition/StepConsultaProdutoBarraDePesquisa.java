package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class StepConsultaProdutoBarraDePesquisa {
	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

	@Dado("^que estou na homepage do site$")
	public void que_estou_na_homepage_do_site() throws Throwable {
		driver = DriverElement.getChromeDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Headphone");
	}

	@Dado("^clico na barra de pesquisa$")
	public void clico_na_barra_de_pesquisa() throws Throwable {
		homePage.clickIconSearch();
	}

	@Quando("^pesquiso um produto válido no site$")
	public void pesquiso_um_produto_válido_no_site() throws Throwable {
		homePage.setSearch(ExcelUtils.getCellData(1, 1));
		homePage.findElementLinkText(ExcelUtils.getCellData(1, 1));

	}

	@Então("^o site me retorna o produto pesquisado$")
	public void o_site_me_retorna_o_produto_pesquisado() throws Throwable {
		productPage.assertEqualsProduct(ExcelUtils.getCellData(1, 1));
		Screenshot.getScreenShot(driver, "Consultar Produto Com Sucesso", "TesteConsultaProdutoComSucesso");

	}

	@Quando("^pesquiso um produto inválido no site$")
	public void pesquiso_um_produto_inválido_no_site() throws Throwable {
		homePage.clickIconSearch();
		homePage.setSearch(ExcelUtils.getCellData(6, 1));

	}

	@Então("^o site me retorna que o produto não foi encontrado$")
	public void o_site_me_retorna_que_o_produto_não_foi_encontrado() throws Throwable {
		productPage.assertEqualsProductFail(ExcelUtils.getCellData(6, 1));
		Screenshot.getScreenShot(driver, "Consultar Produto Com Falha", "TesteConsultaProdutoFalha");
	}

}
