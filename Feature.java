import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import graphql.Assert;
import graphql.language.SelectionSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

class Feature {

    public static void main(String args[]) throws InterruptedException, IOException {

        FileReader reader = new FileReader("src/resources/config.properties");
        Properties p = new Properties();
        p.load(reader);
        String brandlist = p.getProperty("brandlist");
        String[] arrbrand = brandlist.split(",");

        System.setProperty(
                "webdriver.chrome.driver",
                p.getProperty("chromedriverPath"));
        // Instantiate a ChromeDriver class.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        SearchItems search = new SearchItems();
        addToCart cart = new addToCart();
        filter filterObj = new filter();


        for (String branditem : arrbrand) {

            search.OpenWebAndSearch(driver, p.getProperty("itemToBeSearched"));
            search.selectBrand(driver,branditem);

            filterObj.priceRange(driver,p.getProperty("minValue"), p.getProperty("maxValue"));


           cart.addToCartandVerify(driver);
        }
        driver.quit();
    }






}




