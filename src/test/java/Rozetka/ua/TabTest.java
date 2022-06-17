package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TabTest {
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
        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginBtn.click();

        WebElement regBtn = driver.findElement(By.xpath("//button[contains(@class,'auth-modal__register-link butto')]"));
        regBtn.click();

        String mainTab = driver.getWindowHandle();

        WebElement privacyBtn = driver.findElement(By.xpath("//a[contains(@class,'button_type_link')]"));
        privacyBtn.click();

        for (String tab : driver.getWindowHandles()){
            loginBtn.isDisplayed();
            driver.switchTo().window(tab);

        }

        driver.switchTo().window(mainTab);

    }


    @AfterMethod
    public void after(){

        driver.quit();
    }
}
