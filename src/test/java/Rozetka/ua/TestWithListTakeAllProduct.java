package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWithListTakeAllProduct {

    WebDriver driver;


    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testRoazetkaAllProduct() {
        WebElement nooteComp = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        nooteComp.click();
        WebElement Noote = driver.findElement(By.xpath("//img[@class=' ng-star-inserted ng-lazyloaded']"));
        Noote.click();

        List<WebElement> titleOfProduct = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));

        Assert.assertEquals( titleOfProduct.size(),60,"Not all product!");

        for (WebElement element: titleOfProduct){
            String text = element.getText();
            System.out.println(text);
        }

    }

    @AfterMethod
    public void after() {

        driver.quit();
    }
}
