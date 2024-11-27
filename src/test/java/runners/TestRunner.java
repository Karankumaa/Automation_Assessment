package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features/SignIn.feature", // Adjusted to point to the features folder
    glue = "stepDefinitions" // Make sure this matches the package where your step definition classes are located
    //dryRun=true
)
public class TestRunner {

}
