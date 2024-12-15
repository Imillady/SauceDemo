import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void CheckSingUp() {
        // Негативный тест. Верный пароль и неверный логин
        WebElement login = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBut = driver.findElement(By.id("login-button"));
        login.sendKeys("123");
        password.sendKeys("123");
        loginBut.click();
        String errorMessageWrongPass = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessageWrongPass, "Epic sadface: Username and password do not match any user in this service");
        login.clear();
        password.clear();
        password.sendKeys("secret_sauce");
        login.sendKeys("standard_user");
    }
}
