package sspackage;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andriig\\Desktop\\src\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();
    }

    @Test
    public void selectCategory() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.changeLanguagetoRu();
        PageInElectroTechnics pageInElectroTechnics = mainPage.selectCategory();
        SearchPage searchPage = pageInElectroTechnics.openSearchLink();
        searchPage.selectOptionForComboBox("Тип сделки", "Продают");
        searchPage.selectOptionForComboBox("Город", "Рига");
        searchPage.selectOptionForComboBox("Искать", "Среди всех объявлений");
        searchPage.typeSomethingInSearchField(" iPhone 8 Plus 64").clickSearchButton();
        SearchPageWithResults searchPageWithResults = searchPage.clickSearchButton();
        searchPageWithResults.clickSortPrice();
        searchPageWithResults.selectPageWithResult("Покупка");
        searchPage = searchPageWithResults.clickWideSearch();
        searchPage.inputRangeOfPrice(10, 1000);
        searchPage.clickSearchButton();
        searchPageWithResults.clickRandomCheckBoxes().addToFavorites();
        searchPageWithResults.openFavoritesLink();
        FavoritesPage favoritesPage = searchPageWithResults.openFavoritesLink();
        System.out.println("Is adverts on search are the same as on favorites?: " + searchPageWithResults.allAdsDescOnSearch().equals(favoritesPage.allAdsDescOnFavorites()));

    }


   @AfterClass
    public static void  tearDown(){
        driver.quit();
    }

}
