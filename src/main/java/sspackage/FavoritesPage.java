package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FavoritesPage extends Header {
    public FavoritesPage(WebDriver driver) {
        super(driver);
    }


    public List<String> allAdsDescOnFavorites() {
        List<WebElement> advertisementOnFavorites = driver.findElements(By.xpath("//div[@class='d1']/a"));
        List<String> descOnFavorites = new ArrayList<>();


        for (WebElement ads : advertisementOnFavorites) {
            String s = ads.getText();
            descOnFavorites.add(s);

        }
        //descOnFavorites.forEach(System.out::println);

        return descOnFavorites;
    }


}






