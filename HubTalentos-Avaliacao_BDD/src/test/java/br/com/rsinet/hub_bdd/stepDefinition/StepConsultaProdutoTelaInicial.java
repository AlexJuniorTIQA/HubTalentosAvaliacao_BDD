package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.RegisterPage;
import br.com.rsinet.hub_bdd.page.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class StepConsultaProdutoTelaInicial {
	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

	@Dado("^que estou na pagina inicial do site$")
	public void que_estou_na_pagina_inicial_do_site() throws Throwable {
		driver = DriverElement.getChromeDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");
	}
	

	@Quando("^clico em um dos produtos$")
	public void clico_em_um_dos_produtos() throws Throwable {
		homePage.clickMice();
		homePage.findElementLinkText(ExcelUtils.getCellData(3, 1));

	}

	@E("^acesso a página do produto$")
	public void acesso_á_página_do_produto() throws Throwable {
		productPage.assertEqualsProduct(ExcelUtils.getCellData(3, 1));
		Screenshot.getScreenShot(driver, "TesteConsultaTelaPrincipalSucesso ");
	}
	@Quando("^clico no item HP elitebook Folio$")
	public void clico_no_item_HP_elitebook_Folio() throws Throwable {
		homePage.waitHome();
		productPage.ClickEelementHPEliteBookFolioDetails();
	}

	@Então("^acesso a página de outro produto$")
	public void acesso_á_página_de_outro_produto() throws Throwable {
		productPage.assertEqualsProduct("HP CHROMEBOOK 14 G1(ES)");
		Screenshot.getScreenShot(driver, "TesteConsultaTelaPrincipalFalha ");
	}

}
