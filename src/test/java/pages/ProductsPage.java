package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "select[name='sort']")
    WebElement sortBy;

    String priceXpath = "//div[contains(@class, 'product-items-main')]/div[$]//span[@class='ppra_price-number']";

    public void sortBy(String sortingMethod) throws InterruptedException {
        selectByValue(sortBy, sortingMethod); //zakucaj "rastucie" i videcu dole gresku iz default-a iz switch-a
        Thread.sleep(5000);
    }

    //rastuca cena
    public void assertPriceAppending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(priceXpath.replace("$", "1"))).getText().replace(".", "")); //11.999 da skinemo tacku iz integera cene
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(priceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 <= cena2); //zanima me da li je ovo tacno
    }

    //opadajuca cena
    public void assertPriceDescending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(priceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(priceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 >= cena2);
    }

    //naziv
    //score
    //rejting

    public void verifyItemsAreSorted(String sortingMethod) throws Exception {
        switch (sortingMethod) {
            case "rastuci": {
                assertPriceAppending();
            }
            break;
            case "opadajuci": {
                assertPriceDescending();
            }
            break;
            case "naziv": {

            }
            break;
            case "rejting": {

            }
            break;
            case "score": {

            }
            break;
            default: throw new Exception("Sorting method option is not supported");
        }
    }
}
