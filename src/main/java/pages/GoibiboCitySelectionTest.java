package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoibiboCitySelectionTest {

    public static void main(String[] args) throws InterruptedException {
        /*
         * 1. Go to https://www.goibibo.com/
         * 2. In From - type - Ben
         * 3. Select Bengaluru from the list.
         * 4. Verify that Bengaluru is indeed selected.
         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/");

        driver.findElement(By.xpath("//span[@class='sc-jlZhew inxprl']")).click();
        Thread.sleep(5000);

        WebElement el = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-16 wfIEw\"]//p[text()='Enter city or airport'])[1]"));
        el.click();
        Thread.sleep(3000);

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Ben");

        // Initialize Actions object for scrolling
        Actions actions = new Actions(driver);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll and search for the "Bengaluru International Airport" option
        for (int i = 0; i < 10; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(500); // Optional: Wait to see the scrolling effect

            // Wait for the option to appear and be clickable
            WebElement ben = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[text()='Bengaluru International Airport']")));
            if (ben.getText().equals("Bengaluru International Airport")) {
                ben.click();
                break;
            }
        }

        // Wait for the input field to update the value
        Thread.sleep(2000); // Wait for the input field value to update after selection

        // Fetch and print the value of the input field
        String txt =driver.findElement(By.xpath("//p[text()='Bengaluru']")).getText();
        System.out.println(txt);

        // Verify if the value contains "Bengaluru"
        if (txt.contains("Bengaluru")) {
            System.out.println("Test Passed: 'Bengaluru' is selected.");
        } else {
            System.out.println("Test Failed: 'Bengaluru' was not selected.");
        }

        driver.quit();
    }
}
