package Rozetka.ua;
/*
Открыть https://rozetka.com.ua/
Сохранить цену товара
Перейти на продуктовую каждого товара и проверить, что цена совпадает с сохраненной на главной странице!
Вернуться на главную страницу (проверка, что открылась главная страница)
Проверить, что в блоке Акционные предложения отображается 6 товаров
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork_3 {
    private WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(0, 160, 70, 1)";
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
    public void testRozetka() throws InterruptedException {


        List<WebElement> priceMainPagePromotion = driver
                .findElements(By.xpath("//h2[contains(text(),' Акционные предложения ')]/..//span[@class='tile__price-value']"));

       // List <WebElement> priceFromBlockElement = driver.findElements(By.xpath("//h2[contains(text(), 'Акционные')]/..//*[@class='tile__price-value']"));

        int sizeOfPromotionBlock = priceMainPagePromotion.size();
        Assert.assertEquals(sizeOfPromotionBlock, 6);

        // A loop that iterates through the list of objects and checks the price of each object.
        for (int i = 1; i <= sizeOfPromotionBlock; i++) {
           // String priceFromBlock = priceFromBlockElement.get(i).getAttribute("textContent").trim().replace(" "," ");
            String priceFromBlock = driver.findElement(getPrice(i)).getAttribute("textContent").trim().replace(" "," ");
            driver.findElement(selectObject(i)).click();


            WebElement priceinProductPage = driver.findElement(By.xpath("//div[@class='product-prices__inner ng-star-inserted']/p[1]"));
            String priceFromProductPageText = priceinProductPage.getText().trim();
            priceFromProductPageText = priceFromProductPageText.substring(0, priceFromProductPageText.length() - 1);

            Assert.assertEquals(priceFromBlock,priceFromProductPageText);

            driver.navigate().back();
            driver.navigate().refresh();

            wait.until(ExpectedConditions.urlToBe("https://rozetka.com.ua/"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),' Акционные предложения ')]")));


        }

    }


    /**
     * It returns the locator of the object on the page.
     *
     * @param Object the number of the object in the list.
     * @return By.xpath(locator)
     */
    public By selectObject (int Object){
        String num  = String.valueOf(Object);
        String locator = String.format("//h2[contains(text(),' Акционные предложения ')]/../ul/li[%s]", num);
        return By.xpath(locator);
    }

    /**
     * It returns the price of the object.
     *
     * @param Object the number of the object in the list.
     * @return By.xpath(locator)
     */
    public By getPrice (int Object){
        String num  = String.valueOf(Object);
        String locator = String.format("//h2[contains(text(),' Акционные предложения ')]/../ul/li[%s]//span[@class='tile__price-value']", num);
        return By.xpath(locator);
    }


    @AfterMethod
    public void after() {

        driver.quit();
    }
}


