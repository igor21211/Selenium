import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLogic {


    By tittleOfFirstProduct = By.xpath("//span[@class='goods-tile__title']");
    By rozetkaSellerSelectiom = By.xpath("//a[@data-id='Rozetka']");
    By maxPriceInput = By.xpath("//input[@formcontrolname= 'max']");
    By okBtnInPriceFilter = By.xpath("//button[@type='submit']");
    By firstPromoProduct = By.xpath("//span[contains(@class,'label_type_action')]/..");

    private WebDriver driver;
    private WebDriverWait wait;


    public SearchPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public String firstProductText(){
        String tittleText = driver.findElement(tittleOfFirstProduct).getText();
        return tittleText;
    }

    public ProductPageLogic firstProductClick(){
        driver.findElement(tittleOfFirstProduct).click();
        return new ProductPageLogic(driver,wait);
    }

    public  SearchPageLogic selectRozetkaSeller(){
        driver.findElement(rozetkaSellerSelectiom).click();
        return this;
    }

    public SearchPageLogic applyMaxPriceinFilter(String price) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(maxPriceInput)).clear();
        Thread.sleep(3000);
        driver.findElement(maxPriceInput).sendKeys(price);
        Thread.sleep(3000);
        driver.findElement(okBtnInPriceFilter).click();
        return this;
    }

    public ProductPageLogic firstPromoProductClick(){
        driver.findElement(firstPromoProduct).click();
        return new ProductPageLogic(driver,wait);
    }
}
