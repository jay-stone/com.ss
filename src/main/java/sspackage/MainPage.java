package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Header {


    private By category_electro_technics = By.xpath("//a[contains(@href, 'electro') and @class='a1']");

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public PageInElectroTechnics selectCategory(){
        driver.findElement(category_electro_technics).click();

        return new PageInElectroTechnics(driver);
    }
}
