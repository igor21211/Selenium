import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageLogic {

    By productTittle = By.xpath("//h1[@class='product__title']");
    By promo = By.xpath("//span[contains(@class,'label_type_action')]");

    private WebDriver driver;
    private WebDriverWait wait;


    public ProductPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String productTittleText() {
        return driver.findElement(productTittle).getText();
    }


    public boolean chekPromo(){
        return driver.findElement(promo).isDisplayed();
    }

}
