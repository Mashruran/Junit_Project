import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Practice {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @DisplayName("Submit Digital Unite webform and verify success")
    @Test
    public void clickButton() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        // Accept cookies
        WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptCookies);

        // Fill form
        List<WebElement> userForm = driver.findElements(By.className("form-control"));
        userForm.get(0).sendKeys("Taz"); userForm.get(0).sendKeys("Taz");
        userForm.get(1).sendKeys("01234567890"); userForm.get(0).sendKeys("Taz");
        userForm.get(2).sendKeys("10/09/2025"); userForm.get(0).sendKeys("Taz");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800)");
        Thread.sleep(500);

        userForm.get(3).sendKeys("taz@test.com"); userForm.get(0).sendKeys("Taz");
        userForm.get(4).sendKeys("I graduated this year and am focused on starting my career as an aspiring QA Engineer.");
        Thread.sleep(1000);

        // Upload a document
        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit-uploadocument-upload")));
        File file = new File("D:\\Java\\junit\\junit_b16\\img.jpg");
        uploadInput.sendKeys(file.getAbsolutePath());
        Thread.sleep(1000);

        // ✅ Check confirmation checkbox (actual checkbox input, not label)
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit-age")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        Thread.sleep(1000);

        // Submit Captcha
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(3000); // give time to manually check CAPTCHA
        driver.findElement(By.className("recaptcha-checkbox-border")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();

        // Submit Button
        driver.findElement(By.id("edit-submit")).click();
        Thread.sleep(1000);

        // ✅ Verify success (after CAPTCHA solved)
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String textActual = successMsg.getText();
        String textExpected = "Thank you for your submission!";
        Assertions.assertTrue(textActual.contains(textExpected), "Form submission failed!");
    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
