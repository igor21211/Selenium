package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestIsSelected {

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

        WebElement loginBtnInHeader = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginBtnInHeader.click();

        WebElement rememberChekBoxInput = driver.findElement(By.id("remember_me"));
        Assert.assertTrue(rememberChekBoxInput.isSelected());

        WebElement rememberChekBox = driver.findElement(By.xpath("//label[@class='auth-modal__remember-checkbox']"));
        rememberChekBox.click();
        Assert.assertFalse(rememberChekBoxInput.isSelected());
    }



    @AfterMethod
    public void after(){

        driver.quit();
    }
}
