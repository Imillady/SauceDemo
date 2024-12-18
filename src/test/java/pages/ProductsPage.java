package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By title = By.cssSelector("[data-test='title']");
    By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By removeBackpack = By.id("remove-sauce-labs-backpack");
    By backpack = By.cssSelector("[data-test='inventory-item-name']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getBackpack() {
        return driver.findElement(backpack).getText();
    }

    public void backpackAddCart() {
        driver.findElement(addBackpack).click();
    }

    public void backpackRemoveCart() {
        driver.findElement(removeBackpack).click();
    }
}
