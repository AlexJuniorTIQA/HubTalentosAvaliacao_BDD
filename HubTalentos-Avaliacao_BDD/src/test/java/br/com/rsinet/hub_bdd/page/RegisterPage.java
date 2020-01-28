package br.com.rsinet.hub_bdd.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_bdd.files.ExcelUtils;
/**Classe de mapeamento de elementos: Da páginde de registro do site AdvantageOnlineShopping**/
public class RegisterPage {

	final WebDriver driver;
	private RegisterPage pageRegister;
	///////////// Elements: Account Details////////////////
	@FindBy(how = How.NAME, using = "usernameRegisterPage")

	private WebElement elementUserName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")

	private WebElement elementEmail;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")

	private WebElement elementPassword;
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")

	private WebElement elementConfirmPassword;

	///////////// Elements: Personal Details////////////////
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")

	private WebElement elementFirstName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")

	private WebElement elementLastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")

	private WebElement elementPhoneNumber;
/////////////Elements: Adress////////////////
	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")

	private WebElement elementCountry;

	@FindBy(how = How.NAME, using = "cityRegisterPage")

	private WebElement elementCity;

	@FindBy(how = How.NAME, using = "addressRegisterPage")

	private WebElement elementAdress;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")

	private WebElement elementState;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")

	private WebElement elementPostalCode;

/////////////Elements: Check Box////////////////

	@FindBy(how = How.NAME, using = "allowOffersPromotion")

	private WebElement elementCheckReceiveOffersByEmail;

	@FindBy(how = How.NAME, using = "i_agree")

	private WebElement elementCheckConditionsOfUse;

	@FindBy(how = How.XPATH, using = "//*[@id=\"register_btnundefined\"]")

	private WebElement elementButtonRegister;

	////////////////////////////////////////////////////////
	public RegisterPage(WebDriver driver) {

		this.driver = driver;
	}
	

	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "User Name"**/
	public void setUserName(String username) {
		elementUserName.sendKeys(username);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "E-Mail"**/
	public void setEmail(String email) {
		elementEmail.sendKeys(email);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "Password"**/
	public void setPassword(String password) {
		elementPassword.sendKeys(password);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de " Confirm Password"**/
	public void setConfirmPassword(String password) {
		elementConfirmPassword.sendKeys(password);
	}

	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "First Name"**/
	public void setFirstName(String fistName) {
		elementFirstName.sendKeys(fistName);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "Last Name"**/
	public void setLastName(String lastName) {
		elementLastName.sendKeys(lastName);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "Phone Number"**/
	public void setPhoneNumber(String phoneNumber) {
		elementPhoneNumber.sendKeys(phoneNumber);
	}

	/**Recebe um objeto do tipo String e o retorna via SelectByVisibleText ao  campo de "Contry"**/
	public void selectCountry(String valor) {
		WebElement element = driver.findElement(By.name("countryListboxRegisterPage"));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "City"**/
	public void setCity(String city) {
		elementCity.sendKeys(city);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "Adress"**/
	public void setAdress(String adress) {
		elementAdress.sendKeys(adress);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "State"**/
	public void setState(String state) {
		elementState.sendKeys(state);
	}
	/**Recebe um objeto do tipo String e o retorna via sendkeys ao  campo de "Postal Code"**/
	public void setPostalCode(String postalCode) {
		elementPostalCode.sendKeys(postalCode);
	}
	/**Retorna um click ao "Check Conditions Of Use"**/
	public void clickCheckConditionsOfUse() {
		elementCheckConditionsOfUse.click();
	}
	/**Retorna um click ao botão "Register"**/
	public void clickButtonRegister() {
		elementButtonRegister.click();
	}
	/**Retorna cinco clicks ao botão "Register" para ser possivel o AssertEquals **/	
	public void clickButtonRegisterFail() {
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
	}
	
	/**Não recebe nenhum parâmetro, efetuada á comparação da mensagem de "User name already exists" com o  "warning" do botão register via getText**/
	public void assertEqualsRegisterFail() {
		Assert.assertEquals("User name already exists",driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]")).getText());
	}
	

	
	
	
}
