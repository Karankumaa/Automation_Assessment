package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	private By email=By.id("email");
	private By pass=By.id("pass");
	private By send=By.id("send2");
	private By greetOnHomepage=By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Bhushan Bhale!']");
	private By error=By.cssSelector("div.mage-error");
	private By invalidpass=By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	public void enterPass(String password) {
		driver.findElement(pass).sendKeys(password);
	}
	 public void scroll(WebElement ele) {
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].scrollIntoView();",ele);
	    }
	public void clickOnSendButton() {
		WebElement ele=driver.findElement(send);
		scroll(ele);
		ele.click();
	}
	public String getGreetMsg() {
		String txt=driver.findElement(greetOnHomepage).getText();
		return txt;
	}
	public List<String> getErrorMessage() {
	List<WebElement> errors=driver.findElements(error);
	List<String>list = new ArrayList<String>();
	for(WebElement err:errors) {
		list.add(err.getText());
	}
	return list;
	}

	public String getErrorMsg() {
		String txt=driver.findElement(error).getText();
		return txt;
	}
	public String getInvalidPassMsg() {
	String pass=driver.findElement(invalidpass).getText();
	return pass;
	}
}
