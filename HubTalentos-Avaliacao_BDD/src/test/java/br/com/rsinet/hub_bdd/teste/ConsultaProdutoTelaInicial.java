package br.com.rsinet.hub_bdd.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.ProductPage;

public class ConsultaProdutoTelaInicial {

	private WebDriver driver;

	@Before
	public void Inicializa() throws Exception {

		driver = DriverElement.getChromeDriver();
	}

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

	@Test
	public void ConsultarProdutPelaTelaInicialComSucesso() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");

		homePage.clickMice();
		homePage.findElementLinkText(ExcelUtils.getCellData(3, 1));

		productPage.assertEqualsProduct(ExcelUtils.getCellData(3, 1));
		Screenshot.getScreenShot(driver, "Consultar Produto Pela Tela Inicial Com Sucesso",
				"TesteConsultaTelaPrincipalComSucesso");
	}

	@Test
	public void ConsultarProdutoPelaTelaInicialComFalha() throws Exception {

		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

		productPage.ClickEelementHPEliteBookFolioDetails();
		productPage.assertEqualsProduct("HP CHROMEBOOK 14 G1(ES)");

		Screenshot.getScreenShot(driver, "Consultar Produto Pela Tela Inicial Com Falha",
				"TesteConsultaTelaPrincipalComFalha");
	}

}
