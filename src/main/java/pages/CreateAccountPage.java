package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    WebDriver driver;

    // Define WebElements (e.g., input fields, buttons)
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//button[@title='Create an Account']");
    private By confirmationMessage = By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    private By errorMessage = By.xpath("(//div[@class='mage-error'])[1]");
    private By passwordMismatchError = By.id("password-confirmation-error");
    private By invalidEmailError = By.id("email_address-error");

    // Constructor
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action Methods (e.g., typing text, clicking buttons)
    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameField);
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(lastNameField);
        element.sendKeys(lastName);
    }

    public void enterEmail(String email) {
    	
        WebElement element = driver.findElement(emailField);
        scroll(element);
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement element = driver.findElement(confirmPasswordField);
        element.sendKeys(confirmPassword);
    }
    public void scroll(WebElement ele) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();",ele);
    }

    public void clickCreateAccount() {
    	
        WebElement button = driver.findElement(createAccountButton);
        scroll(button);
        button.click();
    }

    // Getter for confirmation message
    public String getConfirmationMessage() {
        WebElement message = driver.findElement(confirmationMessage);
        scroll(message);
        return message.getText();
    }

    // Getting for error message (after form submission)
    public String getErrorMessage() {
        WebElement message = driver.findElement(errorMessage);
        return message.getText();
    }

    // Clear all input fields
    public void clearAllFields() {
        driver.findElement(firstNameField).clear();
        driver.findElement(lastNameField).clear();
        driver.findElement(emailField).clear();
        driver.findElement(passwordField).clear();
        driver.findElement(confirmPasswordField).clear();
    }

    // Validate password and confirm password mismatch
    public String getPasswordMismatchErrorMessage() {
        WebElement msg = driver.findElement(passwordMismatchError);
        scroll(msg);
        return msg.getText();
    }

    // Validate invalid email error message
    public String getInvalidEmailErrorMessage() {
        WebElement msg = driver.findElement(invalidEmailError);
        return msg.getText();
    }
}
