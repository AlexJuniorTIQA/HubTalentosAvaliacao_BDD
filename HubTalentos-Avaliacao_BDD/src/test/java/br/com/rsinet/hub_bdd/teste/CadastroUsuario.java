package br.com.rsinet.hub_bdd.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;
import br.com.rsinet.hub_bdd.files.Screenshot;
import br.com.rsinet.hub_bdd.page.DriverElement;
import br.com.rsinet.hub_bdd.page.HomePage;
import br.com.rsinet.hub_bdd.page.RegisterPage;
import br.com.rsinet.hub_bdd.page.UserRegister;

public class CadastroUsuario {

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
	public void NovoUsuarioComSucesso() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Users");
        UserRegister userRegister = PageFactory.initElements(driver, UserRegister.class);
        
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();

		userRegister.setUserRegister(1);
		
		registerPage.clickButtonRegister();

		homePage.waitHome();

		homePage.assertEqualsUser(ExcelUtils.getCellData(1,1));
		Screenshot.getScreenShot(driver, "Cadastro Novo Usuario Com Sucesso", "TesteNovoUsuarioComSucesso");
	}
	
	
	
	@Test
	public void NovoUsuarioComFalhaB() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Users");
        UserRegister userRegister = PageFactory.initElements(driver, UserRegister.class);
        
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();
		
		userRegister.setUserRegister(1);
		
		registerPage.clickButtonRegisterFail();
		
		
		registerPage.assertEqualsRegisterFail();
		Screenshot.getScreenShot(driver, "Cadastro Usuario Com Falha", "TesteNovoUsuarioComFalha");
	}
}
