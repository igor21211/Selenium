import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testRozetka {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }
    @Test
    public void testRozetka(){
        new MainPageLogic(driver,wait)
                .typeTextInSearchInput("Mac")
                .searchBtnClick();
        SearchPageLogic searchPageLogic = new SearchPageLogic(driver,wait);

        String textFromSearchPage = searchPageLogic.firstProductText();
        searchPageLogic.firstProductClick();

        String textFromProductPage = new ProductPageLogic(driver,wait).productTittleText();

        Assert.assertEquals(textFromSearchPage,textFromProductPage,"Dont work");

    }

    @AfterMethod
    public void after() {

        driver.quit();
    }

}
