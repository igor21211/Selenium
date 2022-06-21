import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPageLogic {

    By laptopCategory = By.xpath("//img[@class=' ng-star-inserted ng-lazyloaded']");

    private WebDriver driver;
    private WebDriverWait wait;

    public CategoryPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public SearchPageLogic laptopCategoryClick(){
        driver.findElement(laptopCategory).click();
        return new SearchPageLogic(driver,wait);
    }
}
