import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void CheckPositiveSingUp() {
        SoftAssert softAssert = new SoftAssert();
        // Положительный тест
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        boolean elementOnPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        softAssert.assertTrue(elementOnPage);
        // Негативные тесты

        // Негативные тесты

        // Негативные тесты
    }

/*    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }*/

}
