package br.com.rsinet.hub_bdd.teste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.PageRegister;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarCliente {

	private WebDriver driver;
	private HomePage homePage;
	private PageRegister pageRegister;
	
	 

	@Before
	public void Inicializa() throws Exception {
		driver = DriverElement.getChromeDriver();
	}

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

	@Dado("^que eu estou na home do site$")
	public void que_eu_estou_na_home_do_site() throws Throwable {
		homePage = PageFactory.initElements(driver, HomePage.class);
		pageRegister = PageFactory.initElements(driver, PageRegister.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

	}

	@Quando("^clico no icone de login e em nova conta$")
	public void clico_no_icone_de_login_e_em_nova_conta() throws Throwable {
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();
	}

	@Quando("^preencho todos os dados$")
	public void preencho_todos_os_dados() throws Throwable {
		pageRegister.setUserName(ExcelUtils.getCellData(1, 1));
		pageRegister.setEmail(ExcelUtils.getCellData(1, 2));
		pageRegister.setPassword(ExcelUtils.getCellData(1, 3));
		pageRegister.setConfirmPassword(ExcelUtils.getCellData(1, 3));

		pageRegister.setFirstName(ExcelUtils.getCellData(1, 4));
		pageRegister.setLastName(ExcelUtils.getCellData(1, 5));
		pageRegister.setPhoneNumber(ExcelUtils.getCellData(1, 6));

		pageRegister.selectCountry(ExcelUtils.getCellData(1, 7));
		pageRegister.setCity(ExcelUtils.getCellData(1, 8));
		pageRegister.setAdress(ExcelUtils.getCellData(1, 9));
		pageRegister.setState(ExcelUtils.getCellData(1, 10));
		pageRegister.setPostalCode(ExcelUtils.getCellData(1, 11));
	}

	@Quando("^clico no botão registar$")
	
	public void clico_no_botão_registar() throws Throwable {
		pageRegister.clickCheckConditionsOfUse();
		pageRegister.clickButtonRegister();
	}

	@Então("^consigo criar o meu usuário$")
	public void eu_consigo_criar_o_meu_usuário() throws Throwable {
		homePage.waitHome();
		homePage.assertEqualsUser(ExcelUtils.getCellData(1, 1));
		Screenshot.getScreenShot(driver, "CadastroNovoUsuário_Sucesso ");

	}

	@Então("^não consigo criar meu usuario, pois já há um existente$")
	public void eu_não_consigo_criar_meu_usuario_pois_já_há_um_existente() throws Throwable {
		pageRegister.clickButtonRegisterFail();
		pageRegister.assertEqualsRegisterFail();
		Screenshot.getScreenShot(driver, "CadastroNovoUsuário_Falha ");
	}

}
