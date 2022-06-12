package First;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFristTest {

    final Logger logger = LoggerFactory.getLogger(MyFristTest.class);


    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }


    @Test(description = "first test")
    public void myFirstTest() {
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }


    @Test(alwaysRun = true)
    public void mySecondTest() {
        System.out.println("Hello2");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }


    @AfterTest
    public void aftterTest() {
        System.out.println("AfterTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }


}
