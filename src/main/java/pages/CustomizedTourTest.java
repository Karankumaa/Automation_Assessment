package pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class CustomizedTourTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        /* 
         * 1. https://nichethyself.com/tourism/home.html
         * 2. Go to "Customized tours"
         * 3. Select "Home Stay" in preferred stay dropwdown/combo.
         * 4. Click on England checkbox
         * 5. From above now click on "Contact Us" menu on top right corner
         * 6. On "Contact Us" window, click on Search icon.
         * 7. Enter "London" on the pop window and click on OK.
         * 8. Close "Contact Us" window and click on "Submit" button on customized tour
         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://nichethyself.com/tourism/home.html");

        String parentwindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Customized tours']")).click();
        
        Set<String> set = driver.getWindowHandles();

        // Loop through each window
        for (String s : set) {
            if (!parentwindow.equals(s)) {
                driver.switchTo().window(s);
                WebElement dropdown = driver.findElement(By.id("days"));
                Select sel = new Select(dropdown);
                sel.selectByVisibleText("Home Stay");

                // Click on England checkbox
                driver.findElement(By.xpath("(//div[@class='checkbox-inline']//input)[2]")).click();

                // Click on "Contact us!" button
                driver.findElement(By.xpath("//button[text()='Contact us!']")).click();

                Set<String> subwindowhandles = driver.getWindowHandles();

                // Loop through the subwindow handles (Contact Us window)
                for (String str : subwindowhandles) {
                    if (!str.equals(s) && !str.equals(parentwindow)) {
                        driver.switchTo().window(str);

                        // Wait for the Search icon to be visible and clickable
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("(//div[@class='card bg-info']/div/a/span)[1]")));

                        search.click();
                        Thread.sleep(4000);

                        // Handle the alert
                        Alert alert = driver.switchTo().alert();
                        alert.sendKeys("London");
                        Thread.sleep(4000);
                        alert.accept();

                        // Close the "Contact Us" window after handling the alert
                        driver.close();
                        break; // Exit loop after closing the subwindow
                    }
                }

                // Switch back to the parent window before submitting the form
                driver.switchTo().window(s);

                // Submit the form on the Customized tours page
                driver.findElement(By.xpath("//form[@name='internationalf']//button[@type='submit'][normalize-space()='Submit']")).click();
                break; // Exit loop after completing the actions in the child window
            }
        }
    }
}
