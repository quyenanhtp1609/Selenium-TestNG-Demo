package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebSupporter {

	public WebSupporter(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void goToUrl(String url) {
		driver.get(url);
		System.out.println("Get url: " + url);

	}

	public void sendKeyToElement(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(value);
		System.out.println("Send key to element: " + xpath);
	}

	public void clearValueIntoElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
	}

	public void clickToElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
		System.out.println("Click to element: " + xpath);
	}

	public void mouseHoverElement(String xpath) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpath));
		Action mouseOverPosts = actions.moveToElement(element).build();
		mouseOverPosts.perform();
	}

	public void selectItemDropdown(String xpath, String itemName) {
		Select dropdownElement = new Select(driver.findElement(By.xpath(xpath)));
		dropdownElement.selectByVisibleText(itemName);
	}

	public void checkElementContent(String xpath, String expectedResult) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String actualResult = element.getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

	public void checkUrl(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	public String getElementAttribute(String xpath, String attribute) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}
}
