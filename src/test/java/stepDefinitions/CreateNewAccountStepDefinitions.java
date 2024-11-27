package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;



public class CreateNewAccountStepDefinitions {

 
    
    static WebDriver driver;
   public CreateAccountPage createAccount;
    // Placeholder for error messages
    private String errorMessage;

    @Given("I navigate to the Signup page")
    public void iNavigateToTheSignupPage() {
        // Add the code to navigate to the Signup page in your application.
    	ChromeOptions options=new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
    	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
    	driver=new ChromeDriver(options);
    	driver.manage().window().maximize();
        System.out.println("Navigating to Signup page...");
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        createAccount=new CreateAccountPage(driver);
    }

    @When("I enter First Name for account creation")
    public void iEnterFirstName() {
    	createAccount.enterFirstName("Bhushan");
    }

    @When("I enter Last Name for account creation")
    public void iEnterLastName() {
    	createAccount.enterLastName("Bhale");
    }

    @When("I enter Email for account creation")
    public void iEnterEmail() {
    	createAccount.enterEmail("Nikhil367@gmail.com");
    }

    @When("I enter Password for account creation")
    public void iEnterPassword() {
    	createAccount.enterPassword("Pass@123");
    }

    @When("I enter Confirm Password for account creation")
    public void iEnterConfirmPassword() {
    	createAccount.enterConfirmPassword("Pass@123");
    }

    @When("I click Create Account button")
    public void iClickCreateAccount() {
        // Code to click the "Create Account" button
    	createAccount.clickCreateAccount();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
        // Simulate a successful registration check
        String actualMessage = createAccount.getConfirmationMessage();
        
        // Use assertEquals from JUnit Assert class
        assertEquals(expectedMessage, actualMessage); // Correct the order: expected, actual
        driver.close();
    }
    
    @When("I enter Password")
    public void iEnterPasswordforCheckingMismatch() {
    	createAccount.enterPassword("Pass@123");
    }

    @When("I enter Confirm Password")
    public void iEnterConfirmPasswordforCheckingMismatch() {
    	createAccount.enterConfirmPassword("Pass@1234");
    }



    @Then("I should see an error message for password mismatch in the account creation")
    public void iShouldSeeAnErrorMessageForPasswordMismatch() {
    	String expectedError="Please enter the same value again.";
    	   String actual= createAccount.getPasswordMismatchErrorMessage();
           assertEquals(actual, expectedError);
           driver.close();

    }
    
    @When("I enter invalid email")
    public void iEnterInvalidEmail() {
    	createAccount.enterEmail("Bhushan123@");
    }

    @Then("I should see an error message for invalid email format in the account creation")
    public void iShouldSeeAnErrorMessageForInvalidEmail() {
    	String expectedError="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actual= createAccount.getInvalidEmailErrorMessage();
        assertEquals(actual, expectedError);
        driver.close();

    }

    @When("I enter already registred Email")
    public void iEnterRegisteredEmail() {
    	createAccount.enterFirstName("Bhushan");
    	createAccount.enterLastName("Bhale");
    	createAccount.enterEmail("Nikhil367@gmail.com");
    	createAccount.enterPassword("Pass@1234");
    	createAccount.enterConfirmPassword("Pass@1234");
    	
    }

    @Then("I should see an error message for already registered email in the account creation")
    public void iShouldSeeAnErrorMessageForAlreadyRegisteredEmail() {  
    	String expectedError="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actual= createAccount.getConfirmationMessage();
        assertEquals(actual, expectedError);
        driver.close();
    }
}
