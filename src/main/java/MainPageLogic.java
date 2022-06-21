import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By searchInput = By.xpath("//input[@name='search']");
    By btnSearch = By.xpath("//button[contains(text(), 'Найти')]");
    By compAndLaptopCatefory = By.xpath("//a[@class='menu-categories__link']");


    private WebDriver driver;
    private WebDriverWait wait;


    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MainPageLogic typeTextInSearchInput(String text) {
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public SearchPageLogic searchBtnClick() {
        driver.findElement(btnSearch).click();
        return new SearchPageLogic(driver, wait);
    }

    public CategoryPageLogic compAndLaptopCateforyClick(){
        driver.findElement(compAndLaptopCatefory).click();
        return new CategoryPageLogic(driver,wait);
    }



}
