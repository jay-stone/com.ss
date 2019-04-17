package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    static WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    By changeLanguageLink = By.xpath("//span[@class='menu_lang']//a[1]");
    By headerSearchLink = By.xpath("//a[contains(@href, 'search') and @class='a_menu']");
    By headerFavoritesLink = By.xpath("//a[@href='/ru/favorites/']");

    public Header() {

    }


    public Header changeLanguage() {
        driver.findElement(changeLanguageLink).click();
        return this;
    }

    public Header changeLanguagetoRu() {
        WebElement curentLanguage = driver.findElement(changeLanguageLink);
        if (curentLanguage.getText().equalsIgnoreCase("RU")) {
            curentLanguage.click();
        } else {
            System.out.println("Language is already RU");
        }
        return this;
    }


    public SearchPage openSearchLink() {
        driver.findElement(headerSearchLink).click();
        return new SearchPage(driver);
    }

    public FavoritesPage openFavoritesLink() {
        driver.findElement(headerFavoritesLink).click();
        return new FavoritesPage(driver);
    }
}
