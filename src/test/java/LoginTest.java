import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        WebElement login = driver.findElement(By.name("user-name"));
        //WebElement loginEmpty =  driver.findElement(By.cssSelector("[value='']"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement buttonLogin = driver.findElement(By.name("login-button"));

        // Негативный тест. Верный пароль и неверный логин
        password.sendKeys("secret_sauce");
        login.sendKeys("1234");

        buttonLogin.click();
        String errorMessageWrongPass = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        softAssert.assertEquals(errorMessageWrongPass, "Epic sadface: Username and password do not match any user in this service");
        password.clear();
        login.clear();
//        try {
//            Thread.sleep(2000);  // Задержка на 2000 миллисекунд (2 секунды)
//        } catch (InterruptedException e) {
//        }
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //softAssert.assertEquals(loginEmpty, "");

//        // Негативный тест. Поля логина и пароля пустые
//        buttonLogin.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String errorMessageEmpty = driver.findElement(By.cssSelector("[data-test='error']")).getText();
//        softAssert.assertEquals(errorMessageEmpty, "Epic sadface: Username is required");

//        // Негативный тест. Неверный логин и верный пароль
//
          //Положительный тест
        login.sendKeys("");
        login.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        //buttonLogin.click();
        //boolean LoginElementOnPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        //softAssert.assertTrue(LoginElementOnPage);
        //!!!!!!!!!!!!!!softAssert.assertAll(); !!!!!!!!!
    }

/*    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }*/

}
