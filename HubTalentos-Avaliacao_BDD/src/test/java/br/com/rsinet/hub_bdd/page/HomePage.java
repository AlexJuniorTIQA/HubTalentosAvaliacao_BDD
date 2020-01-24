package br.com.rsinet.hub_bdd.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	final WebDriver driver;
	///////////// Elements: Account Details////////////////
	@FindBy(how = How.ID, using = "menuUser")

	public WebElement elementIconUser;

	@FindBy(how = How.ID, using = "menuSearch")

	private WebElement elementIconSearch;

	@FindBy(how = How.ID, using = "autoComplete")

	private WebElement elementSearch;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")

	private WebElement elementCreatNewAccount;

	@FindBy(how = How.ID, using = "tabletsTxt")

	private WebElement elementTablets;

	@FindBy(how = How.ID, using = "headphonesTxt")

	private WebElement elementHeadPhones;

	@FindBy(how = How.ID, using = "speakersTxt")

	private WebElement elementSpeakers;

	@FindBy(how = How.ID, using = "laptopsTxt")

	private WebElement elementLaptops;

	@FindBy(how = How.ID, using = "miceTxt")

	private WebElement elementMice;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[3]/a/span")
	private WebElement elementUserLink;
	
	@FindBy(how = How.ID, using = "details_10")

	private WebElement elementHPEliteBookFolioDetails;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}
	
	public void clickIconuser() {
		elementIconUser.click();
	}
	public void clickCreatNewAccount() {
		elementCreatNewAccount.sendKeys(Keys.ENTER);
	}

	public void javaScriptClick(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(by));
	}

	public void findElementLinkText(String linkText) {
		javaScriptClick(By.linkText(linkText));
	}

	public void setSearch(String search) {
		elementSearch.sendKeys(search + Keys.ENTER);
	}
	
	public void waitHome() throws InterruptedException {
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
	}

	public void assertEqualsUser(String expected) {
		Assert.assertEquals(expected, elementUserLink.getText());
	}
	
	public WebElement getIconSearch() {
		return elementIconSearch;
	}
	public void clickIconSearch() {
		elementIconSearch.click();
	}
	
	public void ClickEelementHPEliteBookFolioDetails() {
		elementHPEliteBookFolioDetails.click(); 
	}

}