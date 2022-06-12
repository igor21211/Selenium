package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork_2 {

    /*Открыть https://rozetka.com.ua/
     Перейти в раздел «Компьютеры и ноутбуки»
     Перейти в раздел « Ноутбуки»
     Добавить первый товар в корзину
     Проверить что в корзину добавился один товар
     Перейти в корзину и проверить, что добавился правильный товар

     */

    private WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(0, 160, 70, 1)";
    private WebDriverWait wait;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testRozetka(){
        WebElement selectSectionOfPCandNootebook = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        selectSectionOfPCandNootebook.click();

        WebElement selectSectionOfNootebook = driver.findElement(By.xpath("//img[@class=' ng-star-inserted ng-lazyloaded']"));
        selectSectionOfNootebook.click();



        WebElement titleofProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='goods-tile__title']")));
        String titleProductBeforeAdd = titleofProduct.getAttribute("outerText");

        WebElement addProductInToTheBacket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")));
        addProductInToTheBacket.click();

        // This code is checking the number of products in the basket.
        WebElement basketIkon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'counter counter--green ng-star-inserted']")));
        chekContCart(basketIkon,1);

        WebElement basket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'header__button ng-star-inserted header__button--active']")));
        basket.click();

        // This code is getting the price of the product that was added to the basket.
        WebElement priceoftheProductWasBye = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class ='cart-product__price cart-product__price--red']")));
        String priceToAddProduct = priceoftheProductWasBye.getAttribute("innerText");
        String priceAddProduct = priceToAddProduct.substring(0,2)+(priceToAddProduct).substring(3);

        WebElement allorderOfTheBasket = driver.findElement(By.xpath("//div[@class = 'cart-receipt__sum-price']"));
        String orderOfTheBasket = allorderOfTheBasket.getAttribute("innerText");

       Assert.assertEquals(orderOfTheBasket,priceAddProduct,"In the basket not the one product!");

       WebElement titleProductInTheBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'cart-product__title']")));
       String titleBasket = titleProductInTheBasket.getAttribute("innerText");


       Assert.assertEquals(titleProductBeforeAdd,titleBasket,"title before add and titile in the basket its not");


    }

    /**
     * This function takes a WebElement and an integer as parameters and checks if the WebElement's text is equal to the
     * integer
     *
     * @param element the element that contains the counter
     * @param expectedCount the expected number of items in the cart
     */
    public void chekContCart(WebElement element , int expectedCount){
        String counterDigit = element.getText().trim();
        int actualDigit = Integer.parseInt(counterDigit);
        Assert.assertEquals(actualDigit,expectedCount);
    }




    @AfterMethod
    public void after(){

        driver.quit();
    }
}
