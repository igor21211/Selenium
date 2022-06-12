package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork13 {

    WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(248, 65, 71, 1)";

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testrozetka() throws InterruptedException {
        WebElement nooteComp = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        nooteComp.click();
        WebElement Noote = driver.findElement(By.xpath("//img[@class=' ng-star-inserted ng-lazyloaded']"));
        Noote.click();
        WebElement FilterPrice = driver.findElement(By.xpath("//input[2][@class='slider-filter__input ng-untouched ng-pristine ng-valid']"));
        FilterPrice.clear();
        FilterPrice.sendKeys("10000");
       WebElement pressokButton = driver.findElement(By.xpath("//button[@type='submit']"));
        pressokButton.click();
        Thread.sleep(5000);
//        WebElement chekFilter = driver.findElement(By.xpath("//a[@class='catalog-selection__link']"));
//        Assert.assertTrue(chekFilter.isDisplayed(),"Dont have filter");
        WebElement firstProduct = (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'label_type_action')]/..")));
        firstProduct.click();
        WebElement promocijaProduct = driver.findElement(By.xpath("//span[contains(@class,'label_type_action')]"));
        Assert.assertTrue(promocijaProduct.isDisplayed(),"Dont have promocija");




    }

   @AfterMethod
    public void after(){

       driver.quit();
    }
}
