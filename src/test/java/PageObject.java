import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageObject {
    private WebDriver driver;
    private WebDriverWait wait;

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
    public void testRozetka() throws InterruptedException{

        new MainPageLogic(driver,wait)
                .compAndLaptopCateforyClick()
                .laptopCategoryClick()
                .selectRozetkaSeller()
                .applyMaxPriceinFilter("10000")
                .firstPromoProductClick();


        Assert.assertTrue(new ProductPageLogic(driver,wait).chekPromo());


    }



    @AfterMethod
    public void after() {

        driver.quit();
    }
}
