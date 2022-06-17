package Rozetka.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class OptoinTest {

    private WebDriver driver;
    private final String EXPECTED_COLOR = "rgba(0, 160, 70, 1)";
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.autodoc.de/");
    }

    @Test
    public void testOption() throws InterruptedException {

    selectOption(driver,"5");

    sleep(5000);


    }

    public void selectOption(WebDriver driver, String option){
        WebElement clickCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='1']")));
        clickCookie.click();
        WebElement makerListDropDowm = driver.findElement(By.id("form_maker_id"));
        String makeListOption = String.format("//select[@id='form_maker_id']/optgroup[2]/option[@value=%s]", option);

        makerListDropDowm.click();
        driver.findElement(By.xpath(makeListOption)).click();

    }


    @AfterMethod
    public void after() {

        driver.quit();
    }


}
