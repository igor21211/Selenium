package lingyaleo.com;

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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LangTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://lingualeo.com/ru");
    }

    @Test
    public void testLanguage() throws InterruptedException {
        List<String> firstState = getListLanguage();

        clickRightBtn();

        List<String> afterRightClickArray = getListLanguage();

        Thread.sleep(3000);

        Assert.assertNotEquals(firstState,afterRightClickArray);

        Thread.sleep(3000);

        clickLeftBtn();

        List<String> afterLeftClickArray = getListLanguage();

        Assert.assertEquals(firstState,afterLeftClickArray);
    }

    public List<String> getListLanguage(){
        List<String> actualListlanguage = new ArrayList<>();
        List<WebElement> languageElement = driver.findElements(By.xpath("//div[contains(@class,'extra')]//div[contains(@class,'active')]"));
        for (WebElement element : languageElement) {
            String landuage = element.getAttribute("innerText");
            actualListlanguage.add(landuage);
        }
        return actualListlanguage;
    }

    public void clickRightBtn(){
        driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
    }

    public void clickLeftBtn(){
        driver.findElement(By.xpath("//button[@class='slick-arrow slick-prev']")).click();
    }

    @AfterMethod
    public void after(){

        driver.quit();
    }
}
