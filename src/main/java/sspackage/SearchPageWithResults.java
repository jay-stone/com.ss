package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SearchPageWithResults extends Header {

    public SearchPageWithResults(WebDriver driver) {
        super(driver);
    }

    Map<WebElement, WebElement> mapOfRandom = new LinkedHashMap<>();
    By sortPrice = By.xpath("//a[@href='/ru/electronics/search-result/fDgSeF4belM=.html']");
    By sortPrice2 = By.xpath("//a[@href='/ru/electronics/search-result/fDgSeF4belI=.html']");
    By advertisementPath = By.xpath("//td[@class='msga2 pp0']//input[@type='checkbox']//parent::td//following::td[2]");

    public SearchPageWithResults() {
        super();
    }

    public SearchPageWithResults clickSortPrice() {
        driver.findElement(sortPrice).click();
        driver.findElement(sortPrice2).click();
        return new SearchPageWithResults(driver);
    }

    public SearchPageWithResults selectPageWithResult(String option3) {
        String listXpath3 = String.format("//div[@class='filter_second_line_dv']//span[3]");
        String optionXpath3 = String.format("//option[contains(text(),'%s')]", option3);

        driver.findElement(By.xpath(listXpath3)).click();
        driver.findElement(By.xpath(optionXpath3)).click();
        return new SearchPageWithResults(driver);
    }

    public SearchPage clickWideSearch() {
        driver.findElement(By.cssSelector("#page_main > tbody > tr > td > table:nth-child(2) > tbody > tr > td.td7 > a")).click();
        return new SearchPage(driver);
    }


    public SearchPageWithResults clickRandomCheckBoxes() {
        int[] a = new int[3];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = 2 + r.nextInt(29);
            WebElement checkbox = driver.findElement(By.xpath("//table[2]//tr[" + a[i] + "]//input")); ////td[@class='msga2 pp0']//input[@type='checkbox']
            WebElement description = driver.findElement(By.xpath("//table[2]//tr[" + a[i] + "]//a[@class='am']")); ////td[@class='msga2 pp0']//input[@type='checkbox']
            mapOfRandom.put(checkbox, description);
        }

        for (WebElement c : mapOfRandom.keySet()) {
            c.click();
        }

        return new SearchPageWithResults(driver);
    }


    public List<String> allAdsDescOnSearch() {
        List<WebElement> advertisementOnSearch = driver.findElements(By.xpath("//div[@class='d1']/a"));
        List<String> descOnSearch = new ArrayList<>();

           for (WebElement add : advertisementOnSearch) {
            String s = add.getText();
            descOnSearch.add(s);

        }

        return descOnSearch;
    }






    public void addToFavorites() {
        driver.findElement(By.xpath("//a[contains(text(),'Добавить выбранные в закладки')]")).click();
        driver.findElement(By.xpath("//a[@id='alert_ok']")).click();
    }
}












