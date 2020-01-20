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
import br.com.rsinet.hub_bdd.page.PageRegister;

public class CadastroCliente {

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
		PageRegister pageRegister = PageFactory.initElements(driver, PageRegister.class);
        ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Users");
		
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();
		
		pageRegister.setUserName(ExcelUtils.getCellData(1,1));
		pageRegister.setEmail(ExcelUtils.getCellData(1,2));
		pageRegister.setPassword(ExcelUtils.getCellData(1,3));
		pageRegister.setConfirmPassword(ExcelUtils.getCellData(1,3));

		pageRegister.setFirstName(ExcelUtils.getCellData(1,4));
		pageRegister.setLastName(ExcelUtils.getCellData(1,5));
		pageRegister.setPhoneNumber(ExcelUtils.getCellData(1,6));

		pageRegister.selectCountry(ExcelUtils.getCellData(1,7));
		pageRegister.setCity(ExcelUtils.getCellData(1,8));
		pageRegister.setAdress(ExcelUtils.getCellData(1,9));
		pageRegister.setState(ExcelUtils.getCellData(1,10));
		pageRegister.setPostalCode(ExcelUtils.getCellData(1,11));
		
		pageRegister.clickCheckConditionsOfUse();
		pageRegister.clickButtonRegister();

		homePage.waitHome();

		homePage.assertEqualsUser(ExcelUtils.getCellData(1,1));
		Screenshot.getScreenShot(driver, "TesteNovoUsuárioComSucesso ");
	}
	
	
	
	@Test
	public void NovoUsuarioComFalhaB() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PageRegister pageRegister = PageFactory.initElements(driver, PageRegister.class);
        ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Users");
		
		homePage.clickIconuser();
		homePage.clickCreatNewAccount();
		
		pageRegister.setUserName(ExcelUtils.getCellData(1,1));
		pageRegister.setEmail(ExcelUtils.getCellData(1,2));
		pageRegister.setPassword(ExcelUtils.getCellData(1,3));
		pageRegister.setConfirmPassword(ExcelUtils.getCellData(1,3));

		pageRegister.setFirstName(ExcelUtils.getCellData(1,4));
		pageRegister.setLastName(ExcelUtils.getCellData(1,5));
		pageRegister.setPhoneNumber(ExcelUtils.getCellData(1,6));

		pageRegister.selectCountry(ExcelUtils.getCellData(1,7));
		pageRegister.setCity(ExcelUtils.getCellData(1,8));
		pageRegister.setAdress(ExcelUtils.getCellData(1,9));
		pageRegister.setState(ExcelUtils.getCellData(1,10));
		pageRegister.setPostalCode(ExcelUtils.getCellData(1,11));

		pageRegister.clickCheckConditionsOfUse();
		pageRegister.clickButtonRegisterFail();
		
		
		pageRegister.assertEqualsRegisterFail();
		Screenshot.getScreenShot(driver, "TesteNovoUsuárioComFalha ");
	}
}
