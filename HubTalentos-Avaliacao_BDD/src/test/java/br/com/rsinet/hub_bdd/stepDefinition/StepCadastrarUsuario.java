package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.RegisterPage;
import br.com.rsinet.hub_bdd.page.UserRegister;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class StepCadastrarUsuario {

	private WebDriver driver;
	private HomePage homePage;
	private RegisterPage registerPage;
	private UserRegister userRegister;

	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}

	@Dado("^que eu estou na home do site$")
	public void que_eu_estou_na_home_do_site() throws Throwable {
		driver = DriverElement.getChromeDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");
		userRegister = PageFactory.initElements(driver, UserRegister.class);
	}

	@Quando("^clico no icone de login e em nova conta$")
	public void clico_no_icone_de_login_e_em_nova_conta() throws Throwable {
		homePage.waitHome();
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();
	}

	@E("^preencho todos os dados$")
	public void preencho_todos_os_dados() throws Throwable {
		
		userRegister.setUserRegister(1);
	}

	@E("^clico no botão registar$")

	public void clico_no_botão_registar() throws Throwable {
		
		registerPage.clickButtonRegister();
	}

	@Então("^consigo criar o meu usuário$")
	public void eu_consigo_criar_o_meu_usuário() throws Throwable {
		homePage.waitHome();
		homePage.assertEqualsUser(ExcelUtils.getCellData(1, 1));
		Screenshot.getScreenShot(driver, "CadastroNovoUsuário_Sucesso ");
	}

	@Então("^não consigo criar meu usuario, pois já há um existente$")
	public void eu_não_consigo_criar_meu_usuario_pois_já_há_um_existente() throws Throwable {
		registerPage.clickButtonRegisterFail();
		registerPage.assertEqualsRegisterFail();
		Screenshot.getScreenShot(driver, "CadastroNovoUsuário_Falha ");
	}

}
