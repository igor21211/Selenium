package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AlertTest {

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
    public void testRozetka() throws IOException, InterruptedException {

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        searchInput.sendKeys("Mac");

        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(), 'Найти')]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Are you sure')");



        driver.switchTo().alert().accept();




    }


    @AfterMethod
    public void after(){

        driver.quit();
    }
}
