package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestRozetkaWithUseMap {


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
    public void testRozetka() throws IOException {

        WebElement selectSectionOfPCandNootebook = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        selectSectionOfPCandNootebook.click();

        WebElement selectSectionOfNootebook = driver.findElement(By.xpath("//img[@class=' ng-star-inserted ng-lazyloaded']"));
        selectSectionOfNootebook.click();

        List<WebElement> tittlesOfProduct = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        List<WebElement> priceOfProduct = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        LinkedHashMap<String , String> mapOfTitlesAndPrice = new LinkedHashMap();

        for (int i = 0; i < tittlesOfProduct.size(); i++) {
            String titles = tittlesOfProduct.get(i).getText();
            String price = priceOfProduct.get(i).getText();
            mapOfTitlesAndPrice.put(titles,price);
        }

        FileWriter fileWriter = new FileWriter("rozetkaTest.txt");
        for (Map.Entry<String,String> entry : mapOfTitlesAndPrice.entrySet()){
            fileWriter.write(entry.getKey() + "  "+   entry.getValue()+"$" + "\n");
        }
        fileWriter.close();
    }



    @AfterMethod
    public void after(){

        driver.quit();
    }
}
