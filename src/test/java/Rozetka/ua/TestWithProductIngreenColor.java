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

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestWithProductIngreenColor {

    private WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(0, 160, 70, 1)";

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testRozetka() throws IOException {

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        searchInput.sendKeys("Mac");

        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(), 'Найти')]"));
        searchBtn.click();

        WebElement firstProduct = (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='goods-tile__title']")));

        String fisrtElement = firstProduct.getText();

        assertEquals(fisrtElement,"Компьютер Apple Mac Studio M1 Max/24 ядра GPU/32GB/512GB","Erorr");


        WebElement haveProduct = driver.findElement(By.xpath("//div[@class='goods-tile__inner']/div[contains(@class,'available')]/.."));
        String colorProduct = driver.findElement(By.xpath("//div[@class='goods-tile__inner']/div[contains(@class,'available')]")).getCssValue("color");
        if(haveProduct.isDisplayed() && colorProduct.equals(EXPECTED_COLOR)){
            haveProduct.click();


        }

        String money = driver.findElement(By.xpath("//p[@class='product-prices__big']")).getAttribute("textContent");
        String findtitle = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();
        System.out.println(money);
        System.out.println(findtitle);

        FileWriter fileWriter = new FileWriter("text.txt");
        fileWriter.write(findtitle + " " + money);
        fileWriter.close();










    }

    @AfterMethod
    public void after(){

        driver.quit();
    }
}
