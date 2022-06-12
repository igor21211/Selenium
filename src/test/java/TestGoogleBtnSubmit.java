import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestGoogleBtnSubmit {
    WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(248, 65, 71, 1)";

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/");
    }



    @Test
    public void testsearchgoogle(){
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.sendKeys("Mac");

        WebElement btnSearch = driver.findElement(By.name("btnK"));

        if (btnSearch.getAttribute("value").equals("Поиск в Google")){
            btnSearch.submit();
        }else{
            fail();
        }
    }


    @AfterMethod
    public void after(){

        driver.quit();
    }
}
