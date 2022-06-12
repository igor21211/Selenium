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

import static org.testng.Assert.fail;

public class TestChekElementThatisNoInDom {

    private WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void ChekElementThatisNoInDom(){
       // WebElement logoMain = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));


        List<WebElement> logoonMAin = driver.findElements(By.xpath("//img[@alt='Rozetka Logo']"));
        System.out.println(logoonMAin.size());

        if(logoonMAin.size()>0){
            System.out.println("Logo appeared");
        }else{
            fail("Logo doesn't apperared");
        }

    }


    @AfterMethod
    public void after(){

        driver.quit();
    }

}
