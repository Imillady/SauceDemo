package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By title = By.cssSelector("[data-test='title']");
    By prodBackpackClick = By.id("add-to-cart-sauce-labs-backpack");
    By Backpack = By.cssSelector("[data-test='inventory-item-name']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getBackpack() {
        return driver.findElement(Backpack).getText();
    }

    public void backpackAddCart() {
        driver.findElement(prodBackpackClick).click();
    }
}
