import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotWorkLogTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void CheckSingUp() {
        // Негативный тест. Верный пароль и неверный логин
        driver.findElement(By.id("user-name")).sendKeys("123");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }
}
