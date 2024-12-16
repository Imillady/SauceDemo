import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void CheckPositiveSingUp() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        boolean loginElementOnPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        Assert.assertTrue(loginElementOnPage);
    }

    @Test
    public void CheckNegativeSingUp1() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("login-button")).click();
        String errorMessageWrongPass = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessageWrongPass, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void CheckNegativeSingUp2() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("login-button")).click();
        String errorMessageWrongPass = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessageWrongPass, "Epic sadface: Username is required");
    }

    @Test
    public void CheckNegativeSingUp3() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("login-button")).click();
        String errorMessageWrongPass = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessageWrongPass, "Epic sadface: Password is required");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }

}
