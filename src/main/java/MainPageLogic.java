import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By searchInput = By.xpath("");
    By btnSearch = By.xpath("");


    private WebDriver driver;
    private WebDriverWait wait;


    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MainPageLogic typeTextInSearchInpit(String text) {
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public SearchPageLogic searchBtnClick() {
        driver.findElement(btnSearch).click();
        return new SearchPageLogic(driver, wait);
    }
}
