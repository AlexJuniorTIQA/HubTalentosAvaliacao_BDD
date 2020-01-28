package br.com.rsinet.hub_bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.files.Constant;
import br.com.rsinet.hub_bdd.files.ExcelUtils;

public class UserRegister {

	
	final WebDriver driver;
	public UserRegister(WebDriver driver) {

		this.driver = driver;
	}
	public void setUserRegister(int numberUser) throws Exception {

		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

		registerPage.setUserName(ExcelUtils.getCellData(numberUser, 1));
		registerPage.setEmail(ExcelUtils.getCellData(numberUser, 2));
		registerPage.setPassword(ExcelUtils.getCellData(numberUser, 3));
		registerPage.setConfirmPassword(ExcelUtils.getCellData(numberUser, 3));

		registerPage.setFirstName(ExcelUtils.getCellData(numberUser, 4));
		registerPage.setLastName(ExcelUtils.getCellData(numberUser, 5));
		registerPage.setPhoneNumber(ExcelUtils.getCellData(numberUser, 6));

		registerPage.selectCountry(ExcelUtils.getCellData(numberUser, 7));
		registerPage.setCity(ExcelUtils.getCellData(numberUser, 8));
		registerPage.setAdress(ExcelUtils.getCellData(numberUser, 9));
		registerPage.setState(ExcelUtils.getCellData(numberUser, 10));
		registerPage.setPostalCode(ExcelUtils.getCellData(numberUser, 11));
		registerPage.clickCheckConditionsOfUse();
	}
}
