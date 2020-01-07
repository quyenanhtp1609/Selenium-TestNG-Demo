package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebSupporter;

public class HomePage {
	
	WebDriver driver;
	WebSupporter webSupporter;
	
	public HomePage(WebDriver driver, WebSupporter webSupporter) {
		super();
		this.driver = driver;
		this.webSupporter = webSupporter;
	}
	
	
	//Login pop-up
	String headerTitle_xpath = "//div[@class='Popup-Header']";
	String email_xpath = "//input[@id='email']";
	String password_xpath = "//input[@id='password']";
	String loginBtn_xpath = "//button[@class='btn Button-Submit']";
	
	
	public void clickOnLoginBtnNav() {
		webSupporter = new WebSupporter(driver);
		webSupporter.clickToElement("//*[@id=\"root\"]/div[1]/div[2]/div[4]/button");
	}
	
	
	public void verifyPopupIsOpenned(String title) {
		webSupporter.checkElementContent(headerTitle_xpath, title);
	}
	
	public void inputValueIntoEmail(String email) {
		webSupporter.sendKeyToElement(email_xpath, email);
	}
	
	public void inputValueIntoPassword(String password) {
		webSupporter.sendKeyToElement(password_xpath, password);
	}
	
	public void clickOnLoginBtn() {
		webSupporter.clickToElement(loginBtn_xpath);
	}
	
	public void checkErrorMessage(String errorMessage) {
		WebElement errorMessage_xpath = driver.findElement(By.xpath("//label[text()='Địa chỉ e-mail là bắt buộc']"));
		String content = errorMessage_xpath.getText();
		String content_2 = content.substring(6);
		System.out.println(content);
		System.out.println(content_2);
		Assert.assertEquals(content_2, errorMessage);
		
	}
}
