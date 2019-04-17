package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Header {


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By searchInputField = By.cssSelector("#ptxt");
    By searchButtonOnSearchPage = By.xpath("//input[@type='submit']");
    By minPrice = By.xpath("//input[@name='topt[8][min]']");
    By maxPrice = By.xpath("//input[@name='topt[8][max]']");


    public SearchPageWithResults clickSearchButton() {
        driver.findElement(searchButtonOnSearchPage).click();
        return new SearchPageWithResults(driver);
    }

    public SearchPage typeSomethingInSearchField(String search) {
        driver.findElement(searchInputField).sendKeys(search);
        return this;
    }

    public void selectOptionForComboBox(String listName, String option) {
        String listXpath = String.format("//td[contains(text(),'%s')]/following-sibling::td//select[1]", listName);
        String optionXpath = String.format("//option[contains(text(),'%s')]", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();

    }

    public void inputRangeOfPrice(int minPrice, int maxPrice) {
        String minPriceXpath = String.format("//input[@name='topt[8][min]']", minPrice);
        String maxPriceXpath = String.format("//input[@name='topt[8][max]']", maxPrice);
        driver.findElement(By.xpath(minPriceXpath)).click();
        driver.findElement(By.xpath(minPriceXpath)).sendKeys();

        driver.findElement(By.xpath(maxPriceXpath)).click();


    }
}
