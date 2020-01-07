package demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.WebSupporter;
import pageObjects.HomePage;

public class DemoTest {
	
	WebDriver driver;
	WebSupporter webSupporter;
	
	HomePage homepage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qa.customer.cargopedia.success-ss.com.vn:8007/");
	}
	
	@Test(priority = 1, description = "Verify user can open Login popup")
	public void CR_12_1() {
		homepage = new HomePage(driver,webSupporter);
		System.out.println("Step 1.1: Click on Login button on navigation");
		homepage.clickOnLoginBtnNav();
		
		System.out.println("Step 1.2: Pop-up is openned");
		homepage.verifyPopupIsOpenned("Đăng nhập vào tài khoản của bạn");
	}
	
	
	@Test(priority = 2, description = "Validate the \"Email\" field in case having empty value")
	public void CR_28_1(){
		System.out.println("Pre-condition: Input valid value into password");
		homepage.inputValueIntoPassword("123456");
		
		System.out.println("Do not input value into Email");
		homepage.inputValueIntoEmail("");
		
		System.out.println("Click on Login button");
		homepage.clickOnLoginBtn();
		
		System.out.println("Check error message correctly");
		homepage.checkErrorMessage("Địa chỉ e-mail là bắt buộc");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
