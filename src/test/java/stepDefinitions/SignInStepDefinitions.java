package stepDefinitions;

// Import for assertion methods
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInPage;

public class SignInStepDefinitions {

    // Placeholder for form data
      static WebDriver driver;
      SignInPage signIn;

    @Given("I navigate to the Sign In page")
    public void iNavigateToTheSignInPage() {
        // Code to navigate to the Sign In page (using WebDriver or another tool)

        ChromeOptions options=new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
    	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
    	driver=new ChromeDriver(options);
    	driver.manage().window().maximize();
        System.out.println("Navigating to Signup page...");
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        signIn=new SignInPage(driver);
    }

    @When("I enter registered Email")
    public void iEnterEmail() {
    	signIn.enterEmail("Nikhil367@gmail.com");
    }

    @When("I enter Password for sign in")
    public void iEnterPassword() {
        signIn.enterPass("Pass@123");
    }


    @When("I click the Sign In button")
    public void iClickSignInButton() {
    signIn.clickOnSendButton();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
       String actual=signIn.getGreetMsg();
       assertEquals(actual,"Welcome, Bhushan Bhale!");
       driver.close();
    }
    @When("I leave both Email and Password fields empty")
    public void iLeaveBothEmailAndPasswordFieldsEmpty() {
    	signIn.enterEmail("");
    	signIn.enterPass("");
    }

    @Then("I should see an error message for both the fields")
    public void iShouldSeeAnErrorMessageForEmailAndPass() {
    	List<String> actual=signIn.getErrorMessage();
    	List<String> expected=new ArrayList<String>();
    	expected.add("This is a required field.");
    	expected.add("This is a required field.");
          assertEquals(actual,expected);
          driver.close();
    }

    @When("I enter invalid email for sign in")
    public void iEnterInvalidEmail() {
    	signIn.enterEmail("nsbshs");
    }

    @Then("I should see an error message for the Email field")
    public void iShouldSeeAnErrorMessageForInvalidEmailFormat() {
        // Simulating an invalid email format error message
        String expectedMessage = "Please enter a valid email address (Ex: johndoe@domain.com).";  // This would come from the actual web app after form submission
        String actual=signIn.getErrorMsg();
        assertEquals(expectedMessage, actual);
        driver.close();
    }
    
    @When("I enter invalid Password")
    public void enterInvalidPass() {
    	signIn.enterPass("Nikhil");
    }
    @Then("I should see an error message for invalid password")
    public void iShouldSeeAnErrorMessageForInvalidCredentials() {
        String actual=signIn.getInvalidPassMsg();
        String expected="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        assertEquals(expected, actual);
        driver.close();
    }


}
