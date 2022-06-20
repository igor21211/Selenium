import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLogic {


    By tittleOfFirstProduct = By.xpath("");

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
    public void getCheckGit(){

    }
}
