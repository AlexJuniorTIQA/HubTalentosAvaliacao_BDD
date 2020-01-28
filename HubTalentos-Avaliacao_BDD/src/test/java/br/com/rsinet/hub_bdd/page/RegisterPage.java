package br.com.rsinet.hub_bdd.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_bdd.files.ExcelUtils;

public class PageRegister {

	final WebDriver driver;
	private PageRegister pageRegister;
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
	public PageRegister(WebDriver driver) {

		this.driver = driver;
	}
	



	/**
	 * Methods Account Details
	 */

	public void setUserName(String username) {
		elementUserName.sendKeys(username);
	}

	public void setEmail(String email) {
		elementEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		elementPassword.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		elementConfirmPassword.sendKeys(password);
	}

	/**
	 * Methods Personal Details
	 */
	public void setFirstName(String fistName) {
		elementFirstName.sendKeys(fistName);
	}

	public void setLastName(String lastName) {
		elementLastName.sendKeys(lastName);
	}

	public void setPhoneNumber(String phoneNumber) {
		elementPhoneNumber.sendKeys(phoneNumber);
	}

	/**
	 * Methods Account Details
	 */
	public void selectCountry(String valor) {
		WebElement element = driver.findElement(By.name("countryListboxRegisterPage"));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void setCity(String city) {
		elementCity.sendKeys(city);
	}

	public void setAdress(String adress) {
		elementAdress.sendKeys(adress);
	}

	public void setState(String state) {
		elementState.sendKeys(state);
	}

	public void setPostalCode(String postalCode) {
		elementPostalCode.sendKeys(postalCode);
	}
	public void clickCheckConditionsOfUse() {
		elementCheckConditionsOfUse.click();
	}
	public void clickButtonRegister() {
		elementButtonRegister.click();
	}
	
		
	public void clickButtonRegisterFail() {
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
	}
	
	
	public void assertEqualsRegisterFail() {
		Assert.assertEquals("User name already exists",driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]")).getText());
	}
	

	
	
	
}
